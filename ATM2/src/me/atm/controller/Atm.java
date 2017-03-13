package me.atm.controller;

import java.util.ArrayList;

import me.atm.bean.Detail;
import me.atm.bean.User;
import me.atm.dao.Dao;
import me.atm.exception.FailOperateException;
import me.atm.exception.FailToDepositException;

public class Atm {
	private static int identifer = 1000;
	private int sidentifer;

	public Atm() {
		sidentifer = identifer++;
	}

	public void handler(String commend) {
		String[] parsed = commend.split(" ");
		try {
			if ("create".equals(parsed[0])) {
				User user = createUser(parsed[1]);
				if (null != user) {
					System.out.println("创建成功！您的账户信息");
					System.out.println(user);
				}
			}
			if ("deposit".equals(parsed[0])) {
				deposit(parsed);
			}
			if ("draw".equals(parsed[0])) {
				draw(parsed);
			}
			if ("transfer".equals(parsed[0])) {
				transfer(parsed);
			}
			if ("query".equals(parsed[0])) {
				// System.out.println("queryquery");
				User user = query(parsed);
				System.out.println(user);
			}
			if ("detail".equals(parsed[0])) {
				ArrayList<Detail> ad = detail(parsed);

				for (Detail a : ad) {
					System.out.println(a);
				}
			}
		} catch (FailOperateException foe) {
			System.out.println(foe.getMessage());
		}
	}

	private ArrayList<Detail> detail(String[] parsed) {
		long card_id = Long.parseLong(parsed[1]);
		ArrayList<Detail> ad = null;
		ad = Dao.detail(card_id);
		return ad;
	}

	private User query(String[] parsed) {
		User user = null;
		long card_id = Long.parseLong(parsed[1]);
		user = Dao.query(card_id);
		return user;
	}

	private void transfer(String[] parsed) {

		long card_id1 = Long.parseLong(parsed[1]);
		long card_id2 = Long.parseLong(parsed[2]);
		double change = Double.parseDouble(parsed[3]);
		User user1 = new User(card_id1);
		User user2 = new User(card_id2);

		Dao.transfer(user1, user2, change);

	}

	private void draw(String[] parsed) {

		long card_id = Long.parseLong(parsed[1]);
		double change = Double.parseDouble(parsed[2]);
		if (change < 0) {
			throw new FailToDepositException("金额错误");
		}
		User user = new User(card_id);
		Dao.draw(user, change);
	}

	private void deposit(String[] parsed) {

		long card_id = Long.parseLong(parsed[1]);
		double change = Double.parseDouble(parsed[2]);
		if (change < 0) {
			throw new FailToDepositException("金额错误");
		}
		User user = new User(card_id);
		Dao.deposit(user, change);

	}

	private User createUser(String name) {
		User user = new User(name);

		Dao.createUser(user);

		// System.out.println(foe.getMessage());

		return user;
	}

}
