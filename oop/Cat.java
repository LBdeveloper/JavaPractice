public class Cat{
	private int speed;
	private String name;
	private Owner owner;

	public Cat(int speed,String name,Owner owner){
		this.name = name;
		this.speed = speed;
		this.owner = owner;
	}
	public Cat(){
		this(50,"Tom",new Owner());
	}

	public void move()
	{
		owner.run();
	}

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.move();
		
	}

}