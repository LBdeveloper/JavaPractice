public class ShallowCopy{
	public static void main(String[] args) {
		Clothes[] c1 = new Clothes[]{new Clothes("RED",'M'),new Clothes("Green",'L'),new Clothes("Gray",'S')};
		Clothes[] c2 = new Clothes[c1.length];
		System.arraycopy(c1,0,c2,0,c1.length);
		c2[2].color = "pink";
		System.out.println(c1[2].color);


	}	


}

class Clothes{
	String color;
	char size;
	Clothes(String color,char size){
		this.color = color;
		this.size = size;	
	}
}