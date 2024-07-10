package test;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 5, 6,9, 10, 1};
		selectionSort(arr);

		for(int i =0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void selectionSort(int[] arr) {
		for(int i=0; i< arr.length; i++) {
			int minIdx = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			swap(arr, i, minIdx);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
