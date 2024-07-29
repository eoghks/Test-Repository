package designPattern;

public class StatePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public interface Power {
		public void push();
	}
	public class On implements Power {
		@Override
		public void push() {
			System.out.println("power off");
		}
	}
}
