package methodRefrence;

public class MethodReference3 {
	//생성자 메서드 참조
	public static void main(String[] args){
		constructorInterface constructor1 = (name, age) -> new Person(name, age);
		Person person1 = constructor1.create("대환", 28);

		constructorInterface constructor2 = Person::new;
		Person person2 = constructor1.create("위대환", 28);

		System.out.println(person1.name);
		System.out.println(person2.name);
	}

	static class Person {
		String name;
		int age;
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}

	@FunctionalInterface
	interface constructorInterface {
		Person create(String str, int a);
	}
}
