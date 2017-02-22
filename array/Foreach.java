import java.util.*;
public class Foreach{
	public static void main(String[] args) {
	// 	int[] arr1 = new int[5];
	// 	System.out.println(arr1.length);
	// 	for ( int temp : arr1 ){
	// 		System.out.println(temp);
	// 	}
//========================================================
		// int arr2[] = {0,1,2,3,4,5,6,7};
		// System.out.println(arr2.length);
		// for( int temp : arr2){
		// 	System.out.println(temp);
		// }
//========================================================

		int[][] dimension2 = {{1},{1,2},{1,2,3},{1,2,3,4}};

			//Arrays.fill(dimension2,60);

		for( int[] dimension1 : dimension2 ){
			Arrays.fill(dimension1,60);
			for( int temp : dimension1 ){
				System.out.print(temp+"\t");
			}
			System.out.println();
		}








	}
}