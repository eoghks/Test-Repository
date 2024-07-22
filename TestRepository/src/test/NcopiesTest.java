package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NcopiesTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Collections.nCopies(10, 0));
		System.out.println("size: " + list.size());
		System.out.println("element: " + list.get(2));
	}
}
