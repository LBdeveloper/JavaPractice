public class Dog{
	private String name;
	private String color;
	private Person owner;

	public Dog(){

	}

	public Dog(String name,String color,Person owner){
		this.name = name;
		this.color = color;
		this.owner = owner;
	}
	public void run(){
		System.out.println(this.owner.getName()+"'s dog "+this.name+" is running");
	}

	public static void main(String[] args) {
		Person Tom = new Person("Tom","man",30);
		Dog dog = new Dog("wangcai","grey",Tom);
		dog.run();
	}


}