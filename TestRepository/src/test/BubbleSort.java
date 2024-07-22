package test;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 3, 5, 6,9, 10, 1};
		bubbleSort(arr);

		for(int i =0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void bubbleSort(int[] arr) {
		for(int i=0; i< arr.length; i++) {
			for(int j=1; j<arr.length - i; j++) {
				if(arr[j-1] > arr[j]) {
					swap(arr, j-1, j);
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
