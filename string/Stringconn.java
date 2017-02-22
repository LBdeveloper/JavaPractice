public class Stringconn{
	public static void main(String[] args){
		// String s = "Java";
		// String s1 = (new StringBuilder()).append(s).append("World").toString();
		// System.out.println(s1);

		StringBuilder sb = new StringBuilder();
		for(int i=1;i<100;++i){
			sb.append(i).append("+");
		}
		sb.append(100);
		System.out.println(sb);

	}
}