public enum MyEnum{
	ZAHNGSAN(1,"zhangsan"),LISI(2,"lisi"),WANGWU(3,"wangwu");

	private MyEnum(int age,String name){
		this.name = name;
		this.age = age;
	}

	private int age;
	private String name;

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}

	public String getName(){
		return name;
	}

	public void setName(){
		this.name = name;
	}

}

 class DemoEnum{
	public static void useEnum(MyEnum enumType){

		switch(enumType)
		{
			case LISI : 
			System.out.println("LISI's name is"+enumType.getName());
			break;

			case ZAHNGSAN :
			System.out.println("ZAHNGSAN's name is "+enumType.getName());
			break;

			case WANGWU :
			System.out.println("WANGWU's name is "+enumType.getName());
			break;
		}

	}

	public static void main(String[] args) {
		useEnum(MyEnum.WANGWU);
	}

}