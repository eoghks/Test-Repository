package algorithm;

import java.util.Scanner;

public class NQueen {
	static int cnt = 0;
	static int n;
	static int[] cols;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cols = new int[n];
		nQueen(0);
		System.out.println(cnt);
	}

	public static void nQueen(int row) {
		if(row == n) {
			cnt++;
			return;
		}

		for(int i=0; i<n; i++) {
			if(check(row, i) == true) {
				cols[row] = i;
				nQueen(row+1);
			}
		}
	}

	public static boolean check(int row, int col) {
		for(int i=0; i<row; i++) {
			if(cols[i] == col) {
				return false;
			}
			if(Math.abs(col - cols[i]) == Math.abs(row-i)) {
				return false;
			}
		}
		return true;
	}
}
