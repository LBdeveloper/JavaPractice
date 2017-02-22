import java.util.Arrays;
public class DemoDimension2{
	public static void main(String[] args){
		// int[][] d2 = new int[][]{{1,2,3,4},{5,6}};
		// for(int[] x : d2){
		// 	for(int temp : x){
		// 		System.out.println(temp);
		// 	}
		// }


		// int[] aa = new int[]{1,2,3};
		// for( int temp : aa ){
		// 	System.out.println(temp);
		// }

		//int[] aa = int[3]; 是错误的写法

		// Integer[] scores = new int[3];  //不兼容的类型: int[]无法转换为Integer[]
		// for(int temp : scores){
		// 	System.out.println(temp);
		// }

		// Integer[] scores = new Integer[3];
		// for(int temp : scores){   //null的Integer赋值给int会报空指针异常
		// 	System.out.println(temp);
		// }

		// Integer[] scores = new Integer[3];   //注意Integer只建立0个Integer对象  因为是引用类型所以就指向null

		// for(Integer temp : scores){
		// 	System.out.println(temp);
		// }

		// int[] arr1 = {1,2,3,4,5,6,7,8,9};
		// int[] arr2 = new int[arr1.length];
		// System.arraycopy(arr1,0,arr2,0,arr1.length);
		
		// for(int temp : arr2){
		// 	System.out.print(temp+"\t");
		// }

		int arr1[] = new int[]{1,2,3,4,5,6};
		int arr2[] = Arrays.copyOf(arr1,arr1.length*2);
		for(int temp : arr2){
			System.out.println(temp);
		}



	}
}