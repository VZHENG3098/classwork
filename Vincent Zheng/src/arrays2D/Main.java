package arrays2D;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Array2DSampler test  = new Array2DSampler();
		int [] arr = {4,3,2,1,0};
		changeNeighbors(arr,3);
		System.out.println(Arrays.toString(arr));
	}
	/**
	 * PRECONDITION: i >=0 and i<arr.length
	 * increase the elements at i by 1
	 * decrease the element at i-1 and i+1,if they exist
	 * AVOID array indexoutofboundexception
	 * @param arr
	 * @param i
	 */
	private static void changeNeighbors(int[] arr, int i) {
		if( i < arr.length && i > 0) {
			arr[i] = arr[i] + 1;
			arr[i+1] = arr[i+1] - 1;
			arr[i-1] = arr[i-1] - 1;
		}
	}

}
