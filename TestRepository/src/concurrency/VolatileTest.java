package concurrency;

public class VolatileTest{
	static int  asyncCount =0;
	static volatile int  syncCount =0;
	public static void main(String[] args) {
		new Thread(() -> {
			for(int i=0; i<1000; i++) {
				try {
					Thread.sleep(1);
					asyncIncrease();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(() -> {
			for(int i=0; i<1000; i++) {
				try {
					Thread.sleep(1);
					asyncIncrease();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			for(int i=0; i<1000; i++) {
				try {
					Thread.sleep(1);
					syncIncrease();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(() -> {
			for(int i=0; i<1000; i++) {
				try {
					Thread.sleep(1);
					syncIncrease();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			try {
				Thread.sleep(4000);
				System.out.println("syncCount: " + syncCount);
				System.out.println("asyncCount: " + asyncCount);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	public synchronized static void syncIncrease() {
		syncCount++;
	}

	public static void asyncIncrease() {
		asyncCount++;
	}
}

