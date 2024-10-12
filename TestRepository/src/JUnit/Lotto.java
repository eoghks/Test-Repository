package JUnit;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Lotto {
	final int money = 1000;
	public List<Integer> generate (int money) {
		if(this.money != money) {
			throw new RuntimeException("잘못된 금액입니다.");
		}
		return generate();
	}

	private List<Integer> generate() {
		return new Random().ints(1, 46).distinct().limit(6).boxed().collect(Collectors.toList());
	}
}
