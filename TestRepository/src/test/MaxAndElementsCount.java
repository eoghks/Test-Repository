package test;

public class MaxAndElementsCount {

	public static void main(String[] args) {
		int[] A = {13,7,2,8,3};
		int res = 0;
	        int n = A.length;
	        int zeros = 0;
	        while(n > zeros) {
	                int cnt =0;
	                for(int i=0; i<n; i++) {
	                    if(A[i] != 0) {
	                        if(A[i]%2==1) {
					cnt++;
				}
	                        A[i] = A[i]>>1;
	                        if(A[i] == 0) {
					zeros++;
				}
	                    }
	                }

	                if(cnt > res) {
				res = cnt;
			}
	            }
	        System.out.print(res);
	}
}
