import java.util.Scanner;
public class cal{
	public static void main(String args[])
	{
		Scanner sc  = new Scanner(System.in);
		char symbol = sc.next().charAt(0);

		int a = 100;
		int b = 200;
		if('+'==symbol)
		{
			System.out.println(a+b);
		}else if('-'==symbol){
			System.out.println(a-b);
		}else if('*'==symbol)
		{
			System.out.println(a*b);
		}
		else if('/'==symbol)
		{
			System.out.println(a/b);
		}
	}
}