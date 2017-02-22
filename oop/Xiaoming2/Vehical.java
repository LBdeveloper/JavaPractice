public class Vehical{
	private String color;
	private String brand;

	private Person person;

	public Vehical(String color,String brand,Person person){
		this.color = color ; 
		this.brand = brand ;
		this.person = person ;
	}

	public void move(){
		System.out.println(person+"去学校"); 
	}

}