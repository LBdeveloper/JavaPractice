public class Logic
{
    public static void main(String[] args)
    {
            int a =10;
            int b =20;
            int d = 30;
            int c = a|b|d;

         boolean flag1 = (a&c) == a;
         boolean flag2 = (b&c) ==b;
         System.out.println(flag1);
         System.out.println(flag2);
         System.out.println(a&c);
    }
}
