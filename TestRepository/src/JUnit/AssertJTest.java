package JUnit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AssertJTest {
	public class Animal{
		private String name;
		private int age;

		public Animal(String name, int age) {
			this.name = name;
			this.age =age;
		}
	}

	static List<Integer> list;

	@Test
	@DisplayName("isEquals Test")
	void test1() {
		Animal a1 = new Animal("Dog", 2);
		Animal a2 = new Animal("Dog", 2);
		assertThat(a1).isEqualTo(a2);
	}

	@Test
	@DisplayName("isEquals Test")
	void test2() {
		Animal a1 = new Animal("Dog", 2);
		Animal a2 = new Animal("Dog", 2);
		assertThat(a1).isEqualToComparingFieldByField(a2);
	}

	@Test
	@DisplayName("isTrue Test")
	void test3() {
		assertThat(1!=2).isTrue();
	}

	@Test
	@DisplayName("isFalse Test")
	void test4() {
		assertThat(1==2).isFalse();
	}

	@Test
	@DisplayName("contains Test")
	void test5() {
		assertThat(list).contains(1);
	}

	@Test
	@DisplayName("isNotEmpty Test")
	void test6() {
		assertThat(list).isNotEmpty();
	}

	@Test
	@DisplayName("startsWith Test")
	void test7() {
		assertThat(list).startsWith(1);
	}

	@Test
	@DisplayName("doesNotContainNull Test")
	void test8() {
		assertThat(list).doesNotContainNull();
	}

	@BeforeAll
	public static void initList() {
		list = Arrays.asList(1,2,3);
	}
}
