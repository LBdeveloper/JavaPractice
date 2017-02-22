public class Owner{
	private int speed = 20;
	private String name = null;

	public Owner(){
		this(20,"张三");
	}

	public Owner(int speed,String name){
		this.name = name;
		this.speed = speed;
	}

	public void run(){
		System.out.println(this.name+" is running "+this.speed+" miles per hour");
	}

}