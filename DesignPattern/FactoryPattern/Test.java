public class Test{
	public static void main(String[] args) {
		ShapFactory sf =  new ShapFactory();
		double random = Math.random();
		int flag = (int)(random*3);
		Shap sp = null;
		if(flag==0){
			 sp =  sf.getShap("ciRclE");		
		}
		if(flag==1){
			 sp =  sf.getShap("Rectangle");		
		}
		if(flag==2){
			 sp =  sf.getShap("Square");		
		}
	
		sp.draw();
	}
}