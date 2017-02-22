public class DemoStaticBlock{
	public DemoStaticBlock(){
		this(100);
		System.out.println("DemoStaticBlock()  Constructor");
	}

	public DemoStaticBlock(int x){
		System.out.println("DemoStaticBlock(int x) Constructor");
	}

	{
		System.out.println("对象初始化区块");
	}

}