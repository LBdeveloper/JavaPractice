package util.vehicle;

import people.Person;
import util.constitute.University;

public class Bike extends Vehicle {
	private String type;
	private int price;

	public Bike(){
		this.price = 500;
		this.type = "bike";
	}
	public Bike(String color,String brand){
		this();
		this.color = color;
		this.brand = brand;
	}

	public void go(Person person,University university){
		System.out.println(person+"骑着"+color+brand+"去"+university);
	}
}