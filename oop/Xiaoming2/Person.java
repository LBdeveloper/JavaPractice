public class Person{
	private int age;
	private String name;
	private Vehical vehical;
	private String gender;
	
	public Person(int age,String name,String gender){
		this.age = age ;
		this.gender = gender ; 
		this.vehical = vehical ;
		this.name = name;
	}
	public void goToSchool(){
		Vehical v = new Vehical("RED","ofo",this);
		v.move();
	}

	public String toString(){
		return age+"岁的"+gender+""+name;
	}


}