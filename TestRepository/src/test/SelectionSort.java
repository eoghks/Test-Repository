package test;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 3, 5, 6,9, 10, 1};
		insertionSort(arr);

		for(int i =0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void insertionSort(int[] arr) {
		for(int i=1; i< arr.length; i++) {
			int temp = arr[i];
			int j=i -1;
			for(; j >= 0 && arr[j] > temp; j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
		}
	}
}
