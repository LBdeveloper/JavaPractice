import util.constitute.University;
import util.vehicle.Bike;
import people.Person;
import util.computer.Laptop;
import util.edu.Question;
import util.edu.Examination;

public class Main{
	public static void main(String[] args) {
		University university = new University("浦口外国语大学","星火路9号");
		Bike bike = new Bike("蓝色","ofo");
		Person xaioming = new Person(21,"南京市浦口区天润城","小明");

		bike.go(xaioming,university);

		Laptop thinkPad = new Laptop("ThinkPad",8800,"黑");
		Question question[] =  {new Question(10,"选择题"),new Question(5,"判断题"),new Question(2,"画图题")};
		Examination examination = new Examination(question);
		university.test(thinkPad,xaioming,examination);

	}
}