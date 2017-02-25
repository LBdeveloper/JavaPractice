public class Dog extends Person {
	private String name;
	private String color;

	public Dog() {
		super();
		this.name = "wangcai";
		this.color = "white";
	}

	public String getName() {
		return this.name;
	}

	public void sayWang() {
		System.out.println("wang wang ");
	}

	public void spsForDog() {
		System.out.println("dog do person not");
		super.move();
	}

	public void move() {
		System.out.println("Dog move");
	}
	public String toString() {
		return super.toString();
	}



}