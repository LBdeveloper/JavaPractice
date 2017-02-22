public class Owner {
	String name;
	Dog dog = new Dog();

	public void move() {
		dog.desc(this);
		dog.desc(new Owner());
	}
}