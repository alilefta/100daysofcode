package myOwnTraining1;

import java.util.Arrays;

public class oneDimentionalArray {
	static int a, b;
	public static void main(String[] args) {
		int a[] = {10,20,30,40,50,60,70};
		int b[] = {100, 173, 200, 0, 20, 1, 0};
		
		sortArray(b);
		System.out.println(Arrays.toString(b));
		
	}
	
	public static void sortArray(int[] arr) {
		int temp = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	public static void changeArray(int arr[]){
		for(int i =0; i< arr.length; i++) {
			arr[i] = arr[i] + 2;
		}
	}
	
	

}
