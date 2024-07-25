package test;

public class finalKeyword {

	public void main(String[] args) {
		final int val1 = 1;
		int val2 = 2;
		final Member member = new Member(1, "대환");

		//val1 = 3;
		val2 = 20;

		member.setId(2);
		//member = new Member(2, "대환");
	}

	public class Member{
		private Integer id;
		private String name;

		public Member(Integer id, String name) {
			this.id = id;
			this.name = name;
		}

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	public class Person {
		private String name;
		private int age;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		public void printInfo() {
			System.out.println("저의 이름은 " + this.name + "이고, " + this.age +"살 입니다.");
		}

		public final void printName() {
			System.out.println("저의 이름은 " + this.name + "입니다.");
		}
	}
	public class Korean extends Person {

		public Korean(int age, String name) {
			super(age, name);
		}

		@Override
		public final void printInfo() {
			System.out.println("저의 이름은 " + super.name + "이고, " + super.age +"살 이며 한국인입니다.");
		}

		/*
		@Override
		public void printName() {
			System.out.println("저의 이름은 " + this.name + "입니다.");
		}*/
	}
}
