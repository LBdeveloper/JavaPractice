public class Test{
	public static void main(String[] args) {
		char[] x = {'a','b','c','d','e'};
		String s = new String(x);
		System.out.println(s);

		System.out.println(x);
		char[] cc = s.toCharArray();
		System.out.println(cc);
	}
}
