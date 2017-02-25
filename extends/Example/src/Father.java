package obj.man;
public class Father {
	public String name = "laozhang";

	public Father() {
		System.out.println("父类构造函数执行");
	}

	{
		System.out.println("父类构造代码块执行");
	}

	static {
		System.out.println("父类静态代码块执行");
	}

}