public class Test {

		public void changeValue(String s) {
			s+="ABC";
			System.out.println(s);

		}

	public void changeValue(Person person){
		person.name += "OK";
		System.out.println(person.name);

	}
	public static void main(String[] args) {
		Person person = new Person();
		person.name = "Jack";
		Test test = new Test();
		//test.changeValue(person);

		//System.out.println(person.name);


		String sss = new String("Tom");
		test.changeValue(sss);
		System.out.println(sss);

// 常量存储（constant storage）。常量值通常直接存放在程序代码内部，这样做是安全的，因为它们永远不会被改变。有时，在嵌入式系统中，常量本身会和其他部分分割离开，所以在这种情况下，可以选择将其放在ROM中  

// ------存放字符串常量和基本类型常量（public static final）
	}
}