import static org.junit.Assert.*;
import org.junit.*;

public class HaePublicTest {

	@Test(timeout = 666)
	public void test_hae_1024_2_PUBLIC_TEST() {
		long expected = 10L;
		long actual = Hae.hae(1024, 2);
		assertEquals("Hae.hae(1024, 2) ist falsch.", expected, actual);
	}

	@Test(timeout = 666)
	public void test_hae_3_2_PUBLIC_TEST() {
		long expected = 1L;
		long actual = Hae.hae(3, 2);
		assertEquals("Hae.hae(3, 2) ist falsch.", expected, actual);
	}
}