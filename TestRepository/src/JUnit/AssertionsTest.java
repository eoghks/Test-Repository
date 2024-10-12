package JUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AssertionsTest {

	@Test
	@DisplayName("assertEquals Test")
	void test1() {
		String s1 = "A";
		String s2 = "A";

		assertEquals(s1, s2);
	}

	@Test
	@DisplayName("assertArrayEquals Test")
	void test2() {
		char[] c1 = {'J', 'U', 'n', 'i', 't'};
		char[] c2 = "JUnit".toCharArray();

		assertArrayEquals(c1, c2);
	}

	@Test
	@DisplayName("assertNull Test")
	void test3() {
		Integer i = null;

		assertNull(i);
	}

	@Test
	@DisplayName("assertNotNull Test")
	void test4() {
		Integer i = 1;

		assertNotNull(i);
	}

	@Test
	@DisplayName("assertTrue Test")
	void test5() {
		assertTrue("1은 2보다 작다.", 1<2);
	}

	@Test
	@DisplayName("assertFalse Test")
	void test6() {
		assertFalse("1은 2보다 작다.", 1>2);
	}

	@Test
	@DisplayName("fail Test")
	public void test7() {
		try {
			makeException();
			fail("Exception not thrown");
		} catch(Exception e) {
			assertEquals("test Exception", e.getMessage());
		}
	}

	public void makeException() throws Exception{
		throw new IllegalArgumentException("test Exception");
	}

	@Test
	@DisplayName("assertThat Test")
	public void test8() {
		assertThat("Sample String", is(not(startsWith("Test"))));
	}

	@Test
	@DisplayName("assertThrows Test")
	public void test9() {
		assertThrows(IllegalArgumentException.class, () -> makeException());
	}
}
