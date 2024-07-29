package methodRefrence;

public class MethodReference1 {
	//정적 및 인스턴스 메서드 참조
	public static void main(String[] args){
		//정적 메서드
		Add add1 = (a, b) -> AddClass .staticAdd(a, b);
		System.out.println(add1.add(10, 20));

		Add add2 = AddClass ::staticAdd;
		System.out.println(add2.add(10, 20));

		//인스턴스 메서드
		AddClass addClass = new AddClass();
		Add add3 = (a, b) -> addClass.instanceAdd(a, b);
		System.out.println(add3.add(10, 20));

		Add add4 = addClass::instanceAdd;
		System.out.println(add4.add(10, 20));
	}

	static class  AddClass {
		public static int staticAdd(int a, int b) {
			return a+b;
		}

		public int instanceAdd(int a, int b) {
			return a+b;
		}
	}

	@FunctionalInterface
	interface Add {
		int add(int a, int b);
	}
}
