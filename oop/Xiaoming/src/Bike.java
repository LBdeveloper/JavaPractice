package util.vehicle;


public class Bike extends Vehicle {
	

	public Bike(){
		this.price = 500;
		this.type = "bike";
	}
	public Bike(String color,String brand){
		this();
		this.color = color;
		this.brand = brand;
	}

	
}