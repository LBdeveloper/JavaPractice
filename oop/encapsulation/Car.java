public class Car {
	private int price;
	private String brand;
	private boolean isMoving;

	private Driver driver;

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return this.brand;
	}

	public boolean isMoving() {
		return isMoving;
	}

	public void setIsMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	public String toString() {
		return this.getBrand()+this.getPrice()+this.isMoving();
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Driver getDriver() {
		return driver;	
	}

	public void moveCar() {
		System.out.println(driver+"is driving the car");
	}

	public void moveCar(Driver driver) {
		System.out.println(driver+"is driving the car");
	}

	public static void main(String[] args) {

		Car car = new Car();
		car.setBrand("audio");
		car.setPrice(300000);
		car.setIsMoving(true);

		//System.out.println(car);

		Driver xiaoming = new Driver();
		xiaoming.setName("小明");
		car.setDriver(xiaoming);
		car.moveCar(new Driver());
		car.moveCar();












	}


}