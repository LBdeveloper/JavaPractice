package util.edu;
public class Examination{

	private Question question[];
	private String description = "";

	public Examination(Question q[]){
		question = q;
		doDescription(question);

	}

	private void doDescription(Question q[]){
		for(int i=0;i<q.length;++i){
			description = description + q[i]+"";
		}
	}

	public void done(){
		for(int i=0;i<question.length;++i){
			for(int j=0;j<question[i].getNumber();++j){
				System.out.println(question[i].getType()+"["+(j+1)+"]"+"完成");
			}
		}
	}

	public String toString(){
		return description;
	}

}