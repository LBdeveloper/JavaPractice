public class Constructor{


	String name = null;
	public int a = 300;

	public Constructor(int x,int y){
		System.out.println("含参构造器");
	}
	public Constructor(){
		//System.out.println("无参构造器");
		this.fun1();
		this.fun2();
		this.fun3();
	}

	public Constructor(int a){
		System.out.println(a);
		System.out.println(this.a);
	}



	public void fun1(){
		System.out.println("fun1()");
	}

	public void fun2(){
		System.out.println("fun2()");
	}

	public void fun3(){
		System.out.println("fun3()");
	}

	

public static void main(String[] args) {
	
	Constructor constructor = new Constructor();


}


}