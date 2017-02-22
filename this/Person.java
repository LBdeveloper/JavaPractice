public class Person {

	private String name;

	public Person(String name) {
		this.name = name;

	}
	public void move() {
		walk(this);

	}

	public void walk(Person p) {
		System.out.println(p.name+"is walking");
	}

	public static void main(String[] args) {
		Person p = new Person("Xiaoming");

		p.move();

	}
}