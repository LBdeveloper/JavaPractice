package me.atm.bean;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Detail {

	private int id;
	private int user_id;
	private long card_id;
	private BigDecimal amount;
	private Date date;
	private String des;

	public Detail(int id, int user_id, long card_id, BigDecimal amount, Date date, String des) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.card_id = card_id;
		this.amount = amount;
		this.date = date;
		this.des = des;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Detail() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public long getCard_id() {
		return card_id;
	}

	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String toString() {
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		return "id\t" + id + "\tcard_id\t" + card_id + "\tamount\t" + amount + "\tdate" + df.format(date) + "\tdes\t"
				+ des;
	}

}
