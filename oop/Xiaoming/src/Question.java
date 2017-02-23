package util.edu;
public class Question{
	private int number;
	private String type;

	public Question(){

	}

	public Question(int number,String type){
		this.number = number;
		this.type = type;
	}

	public int getNumber(){
		return number;
	}

	public String getType(){
		return type;
	}

	public String toString(){
		return number+"道"+type;
	}
}