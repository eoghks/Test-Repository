package test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerBitCount {

	@Test
	@DisplayName("bitCount Test")
	void test() {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		int[] expect = {1,1,2,1,2,2,3,1,2,2};
		int[] res = new int[10];
		//1, 10, 11, 100, 101, 110, 111, 1000, 1001, 1010
		//1,  1,  2,   1,   2,   2,   3,    1,    2,    2
		for(int i=0; i< nums.length; i++) {
			res[i] = Integer.bitCount(nums[i]);
			System.out.print(res[i]+ " ");
		}

		assertArrayEquals(expect, res);
	}

}
