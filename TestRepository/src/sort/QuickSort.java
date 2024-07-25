package sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 3, 5, 6, 9, 10, 1, 2, 7, 11};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int start, int end) {
		int pivotIndex = divide(arr, start, end);

		if(start < pivotIndex -1) {
			quickSort(arr, start, pivotIndex-1);
		}
		if(pivotIndex + 1 < end) {
			quickSort(arr, pivotIndex + 1, end);
		}
	}

	public static int divide(int[] arr, int start, int end) {
		int mid = (start + end) / 2;
		int pivot = arr[mid];

		while(start <= end) {
			while(arr[start] < pivot ) {
				start ++;
			}
			while(arr[end] > pivot) {
				end --;
			}

			if(start <= end) {
				swap(arr, start, end);
				start ++;
			}
		}
		return start -1;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
