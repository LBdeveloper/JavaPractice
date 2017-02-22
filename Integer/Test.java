public class Test {
	// public static void overLoad(int a,int b) {
	// 	System.out.println("调用到了overLoad(int a,int b)");
	// }

	// public static void overLoad(Integer a,Integer b) {
	// 	System.out.println("调用到了overLoad(Integer a,Integer b)");	
	// }

	// public static void overLoad(int a,Integer b) {
	// 	System.out.println("调用到了overLoad(int a,Integer b)");	
	// }

	public static void overLoad(int ...a) {
		System.out.println("调用到了overLoad(int ...a)");

	}

	public static void main(String[] args) {
		//Test.overLoad(1,1);
		//Test.overLoad(new Integer(1),1);
		// Test.overLoad(1,new Integer(1));
		// Test.overLoad(new Integer(1),new Integer(1));
		Test.overLoad(new Integer(1),new Integer(2),new Integer(3));
	}

}