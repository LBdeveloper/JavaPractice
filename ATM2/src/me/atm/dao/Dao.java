package me.atm.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import me.atm.bean.Detail;
import me.atm.bean.User;
import me.atm.exception.FailToCreateException;
import me.atm.exception.FailToDepositException;
import me.atm.exception.FailToDrawException;
import me.atm.exception.FailToQueryException;
import me.atm.exception.FailToTransferException;

public class Dao {

	private static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/atm";
		String username = "root";
		String password = "123456";

		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static ArrayList<Detail> detail(long card_id) {
		Connection conn = null;
		ArrayList<Detail> al = new ArrayList<Detail>();
		String sql = "select id,user_id,card_id,amount,date,des from detail where card_id = ?";
		PreparedStatement ps = null;
		try {

			conn = getConn();
			// System.out.println(conn.getAutoCommit());
			ps = conn.prepareStatement(sql);
			ps.setLong(1, card_id);
			ResultSet rs = ps.executeQuery();
			// System.out.println(conn.getAutoCommit());
			while (rs.next()) {
				al.add(new Detail(rs.getInt(1), rs.getInt(2), rs.getLong(3), rs.getBigDecimal(4), rs.getTimestamp(5),
						rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
			close(conn);
			return al;
		}
	}

	public static void deposit(User user, double change) {
		Connection conn = null;
		PreparedStatement ps_save = null;
		PreparedStatement ps_detail = null;
		String sql_save = "update user set balance = balance + ? where card_id = ?";
		String sql_detail = "insert into detail(user_id,card_id,amount,date) values(?,?,?,?)";

		try {
			conn = getConn();
			ps_save = conn.prepareStatement(sql_save);
			ps_detail = conn.prepareStatement(sql_detail);

			ps_save.setBigDecimal(1, new BigDecimal(change));
			ps_save.setLong(2, user.getCard_id());

			ps_detail.setInt(1, user.getId());
			ps_detail.setLong(2, user.getCard_id());
			ps_detail.setBigDecimal(3, new BigDecimal(change));
			ps_detail.setTimestamp(4, new Timestamp(new Date().getTime()));

			ps_save.executeUpdate();
			ps_detail.executeUpdate();

			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new FailToDepositException("存钱失败");

		} finally {
			close(ps_save);
			close(ps_detail);
			close(conn);
		}

	}

	public static void transfer(User user1, User user2, double change) {
		Connection conn = null;
		PreparedStatement ps_sub = null;
		PreparedStatement ps_add = null;
		PreparedStatement ps_query = null;
		PreparedStatement ps_detail = null;
		String sql_sub = "update user set balance = balance-? where card_id = ? and balance= ?";
		String sql_add = "update user set balance = balance+? where card_id = ? and balance= ?";
		String sql_detail = "insert into detail(user_id,card_id,amount,date,des) values(?,?,?,?,?)";

		try {
			conn = getConn();

			ps_add = conn.prepareStatement(sql_add);
			ps_sub = conn.prepareStatement(sql_sub);
			ps_detail = conn.prepareStatement(sql_detail);

			String sql_query = "select balance from user where card_id = ? for update";

			ps_query = conn.prepareStatement(sql_query);
			ps_query.setLong(1, user1.getCard_id());
			ResultSet rs = ps_query.executeQuery();

			BigDecimal bd1 = null;
			while (rs.next()) {
				bd1 = rs.getBigDecimal(1);
				if (bd1.doubleValue() - change < 0.0) {
					throw new FailToTransferException("余额不足");
				}
			}

			BigDecimal bd2 = null;
			ps_query.setLong(1, user2.getCard_id());
			rs = ps_query.executeQuery();
			while (rs.next()) {
				bd2 = rs.getBigDecimal(1);
			}

			ps_sub.setBigDecimal(1, new BigDecimal(change));
			ps_sub.setLong(2, user1.getCard_id());
			ps_sub.setBigDecimal(3, bd1);

			ps_add.setBigDecimal(1, new BigDecimal(change));
			ps_add.setLong(2, user2.getCard_id());
			ps_add.setBigDecimal(3, bd2);

			ps_detail.setInt(1, user1.getId());
			ps_detail.setLong(2, user1.getCard_id());
			ps_detail.setBigDecimal(3, new BigDecimal(0.0).subtract((new BigDecimal(change))));
			ps_detail.setTimestamp(4, new Timestamp(new Date().getTime()));
			ps_detail.setString(5, "转账");

			ps_sub.execute();
			ps_detail.execute();

			ps_detail.setInt(1, user2.getId());
			ps_detail.setLong(2, user2.getCard_id());
			ps_detail.setBigDecimal(3, new BigDecimal(change));
			ps_detail.setTimestamp(4, new Timestamp(new Date().getTime()));
			ps_detail.setString(5, "转账");

			ps_add.execute();
			ps_detail.execute();

			conn.commit();

		} catch (FailToTransferException fe) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			throw new FailToTransferException("余额不足");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new FailToTransferException("转账失败");
		} finally {
			close(ps_add);
			close(ps_sub);
			close(ps_detail);
			close(ps_query);
			close(conn);
		}
	}

	public static void draw(User user, double change) {
		Connection conn = null;
		PreparedStatement ps_draw = null;
		PreparedStatement ps_detail = null;
		PreparedStatement ps_query = null;
		String sql_draw = "update user set balance = balance - ? where card_id = ? and balance=?";
		String sql_detail = "insert into detail(user_id,card_id,amount,date) values(?,?,?,?)";

		try {
			conn = getConn();
			ps_draw = conn.prepareStatement(sql_draw);
			ps_detail = conn.prepareStatement(sql_detail);

			ps_draw.setBigDecimal(1, new BigDecimal(change));
			ps_draw.setLong(2, user.getCard_id());

			String sql_query = "select balance from user where card_id = ? for update";
			ps_query = conn.prepareStatement(sql_query);
			ps_query.setLong(1, user.getCard_id());
			ResultSet rs = ps_query.executeQuery();

			BigDecimal bd = null;
			while (rs.next()) {
				bd = rs.getBigDecimal(1);
				if (bd.doubleValue() - change < 0.0) {
					throw new FailToDrawException("余额不足");
				}
			}

			ps_draw.setBigDecimal(1, new BigDecimal(change));
			ps_draw.setLong(2, user.getCard_id());
			ps_draw.setBigDecimal(3, bd);

			ps_detail.setInt(1, user.getId());
			ps_detail.setLong(2, user.getCard_id());
			ps_detail.setBigDecimal(3, new BigDecimal(0.0).subtract((new BigDecimal(change))));
			ps_detail.setTimestamp(4, new Timestamp(new Date().getTime()));

			ps_draw.execute();
			ps_detail.execute();

			conn.commit();

		} catch (FailToDrawException fe) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			throw new FailToDrawException("余额不足");

		}

		catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new FailToDrawException("取款失败");
		} finally {
			close(ps_detail);
			close(ps_draw);
			close(ps_query);
			close(conn);
		}
	}

