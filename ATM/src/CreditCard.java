import java.math.BigDecimal;
import java.util.ArrayList;

public class CreditCard {

	private double balance = 0.0;
	private BigDecimal exactbalance;
	// private LinkedList<Map<Date, String>> record = new LinkedList<Map<Date,
	// String>>();
	private ArrayList<Record> record = new ArrayList<Record>();
	private int id;

	private String username;

	private static int foundation = 8888;

	public CreditCard() {
		exactbalance = new BigDecimal(balance);
	}

	public CreditCard(String username) {
		this();
		this.username = username;
		id = foundation++;
		record.add(new Record("开户"));
		System.out.println("卡号：" + id);
	}

	public void save(double count) {
		if ((int) (count * 10) <= 0) {
			System.out.println("请存入正确金额");
			return;
		}
		exactbalance = exactbalance.add(new BigDecimal(count));
		System.out.println("已存入" + count + " 当前余额" + exactbalance.doubleValue());
		record.add(new Record("存款" + count + "元" + "余额" + exactbalance.doubleValue()));
	}

	public void get(double count) {
		if (count > exactbalance.doubleValue()) {
			System.out.println("余额不足");
			return;
		}
		exactbalance = exactbalance.subtract(new BigDecimal(count));
		System.out.println("已取" + count + "元" + "当前余额" + exactbalance.doubleValue());
		record.add(new Record("取款" + count + "元" + "余额" + exactbalance.doubleValue()));

	}

	public void transfer(CreditCard credictcard, double count) {
		if (null == credictcard) {
			return;
		}
		if (count > exactbalance.doubleValue()) {
			System.out.println("余额不足");
			return;
		}
		exactbalance = exactbalance.subtract(new BigDecimal(count));
		credictcard.transfered(this, count);
		System.out.println("已转" + count + "元" + "给" + credictcard.getId() + credictcard.getUsername() + "当前余额"
				+ exactbalance.doubleValue());
		record.add(new Record("转账" + count + "元给" + credictcard.id + "余额" + exactbalance.doubleValue()));
	}

	public void transfered(CreditCard credictcard, double count) {
		exactbalance = exactbalance.add(new BigDecimal(count));
		record.add(new Record(credictcard.id + "转账" + count + "元给本卡" + "余额" + exactbalance.doubleValue()));
	}

	public void detail() {
		for (Record r : record) {
			System.out.println(r.getDate() + r.getDesc());
		}
	}

	public void query() {
		System.out.println("当前余额" + exactbalance.doubleValue());
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
