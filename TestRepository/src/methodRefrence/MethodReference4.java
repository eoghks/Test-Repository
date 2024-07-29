package methodRefrence;

import java.util.List;

public class MethodReference4 {
	public static void main(String[] args){
		List<String> list = List.of("A", "AA", "AAA", "AAAAA");

		list.stream().map(str -> str.length()).forEach(str -> System.out.println(str));
		System.out.println("----------------");
		list.stream().map(String::length).forEach(str -> System.out.println(str));
	}
}
