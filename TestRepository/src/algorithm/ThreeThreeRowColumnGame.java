package algorithm;

public class ThreeThreeRowColumnGame {
	static int [][] table= {
		{1, 5, 3},
		{2, 5, 7},
		{5, 3, 5},
	};
	static boolean[] check = new boolean[3];

	public static void main(String[] args) {
		backTracking(0,0);
	}

	public static void backTracking(int row, int score) {
		if(row == 3) {
			System.out.println(score);
			return;
		}

		for(int i=0; i <3; i++) {
			if(check[i] == false) {
				check[i] = true;
				backTracking(row+1, score + table[row][i]);
				check[i] = false;
			}
		}
	}
}
