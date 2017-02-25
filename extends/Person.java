public class Person {
	private String name;
	private int wealthy;

	public int getWealthy() {
		return wealthy;
	}

	public String getName() {
		return name;
	}

	public void wealthyIncrease() {
		if(wealthy<=Integer.MAX_VALUE&&wealthy>=0) {
			wealthy += 10000;
		}
	}

	public Person() {
		this.name = "zhangsan";
		this.wealthy = 100000000;
	}

	public Person(int wealthy,String name) {
		this.name = name;
		this.wealthy = wealthy;
	}

	public void move() {
		System.out.println("Person move");
	}
	

}