public class Anonymous {
	Object obj = new Object() {
		public String toString() {
			return "一个简单的范例";
		}
	};
	public static void main(String[] args) {
		Anonymous anm = new Anonymous();
		System.out.println(anm.obj);	
	}
}