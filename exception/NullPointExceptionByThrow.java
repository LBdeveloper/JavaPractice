public class NullPointExceptionByThrow {
	public static void main(String[] args) {
		try {
			Person3 p4 = new Person3();
			p4 = null;
			System.out.println(Person3.print(p4));
		} catch (NullPointException2 e) {
			System.out.println(e.getMessage());
		}
	}
}

class Person3 {
	public static String print(Person3 p) throws NullPointException2 {
		if (null == p) {
			throw new NullPointException2("对象不能为空");
		} 
		return " ";
	}
	
}

@SuppressWarnings("serial")
class NullPointException2 extends Exception {
	public NullPointException2() {
		super();
	}

	public NullPointException2(String warning) {
		super(warning);
	}
}
