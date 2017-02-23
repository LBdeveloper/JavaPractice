package people;
public class Person{
	private int age;
	private String location;
	private String name;
	public Person(){

	}

	public Person(int age,String location,String name){
		this.age = age;
		this.name = name;
		this.location = location;
	}

    public String toString(){
    	return "家住"+location+"的"+age+"的"+name;
    }

}