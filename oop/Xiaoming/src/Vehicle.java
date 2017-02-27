package util.vehicle;


import people.Person;
import util.constitute.University;

public abstract class Vehicle {
	
	protected String color;
	protected String brand;
	protected String type;
	protected int price;

	public Vehicle() {

	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setBrang(String brand) {
		this.brand = brand;
	}

	public String getBranf() {
		return brand;
	}

	public void go(Person person,University university){
		System.out.println(person+"骑着"+color+brand+"去"+university);
	}

}