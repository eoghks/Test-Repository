package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class treeMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer, String> asc = new TreeMap<>();
		TreeMap<Integer, String> desc = new TreeMap<>(Collections.reverseOrder());
		//오름차순
		TreeMap<Integer, String> comprator = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a-b;
			}
		});
		//내림차순
		TreeMap<Integer, String> lambda = new TreeMap<>((a,b) -> b-a);
		//map -> treeMap
		Map<Integer, String> map = new HashMap<>();
		TreeMap<Integer, String> convert = new TreeMap<>(map);
		//초기화하면서 생성하기
		TreeMap<Integer, String> treeMap = new TreeMap<>(Map.of(3, "C", 2,"B", 1,"A", 5, "E", 4, "D" ));

		System.out.println("-------------firstKey-------------");
		System.out.println(treeMap.firstKey());
		System.out.println("-------------lastKey-------------");
		System.out.println(treeMap.lastKey());

		System.out.println("-------------firstEntry-------------");
		System.out.println(treeMap.firstEntry().getKey()+": "+treeMap.firstEntry().getValue());
		System.out.println("-------------lastEntry-------------");
		System.out.println(treeMap.lastEntry().getKey()+": "+treeMap.lastEntry().getValue());

		System.out.println("-------------higherKey-------------");
		System.out.println(treeMap.higherKey(3));
		System.out.println("-------------lowerKey-------------");
		System.out.println(treeMap.lowerKey(3));

		System.out.println("-------------higherEntry-------------");
		System.out.println(treeMap.higherEntry(3).getKey()+": "+treeMap.higherEntry(3).getValue());
		System.out.println("-------------lowerEntry-------------");
		System.out.println(treeMap.lowerEntry(3).getKey()+": "+treeMap.lowerEntry(3).getValue());

		System.out.println("-------------ceilingKey-------------");
		System.out.println(treeMap.ceilingKey(3));
		System.out.println("-------------floorKey-------------");
		System.out.println(treeMap.floorKey(4));

		System.out.println("-------------ceilingEntry-------------");
		System.out.println(treeMap.ceilingEntry(3).getKey()+": "+treeMap.ceilingEntry(3).getValue());
		System.out.println("-------------floorEntry-------------");
		System.out.println(treeMap.floorEntry(4).getKey()+": "+treeMap.floorEntry(4).getValue());

		System.out.println("-------------pollFirstEntry-------------");
		Entry<Integer, String> entry1 = treeMap.pollFirstEntry();
		System.out.println(entry1.getKey()+": "+entry1.getValue());
		System.out.println(treeMap.firstKey());

		System.out.println("-------------pollLastEntry-------------");
		Entry<Integer, String> entry2 = treeMap.pollLastEntry();
		System.out.println(entry2.getKey()+": "+entry2.getValue());
		System.out.println(treeMap.lastKey());
	}

}
