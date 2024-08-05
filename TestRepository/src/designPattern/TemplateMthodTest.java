package designPattern;

public class TemplateMthodTest {
	public static abstract class Beverage {
		private boolean custom = false;

		public Beverage(boolean custom) {
			this.custom = custom;
		}

		//템플릿 메서드
		public void make() {
			boilWater();
			addIngredinent();
			if(this.custom == true) {
				addCondiment();
			}
			stir();
		}

		public void boilWater() {
			System.out.println("물을 끓입니다.");
		}

		public void stir() {
			System.out.println("음료를 젓습니다.");
		}

		public abstract void addIngredinent();
		public abstract void addCondiment();
	}

	public static class Coffee extends Beverage {
		public Coffee(boolean custom) {
			super(custom);
		}

		@Override
		public void addIngredinent() {
			System.out.println("에소프레소를 넣습니다.");
		}

		@Override
		public void addCondiment() {
			System.out.println("시럽을 넣습니다.");
		}
	}

	public static class Tea extends Beverage {
		public Tea(boolean custom) {
			super(custom);
		}

		@Override
		public void addIngredinent() {
			System.out.println("티백을 넣습니다.");
		}

		@Override
		public void addCondiment() {
			System.out.println("레몬즙을 넣습니다.");
		}
	}

	public static void main(String[] args) {
		Beverage coffee = new Coffee(true);
		Beverage tea = new Tea(false);
		coffee.make();
		System.out.println("------------");
		tea.make();
	}

}
