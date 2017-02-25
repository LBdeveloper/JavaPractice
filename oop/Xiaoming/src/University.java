package util.constitute;
import util.computer.Laptop;
import util.computer.Computer;
import util.edu.Examination;
import people.Person;

public class University{
	private String name;
	private String location;

	public University(){

	}

	public University(String name,String location){
		this.name = name;
		this.location = location;
	}

	public void test(Computer laptop,Person person,Examination examination){
		System.out.println(""+person+"用"+laptop+"解答"+examination);
		examination.done();
	}
	public String toString(){
		return location+"的"+name;
	}

}