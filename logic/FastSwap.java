public class FastSwap
{
	public static void main(String[] args)
	{
		int a = 100;
		int b = 200;
		b=b^a;
		a=b^a;
		b=b^a;
		System.out.println(a+" "+b);
	}
}
