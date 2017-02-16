import java.util.Scanner;
public class Fibonacci
{
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int month = sc.nextInt();
		for(int i=1;i<=month;++i)
		{
			System.out.println(fun(i));
		}
	}

	public static int fun(int fn)
	{
		if(fn==0||fn==1)
			return fn;
		else
			return fun(fn-1)+fun(fn-2);
	}
}