import static org.junit.Assert.*;
import org.junit.*;

public class VeggieWahnPublicTest {

	// ================================================================================

	private static final long[][] TEST_DATA = { { 2, 2, 2 }, { 3, 4, 12 }, { 98, 99, 9702 }, { 15, 26, 180898060382208000L }, { 106, 111, 110582583588104364L } };

	private void test(int n) {
		int v = (int) TEST_DATA[n][0];
		int g = (int) TEST_DATA[n][1];
		long expected = TEST_DATA[n][2];
		long actual = VeggieWahn.essen(v, g);
		assertEquals("Test mit: " + v + " veganen Grundgerichten und " + g + " Gewuerzen.", expected, actual);
	}

	// ================================================================================

	@Test(timeout = 666)
	public void test_0_PUBLIC_TEST() {
		test(0);
	}

	@Test(timeout = 666)
	public void test_1_PUBLIC_TEST() {
		test(1);
	}

	@Test(timeout = 666)
	public void test_2_PUBLIC_TEST() {
		test(2);
	}

	@Test(timeout = 666)
	public void test_3_PUBLIC_TEST() {
		test(3);
	}

	@Test(timeout = 666)
	public void test_4_PUBLIC_TEST() {
		test(4);
	}

	// ========== main ==========
	// nothing to do ;) - please do nothing here:
	public static void main(String args[]) {
		// to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
		// to run on command line: java -cp .:/usr/share/java/junit4.jar $(ls * | grep PublicTest.class | sed s/.class//)

		// starts junit runner - don't try to understand!
		org.junit.runner.JUnitCore.main(new Object() {
		}.getClass().getEnclosingClass().getSimpleName());
	}
}