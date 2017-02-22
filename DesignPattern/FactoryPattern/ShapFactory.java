public class ShapFactory{
	public Shap getShap(String shapType){
		if("CiRcLe".equalsIgnoreCase(shapType)){
			return new Circle();
		}
		if("Rectangle".equalsIgnoreCase(shapType)){
			return new Rectangle();
		}
		if("Square".equalsIgnoreCase(shapType)){
			return new Square();
		}
		return null;
	}
}