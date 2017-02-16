public class Sub implements Operator{
	private int op;
	private int opd;

	public Sub(int op,int opd)
	{
		this.op =  op;
		this.opd = opd;
	}
	public Sub()
	{
		this(0,0);
	}
	public int operator()
	{
		return op-opd;
	}


}