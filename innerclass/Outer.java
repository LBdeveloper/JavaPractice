public class Outer{

private int x = 999;
	public Inner getInner(){
		return new Inner();
	}

	public class Inner{
		int x = 100;
		public int getOuterVariable()
		{
			return Outer.this.x;
		}
		public void print(String Str){
			System.out.println(Str);
		}
	}

	public static void main(String[] args) {
		// Outer outer = new Outer();
		// Outer.Inner inner = outer.new Inner();
		// inner.print("Outer.new");

		// inner = outer.getInner();
		// inner.print("Outer.get");

		Inner inner =  new Outer().new Inner();
		// inner.print("lalala");
		System.out.println(inner.getOuterVariable());


	}
}