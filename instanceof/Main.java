public class Main {
	public static void main(String[] args) {
		Planet mercury = new Mercury();
		if(mercury instanceof Mercury) {
			((Mercury)mercury).spiral();
		}

		if(mercury instanceof Planet) {
			System.out.println("======");
		}
	}
}