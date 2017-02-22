public class Test{
	int x;
	static int y=999;
	Test(){
		x = 100;
	}
	public void fun()
	{
		System.out.println(y);
	}

	public void  test()
	{
		System.out.println(this.y);
		System.out.println(Test.y);
	}

	public int t()
	{
		return x;
	}

public static void main(String[] args) {
	Test t = new Test();
	// System.out.println(t.x);
	// System.out.println(t.y);
	// System.out.println(Test.y);
	// t.fun();

	// int o = t.x;

	t.test();

	}

}