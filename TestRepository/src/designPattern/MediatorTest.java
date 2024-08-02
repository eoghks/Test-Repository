package designPattern;

import java.util.ArrayList;
import java.util.List;

public class MediatorTest {
	public static interface Mediator {
		void addColleague(Colleague colleague);
		void removeColleague(Colleague colleague);
		void sendMsg(Colleague sender, String msg);
	}

	public static class ConcreteMediator implements Mediator {
		private List<Colleague> list = new ArrayList<>();

		@Override
		public void addColleague(Colleague colleague) {
			list.add(colleague);
		}

		@Override
		public void removeColleague(Colleague colleague) {
			list.remove(colleague);
		}

		@Override
		public void sendMsg(Colleague sender, String msg) {
			for(Colleague receiver: list) {
				if(receiver != sender) {
					receiver.receive(msg);
				}
			}
		}
	}

	public static abstract class Colleague{
		protected Mediator mediator;
		protected String name;
		public Colleague(Mediator mediator, String name) {
			this.mediator = mediator;
			this.name = name;
			this.mediator.addColleague(this);
		}

		public void send(String msg) {
			this.mediator.sendMsg(this, msg);
		}

		public abstract void receive(String msg);
	}

	public static class Developer extends Colleague {
		public Developer(Mediator mediator, String name) {
			super(mediator, name);
		}

		@Override
		public void receive(String msg) {
			System.out.println("Developer(" + this.name + ") receive msg: " + msg);
		}
	}

	public static class Desinger extends Colleague {
		public Desinger(Mediator mediator, String name) {
			super(mediator, name);
		}

		@Override
		public void receive(String msg) {
			System.out.println("Desinger(" + this.name + ") receive msg: " + msg);
		}
	}

	public static void main(String[] args) {
		Mediator mediator = new ConcreteMediator();

		Developer dev1 = new Developer(mediator, "대환");
		Developer dev2 = new Developer(mediator, "길동");
		Desinger des1 = new Desinger(mediator, "순신");
		Desinger des2 = new Desinger(mediator, "흥민");

		dev1.send("안녕 난 대환이야");
	}
}
