public class NullPointExceptionByThrow2 {
	@SuppressWarnings("null")
	public static void main(String[] args) {
		try {
			Person4 p5 = new Person4();
			p5 = null;
			System.out.println(p5.print(p5));
		} catch (NullPointException3 e) {
			System.out.println(e.getMessage());
		}
	}
}

class Person4 {
	public String print(Person4 p) throws NullPointException3 {
		if (null == p) {
			throw new NullPointException3("对象不能为空");
		} 
		return " ";
	}	
}

@SuppressWarnings("serial")
class NullPointException3 extends NullPointerException {
	public NullPointException3() {
		super();
	}

	public NullPointException3(String warning) {
		super(warning);
	}
}
