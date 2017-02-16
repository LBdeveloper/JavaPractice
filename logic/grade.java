import java.util.Scanner;
public class grade{
	public static void main(String[] args)
	{
			Scanner sc = new Scanner(System.in);
			int grade  = sc.nextInt();
		do{
			
			
			if(grade >= 90 && grade<=100){
			System.out.println("优");
			}
			if(grade >= 70 && grade <= 89){
				System.out.println("良");
			}if(grade >= 60 && grade<=69)
			{
				System.out.println("及格");
			}if(grade >=0 && grade<=59)
			{
				System.out.println("不及格");
			}if(grade < 0 || grade>100)
			{
				System.out.println("无效的输入");
			}
			 grade = sc.nextInt();
		}
		while(grade != -1);
		}

	}

/*
	保持好的代码风格
*/