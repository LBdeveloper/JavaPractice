package me.atm.bean;

import java.math.BigDecimal;

public class User {

	private int id;
	private String username;
	private long card_id;
	private BigDecimal balance;

	public User(int id, String username, long card_id, BigDecimal balance) {
		super();
		this.id = id;
		this.username = username;
		this.card_id = card_id;
		this.balance = balance;
	}

	public User(String username) {
		this.username = username;
		balance = new BigDecimal(0.0);
	}

	public User(long card_id) {
		// TODO Auto-generated constructor stub
		this.card_id = card_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getCard_id() {
		return card_id;
	}

	public void setCard_id(long card_id) {
		this.card_id = card_id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String toString() {
		return "id:\t" + id + "\tusername:\t" + username + "\tcard_id:\t" + card_id + "\tbalance:\t" + balance;
	}

}
