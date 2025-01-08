package test;

public class StringThreadExample {
	public static void main(String[] args) {
		final String sharedString = "Initial";

		Thread thread1 = new Thread(() -> {
			String localString = sharedString; // 복사해서 사용
			localString = "Thread1 Modified";  // 스레드1에서만 변경
			System.out.println("Thread1: " + localString);
		});

		Thread thread2 = new Thread(() -> {
			try {
				Thread.sleep(100); // Thread1이 먼저 실행되도록 약간 지연
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread2: " + sharedString); // 공유된 값 출력
		});

		thread1.start();
		thread2.start();
	}
}

