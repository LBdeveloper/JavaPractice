public class Mul implements Operator
{
	private int op;
	private int opd;

	public Mul()
	{
		this(0,1);
	}
	public Mul(int op,int opd)
	{
		this.op = op;
		this.opd = opd;
	}

	public int operator()
	{
		return op*opd;
	}
}