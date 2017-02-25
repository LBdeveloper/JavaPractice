package util.computer;
public class Laptop extends Computer {
	private String type;
	public Laptop(){
		this.type = "laptop";
	}

	public Laptop(String brand,int price,String color){
		this();
		this.brand = brand;
		this.price = price;
		this.color = color;
	}

	public String toString(){
		return ""+price+"的"+brand+"牌"+color+"色"+"笔记本电脑";
	}
}