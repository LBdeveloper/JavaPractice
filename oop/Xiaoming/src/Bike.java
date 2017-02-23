package util.vehicle;
import people.Person;
import util.constitute.University;

public class Bike{
	private String color;
	private String brand;

	public Bike(){

	}
	public Bike(String color,String brand){
		this.color = color;
		this.brand = brand;
	}

	public void go(Person person,University university){
		System.out.println(person+"骑着"+color+brand+"去"+university);
	}
}