public class Test {
	public static void main(String[] args) {
		Dog wc = new Dog();
		System.out.println(wc.getName());
		Person p = new Person();
		System.out.println(p.getName());

		Person x = new Dog();
		System.out.println(x.getName());
		x = (Person)x;
		System.out.println(x.getName());
		Person pp = new Person();
		/*pp = (Dog)pp;
		Exception in thread "main" java.lang.ClassCastException: Person cannot be cast to Dog
		*/

		// Person ppp = new Dog();

		// ((Dog)ppp).spsForDog();

		Dog ddd = new Dog();
		ddd.spsForDog();

		System.out.println(ddd);

	}
}