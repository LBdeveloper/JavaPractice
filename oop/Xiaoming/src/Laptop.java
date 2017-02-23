package util.computer;
public class Laptop{
	private String brand;
	private int price;
	private String color;

	public Laptop(){

	}

	public Laptop(String brand,int price,String color){
		this.brand = brand;
		this.price = price;
		this.color = color;
	}

	public String toString(){
		return ""+price+"的"+brand+"牌"+color+"色"+"笔记本电脑";
	}
}