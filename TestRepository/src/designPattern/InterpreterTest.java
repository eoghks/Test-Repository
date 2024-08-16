package designPattern;

public class InterpreterTest {
	public static interface Expression{
		boolean interpreter(String context);
	}

	public static class TerminalExpression implements Expression {
		private String data;

		public TerminalExpression(String data) {
			this.data = data;
		}

		@Override
		public boolean interpreter(String context) {
			return context.contains(data);
		}
	}

	public static class AndExpression implements Expression {
		private Expression ex1;
		private Expression ex2;

		public AndExpression(Expression ex1, Expression ex2) {
			this.ex1 = ex1;
			this.ex2 = ex2;
		}

		@Override
		public boolean interpreter(String context) {
			return ex1.interpreter(context) && ex2.interpreter(context);
		}
	}

	public static class OrExpression implements Expression {
		private Expression ex1;
		private Expression ex2;

		public OrExpression(Expression ex1, Expression ex2) {
			this.ex1 = ex1;
			this.ex2 = ex2;
		}

		@Override
		public boolean interpreter(String context) {
			return ex1.interpreter(context) || ex2.interpreter(context);
		}
	}

	public static void main(String[] args) {
		Expression isMale = getMaleExpression();
		Expression isMarriedMale = getMarriedMaleExpression();
		System.out.println("대환은 남자입니까? " + isMale.interpreter("대환"));
		System.out.println("위대환은 결혼한 남자입니까? " + isMarriedMale.interpreter("위대환"));
	}

	public static Expression getMaleExpression() {
		Expression man1 = new TerminalExpression("대환");
		Expression man2 = new TerminalExpression("길동");
		Expression man3 = new TerminalExpression("순신");
		Expression subExpression = new OrExpression(man1, man2);
		return new OrExpression(man1, subExpression);
	}

	public static Expression getMarriedMaleExpression() {
		Expression surname = new TerminalExpression("이");
		Expression givenName = new TerminalExpression("대환");
		return new AndExpression(surname, givenName);
	}
}