	public static void createUser(final User user) {

		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps_q = null;
		PreparedStatement ps_q2 = null;
		String sql = "insert into user(id,username,balance) values(?,?,?)";
		String sql_q = "select max(id) from user";
		String sql_q2 = "select card_id from user where id = ?";
		try {
			conn = getConn();

			ps_q = conn.prepareStatement(sql_q);
			ResultSet rs;
			rs = ps_q.executeQuery();

			// System.out.println("qqqqqqqq");

			int id = 0;
			while (rs.next()) {
				id = rs.getInt(1) + 1;
			}

			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, user.getUsername());
			ps.setBigDecimal(3, user.getBalance());
			// System.out.println("uiuuu");
			ps.executeUpdate();

			ps_q2 = conn.prepareStatement(sql_q2);
			ps_q2.setInt(1, id);
			rs = ps_q2.executeQuery();
			long card_id = 0L;
			while (rs.next()) {
				card_id = rs.getLong(1);
			}

			user.setId(id);
			user.setCard_id(card_id);

			conn.commit();

		} catch (SQLException e) {
			// System.out.println("rrrrr");
			// e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new FailToCreateException("创建失败");
		} finally {
			// close(ss);
			close(ps);
			close(ps_q);
			close(ps_q2);
			close(conn);
		}
	}

	public static User query(long card_id) {
		Connection conn = null;
		PreparedStatement ps_query = null;
		String sql = "select id,username,card_id,balance from user where card_id = ?";
		User user = null;
		try {
			conn = getConn();
			ps_query = conn.prepareStatement(sql);
			ps_query.setLong(1, card_id);

			ResultSet rs = ps_query.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getBigDecimal(4));
			}
			if (null == user) {
				throw new FailToQueryException("账号错误");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new FailToQueryException("无法查询");
		} finally {
			close(ps_query);
			close(conn);
			return user;
		}
	}

	public static ArrayList<User> getAllUser() {
		Connection conn = null;
		ArrayList<User> al = new ArrayList<User>();
		String sql = "select id,username,card_id,balance from user";
		PreparedStatement ps = null;
		try {

			conn = getConn();
			// System.out.println(conn.getAutoCommit());
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// System.out.println(conn.getAutoCommit());
			while (rs.next()) {
				al.add(new User(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getBigDecimal(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
			close(conn);
		}
		return al;

	}

	private static void close(PreparedStatement ps) {
		if (null != ps) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void close(Connection conn) {

		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		// Connection c = getConn();
		// System.out.println(c.getAutoCommit());
		// c.close();
		/*
		 * ArrayList<User> al = getAllUser(); for (User t : al) {
		 * System.out.println(t); }
		 */

		// createUser(new User("Bill"));
		// User user1 = new User(100, "Bill", 6220000000000000002L, new
		// BigDecimal(0.0));
		// User user2 = new User(10, "JACK", 105435645L, new BigDecimal(0.0));
		// transfer(user1, user2, 3);
		// User user = query(6220000000000000003L);
		// System.out.println(user);
		// User u = new User("ZY");
		// createUser(u);
		// System.out.println(u);

	}
}
