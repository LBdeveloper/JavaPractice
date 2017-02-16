public class Div implements Operator
{
	private int op;
	private int opd;

	public Div()
	{
		this(0,1);
	}
	public Div(int op,int opd)
	{
		this.op = op;
		this.opd = opd;
	}
	public int operator()
	{
		return op/opd;
	}
}