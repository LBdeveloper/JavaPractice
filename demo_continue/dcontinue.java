public class dcontinue
{
	public static void main(String[] args) {
		 outer: for(int i = 0;i <= 100;++i)
		{
			for(int j = 0;j<=100;++j)
			{
				if(j == 66){
				System.out.println("跳出内层"+i);
				break outer;

			    }
			}
		}
	}
}