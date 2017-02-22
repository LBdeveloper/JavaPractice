public class DemoWrap{
	public static void main(String[] args) {
		


		/*
		 Integer i = null;
		 int j = i;
		可以通过编译，但是无法运行，说明自动装箱、拆箱是语法糖。
		其实际执行过程类似如下
		Object localObject = null;
		int i = localObject.intValue();
		*/

		Integer i1 = 127;
		Integer i2 = 127;

		System.out.println(i1 == i2);



	}
}