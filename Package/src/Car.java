package util.vehical;
public class Car {
	
	private String brand;
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Car() {
		this("audio",300000);
	}

	public Car(String brand,int price) {
		this.price = price;
		this.brand = brand;
	}

	public String toString() {
		return brand+" cost "+price;
	}

}