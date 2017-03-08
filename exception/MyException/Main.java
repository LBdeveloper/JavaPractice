public class Main {
	public static void main(String[] args) {
				try {
					Main.f1();
					System.out.println("opoo");
				} catch(NullPointerException e) {
					System.out.println("aaa");
				} catch(MyException e) {
					System.out.println("bbb");
				}
	}

	public static void f1() {
		System.out.println("f1() is called");
		throw new MyException("f1() exception");
	}
}