package sort;

public class MergeSort {
	static int[] sorted = new int[9];
	public static void main(String[] args) {
		int[] arr = { 3, 5, 6, 9, 10, 1, 2, 7, 11};
		mergeSort(arr, 0, arr.length-1);

		for(int i =0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void mergeSort(int[] arr, int start, int end) {
		if(start < end) {
			//분할
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			//정복
			merge(arr, start, mid, end);
		}
	}

	public static void merge(int[] arr, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = start;

		while(i <= mid && j <= end) {
			if(arr[i] < arr[j]) {
				sorted[k] = arr[i];
				i++;
			} else {
				sorted[k] = arr[j];
				j++;
			}
			k++;
		}

		if(i > mid ) {
			for(int l = j; l <= end; l++) {
				sorted[k++] = arr[l];
			}
		} else {
			for(int l = i; l <= mid; l++) {
				sorted[k++] = arr[l];
			}
		}

		for(int l = start; l <= end; l++) {
			arr[l]= sorted[l];
		}
	}
}
