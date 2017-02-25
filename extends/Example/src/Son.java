package obj.man;
public class Son extends Father {
	public String name = "zhangsan";

	public Son() {
		System.out.println("子类构造函数执行");
	}

	{
		System.out.println("子类构造代码块执行");
	}

	static {
		System.out.println("子类静态代码块执行");
	}
	
}