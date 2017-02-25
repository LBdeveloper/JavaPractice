package people;
import util.vehical.Car;
public class Person {
	String name;
	Car car;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Car getCar() {
		return car;
	}

	public Person() {
		this("xiaoming",new Car());
	}

	public Person(String name,Car car) {
		this.name = name;
		this.car = car;
	}

	public String toString() {
		return name+"'s car is "+car;
	}

}