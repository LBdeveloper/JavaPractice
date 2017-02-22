import java.util.Scanner;
public class Test{
	public static void main(String[] args) {

		// char x = 1;
		// switch(x){
		// 	case 1 : 
		// 	System.out.println("case1");
		// 	break;
		// 	case 2 : 
		// 	System.out.println("case2");
		// 	break;
		// 	case 3 : 
		// 	System.out.println("case3");
		// 	break;
		// 	case 4 : 
		// 	System.out.println("case4");
		// 	break;
			
		// }
		//jdk7后switch可以比较整数，字符，字符串，enum,但是long不接受，会发生类型问题

		// Scanner sc = new Scanner(System.in);
		// String wholeline = sc.nextLine();
		// System.out.println("刚刚您输入了"+wholeline);//读入一整行，以回车为界
		// String line = sc.next(); //读入输入字符串，以空格或换行分割

		int num = 9;

		
		move(num);
		System.out.println(num);



	}
	public static void move(int a){
			a = 5;
			System.out.println(a);
		}
}