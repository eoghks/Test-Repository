package methodRefrence;

public class MethodReference2 {
	//매개변수 메서드 참조
	public static void main(String[] args){
		Equals equals1 = (s1, s2) -> s1.equals(s2);
		Equals equals2 = String::equals;

		System.out.println(equals1.equals("s1", "s2"));
		System.out.println(equals2.equals("s1", "s2"));
	}

	static class  EqualsClass {
		public static boolean staticAdd(String a, String b) {
			return a.equals(a);
		}
	}

	@FunctionalInterface
	interface Equals {
		boolean equals(String a, String b);
	}
}
