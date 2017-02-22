public class Person {

	private String name;

	public void setName(String name) {
		if(name!=null) {
			if(name.equals("习大大"))
			{
				System.out.println("illegal");
				return;
			}
			this.name = name;
		}
	}

	public String getName() {
		return name;
	}


	public static void main(String[] args) {
		Person p = new Person();
		p.setName("习大大");
		System.out.println(p.getName());
	}


}