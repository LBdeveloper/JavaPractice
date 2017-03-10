import java.util.ArrayList;

public class ATM {

	public static ArrayList<CreditCard> creditcards = new ArrayList<CreditCard>();
	// public static ArrayList<CreditCard> creditcards = (ArrayList<CreditCard>)
	// Collections
	// .synchronizedList(new ArrayList<CreditCard>());

	public void handler(String commend) {
		String[] parsed = commend.split(" ");
		if ("create".equals(parsed[0])) {
			// CreditCard creditcard = create(parsed);
			creditcards.add(create(parsed));
			// System.out.println("0000");
			// System.out.println(creditcards.size());
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
		if ("detail".equals(parsed[0])) {
			detail(parsed);
		}
		if ("query".equals(parsed[0])) {
			// System.out.println("queryquery");
			query(parsed);
		}
	}

	private CreditCard create(String[] parsed) {
		return new CreditCard(parsed[1]);
	}

	private void deposit(String[] parsed) {
		for (CreditCard c : creditcards) {
			if ((c.getId()) == Integer.parseInt(parsed[1])) {
				c.save(Double.parseDouble(parsed[2]));
			}
		}
	}

	private void draw(String[] parsed) {
		for (CreditCard c : creditcards) {
			if ((c.getId()) == Integer.parseInt(parsed[1])) {
				c.get(Double.parseDouble(parsed[2]));
			}
		}
	}

	private void transfer(String[] parsed) {
		for (CreditCard c : creditcards) {
			if ((c.getId()) == Integer.parseInt(parsed[1])) {
				CreditCard other = null;
				for (CreditCard t : creditcards) {
					if (t.getId() == Integer.parseInt(parsed[2])) {
						other = t;
					}
				}
				c.transfer(other, Double.parseDouble(parsed[3]));
			}
		}
	}

	private void detail(String[] parsed) {
		for (CreditCard c : creditcards) {
			if ((c.getId()) == Integer.parseInt(parsed[1])) {
				c.detail();
			}
		}
	}

	private void query(String[] parsed) {
		for (CreditCard c : creditcards) {
			if (0 == (c.getId()) - Integer.parseInt(parsed[1])) {
				// System.out.println(".......");
				c.query();
			}
		}
	}

}
