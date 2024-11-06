package test;

import java.util.Arrays;

public class ArraysSortTest {

	public static void main(String[] args) {
		int[] test = {3,2,1,6,5,4};
		Arrays.sort(test, 0, 2);// 0~1사이의 인덱스에 대하여 정렬
		for(int i: test) {
			System.out.println(i);
		}
	}
}
