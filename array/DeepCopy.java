public class DeepCopy{
	public static void main(String[] args) {
		Clothes[] c1 = new Clothes[]{new Clothes("RED",'M'),new Clothes("Green",'L'),new Clothes("Gray",'S')};
		Clothes[] c2 = new Clothes[c1.length];
		for(int i = 0 ; i < c1.length ; ++i ){
			Clothes c = new Clothes(c1[i].color,c1[i].size);
			c2[i] = c;
		}

		c2[2].color = "BLACK";
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