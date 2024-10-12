package JUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoUnitTest {

	@Test
	@DisplayName("로또 번호 갯수 테스트")
	void lottoNumberSizeTest() {
		//given
		Lotto lotto = new Lotto();
		final int price = 1000;
		//when
		List<Integer> numbers = lotto.generate(price);
		//then
		assertThat(numbers.size()).isEqualTo(6);
	}

	@Test
	@DisplayName("로또 번호 범위 테스트")
	void lottoNumberRangeTest() {
		//given
		Lotto lotto = new Lotto();
		final int price = 1000;
		//when
		List<Integer> numbers = lotto.generate(price);
		//then
		assertThat(numbers.stream().allMatch(n->n>=1&&n<=45)).isTrue();
	}

	@Test
	@DisplayName("로또 금액 테스트")
	void lottoPriveTest() {
		//given
		Lotto lotto = new Lotto();
		final int price = 2000;
		//when
		RuntimeException exception = assertThrows(RuntimeException.class , () -> lotto.generate(price));
		//then
		assertThat(exception.getMessage()).isEqualTo("잘못된 금액입니다.");
	}
}
