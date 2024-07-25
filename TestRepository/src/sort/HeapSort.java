package sort;

import java.util.PriorityQueue;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = { 3, 5, 6, 9, 10, 1, 2, 7, 11};
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i =0; i< arr.length; i++) {
			pq.add(arr[i]);
		}

		while(!pq.isEmpty()) {
			System.out.print(pq.poll()+ " ");
		}
	}
}
