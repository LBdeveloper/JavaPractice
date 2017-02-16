import java.util.Scanner;
public class Cal_switch{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		String symbol = sc.next();
		do
		{
			int a = 100;
			int b = 200;
		switch(symbol)
			{
			case "+":
				System.out.println(a+b);
				break;
			case "-":
				System.out.println(a-b);
				break;
			case "*":
				System.out.println(a*b);
				break;
			case "/":
				System.out.println(a/b);
				break;
			}
			 symbol = sc.next();
		}
		while(!("#".equals(symbol)));
	}

}