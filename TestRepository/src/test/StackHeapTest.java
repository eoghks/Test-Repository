package test;

import java.util.ArrayList;
import java.util.List;

public class StackHeapTest {
	public static void main(String[] args){
		Integer i = 100;
		List<String> list= new ArrayList<>();
		list.add("aaa");
		list.add("bbb");

		printFirstValue(list);
		addListTest(list);
		changVal(i);
	}

	public static void printFirstValue(List<String> param){
		String s = param.get(0);
		System.out.println(s);
	}

	private static void addListTest(List<String> param) {
		param.add("ccc");
	}

	private static void changVal(Integer j) {
		j += 20;
	}
}
