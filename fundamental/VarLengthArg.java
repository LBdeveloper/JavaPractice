public class VarLengthArg {
	public static int sum(int ...numbers){
		int sum = 0;
		for(int number : numbers) {
			sum += number;
		}
		return sum;
	}

	public static void main(String[] args) {
		int result = sum(1,2,3,4,5,6);
		System.out.println(result);
	}
}