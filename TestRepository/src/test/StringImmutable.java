package test;

public class StringImmutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "bbb";
		Thread t1 = new Thread(()->{
			changeA(a);
			try {
				Thread.sleep(5000);
				System.out.println("end");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(()->{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			changeB(a);
		});
		t2.start();
		t1.start();

		System.out.println("main: "+a);
	}
	private static void changeA(String a) {
		a = "aaa";
		System.out.println(a);
	}
	private static void changeB(String a) {
		System.out.println(a);
	}
}
