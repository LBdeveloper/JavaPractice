import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		System.out.println("please input the commend:");
		Scanner sc = new Scanner(System.in);
		while (true) {
			String commend = sc.nextLine();
			commend.trim();
			new ATM().handler(commend);
		}

	}
}
