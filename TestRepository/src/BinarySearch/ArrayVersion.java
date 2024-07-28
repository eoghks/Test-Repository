package BinarySearch;

public class ArrayVersion {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 6 , 9, 11, 15};
		int index = binarySearch(arr, 3);
		System.out.println("3 : (index)" + index);
	}

	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length -1 ;
		while(left <= right) {
			int mid = (left + right) / 2 ;
			if(arr[mid] == target) {
				return mid;
			} else if(arr[mid] > target) {
				right = mid - 1 ;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
