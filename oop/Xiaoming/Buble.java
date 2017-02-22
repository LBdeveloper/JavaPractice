public class Buble{
	public static void main(String[] args) {
			int arr[] = {2,3,4,5,21,57,65,4,3};
			for( int i=0 ; i<arr.length - 1; ++i ){
				for( int j = i + 1 ; j < arr.length ; ++j ){
						if(arr[i]>arr[j]){
							arr[i] = arr[i]^arr[j];
							arr[j] = arr[i]^arr[j];
							arr[i] = arr[i]^arr[j];
						}
				}
			}
			for(int temp : arr){
				System.out.println(temp);
			}
	}
}