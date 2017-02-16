import java.util.Scanner;
public class Add implements Operator
{
	private int op;
	private int opd;
	public Add(int op,int opd)
	{
		this.op = op;
		this.opd = opd;
	}
	public Add()
	{
		this(10,10);
	}

	public int operator()
	{
		return op+opd;
	}
	public int operator(int x,int y)
	{
		return x+y;
	}

	public static void main(String[] args) {
		int x,y;
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		 Operator add = new Add(x,y);
		// Operator sub = new Sub(x,y);
		// Operator mul = new Mul(x,y);
		// Operator div = new Div(x,y);
		// int result_add = add.operator();
		// int result_sub = sub.operator();
		// int result_mul = mul.operator();
		// int result_div = div.operator();
		// System.out.println(result_add);
		// System.out.println(result_sub);
		// System.out.println(result_mul);
		// System.out.println(result_div);
		 System.out.println(add.operator(99,1));


	}
}