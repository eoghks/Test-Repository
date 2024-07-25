package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest{
	public static class Count {
		private int count = 0;
		private Lock lock = new ReentrantLock();

		public Count() {
		}
		public void increase() {
			count ++;
		}
		public int getCount() {
			return this.count;
		}
		public Lock getLock() {
			return this.lock;
		}
	}

	public static void main(String[] args) {
		Count syncCount = new Count();
		Count asyncCount = new Count();
		new Thread(() -> {
			for(int i=0; i<1000; i++) {
				try {
					syncCount.getLock().lock();
					Thread.sleep(1);
					syncCount.increase();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					syncCount.getLock().unlock();
				}
			}
		}).start();
		new Thread(() -> {
			for(int i=0; i<1000; i++) {
				try {
					syncCount.getLock().lock();
					Thread.sleep(1);
					syncCount.increase();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					syncCount.getLock().unlock();
				}
			}
		}).start();

		new Thread(() -> {
			for(int i=0; i<1000; i++) {
				try {
					Thread.sleep(1);
					asyncCount.increase();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(() -> {
			for(int i=0; i<1000; i++) {
				try {
					Thread.sleep(1);
					asyncCount.increase();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			try {
				Thread.sleep(10000);
				System.out.println("syncCount: " + syncCount.getCount());
				System.out.println("asyncCount: " + asyncCount.getCount());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}