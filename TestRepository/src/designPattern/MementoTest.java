package designPattern;

import java.util.ArrayList;
import java.util.List;

public class MementoTest {
	public static void main(String[] args) {
		Originator org = new Originator();
		CareTaker caretaker = new CareTaker();
		for(int i = 1; i <= 5; i++) {
			org.setState(i);
			caretaker.add(org.save());
		}

		System.out.println(org.getState());
		for(int i = 3; i >= 0; i--) {
			org.restore(caretaker.get(i));
			System.out.println(org.getState());
		}
	}

	public static class Originator {
		private Integer state;

		public void setState(Integer state) {
			this.state = state;
		}

		public Integer getState() {
			return state;
		}

		public Memento save() {
			return new Memento(this.state);
		}

		public void restore(Memento memento) {
			if(memento != null) {
				this.state = memento.getState();
			}
		}
	}

	public static class Memento {
		private Integer state;

		public Memento (Integer state) {
			this.state = state;
		}

		public Integer getState(){
			return state;
		}
	}

	public static class CareTaker {
		List<Memento> list = new ArrayList<>();

		public void add(Memento state){
			this.list.add(state);
		}

		public Memento get(int index) {
			if(index >= list.size()) {
				System.out.println("잘못된 index 입니다.");
				return null;
			} else {
				return list.get(index);
			}
		}
	}
}
