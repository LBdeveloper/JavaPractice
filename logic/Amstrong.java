public class Amstrong
{
	public static void main(String args[])
	{
		for(int i=101;i<=999;++i)
		{
			int g = i%10;
			int s = (i/10)%10;
			int b = i/100;
			if(g*g*g+s*s*s+b*b*b==i)
			{
				System.out.println(i);
			}
		}

	}
}