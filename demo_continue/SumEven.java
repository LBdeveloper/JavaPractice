public class SumEven{
	public static void main(String[] args) {
		int sum = 0;
		// for(int i=1;i<=100;++i)
		// {
		// 	if(i%2==0)
		// 	{
		// 		if(i==50||i==60||i==80)
		// 		{
		// 			continue;
		// 		}
		// 		sum+=i;
		// 	}
		// }
		//这种写法不好，核心业务与外围验证耦合
		//可阅读性优于性能
		for(int i=0;i<=100;++i)
		{
			if(i == 50 || i == 60 || i == 80)
			{
				continue;
			}
			if( i%2 == 0)
			{
				sum+=i;
			}
		}
		System.out.println(sum);
	}
}