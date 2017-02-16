public class OopCal
{
	
	private int op;

	public OopCal(int op)
	{
		this.op = op;
	}
	public OopCal()
	{
		this.op = 0;
	}

	public int add(OopCal opd)
	{
		return op+opd.getOp();
	}

	public int sub(OopCal opd)
	{
		return op-opd.getOp();
	}	

	public int mul(OopCal opd)
	{
		return op*opd.getOp();
	}

	public int div(OopCal opd)
	{
		return op/opd.getOp();
	}

	public void setOp(int x)
	{
		op = x;
	}

	public int getOp()
	{
		return op;
	}






public static void main(String[] args) {
	
	OopCal oopCal = new OopCal(100);
	OopCal oopCaled = new OopCal(2);
	int result = oopCal.div(oopCaled);

	System.out.println(result);

}


}