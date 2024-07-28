package concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHahMapTest{
	public static class Count {
		private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

		public Count() {
			map.put("count", 0);
		}
		public void increase() {
			map.put("count", map.get("count") +1);
		}
		public int getCount() {
			return map.get("count");
		}
	}

	public static void main(String[] args) {
		Count count = new Count();
		new Thread(() -> {
			for(int i=0; i<1000; i++) {
				count.increase();
			}
		}).start();
		new Thread(() -> {
			for(int i=0; i<1000; i++) {
				count.increase();
			}
		}).start();


		new Thread(() -> {
			try {
				Thread.sleep(3000);
				System.out.println("count: " + count.getCount());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}