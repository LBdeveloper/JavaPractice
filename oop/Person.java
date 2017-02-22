public class Person{

	private String name;
	private String gender;
	private int age;

	public Person(){

	}

	public Person(String name,String gender,int age){
		this.age = age;
		this.gender = gender;
		this.name = name;
	}

	public String getName(){
		return this.name;
	}
	public String getGender(){
		return this.gender;
	}
	public int getAge(){
		return this.age;
	}
}