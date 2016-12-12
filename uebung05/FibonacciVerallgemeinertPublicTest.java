import static org.junit.Assert.*;
import org.junit.*;

public class FibonacciVerallgemeinertPublicTest {

	// ================================================================================

	private static void checkelement(double a, double b, int c, int n, double expected) {
		double actual = FibonacciVerallgemeinert.fibonacciVerallgemeinert(a, b, c, n);
		assertEquals("checking element: F[ " + n + " ] (a = " + a + ", b = " + b + ", c = " + c + " ): ", expected, actual, 0.0000001);
	}

	private double[] testwerte1 = new double[] { 0.0, 1.0, 2.0, -1.0, -0.5, 2.25, 2.375, -1.6875, -0.28125, 2.515625, 2.0859375, -1.32421875, 0.529296875, 1.8212890625, 1.40771484375 };
	private double[] testwerte2 = new double[] { 0.0, 1.0, 2.0, 3.0, 4.5, 12.25, 20.375, 53.9375, 85.40625, 225.765625, 359.0234375, 951.49609375, 1512.650390625, 4007.3916015625, 6370.11083984375 };

	// ================================================================================

	@Test(timeout = 1000)
	public void test_fibonacciVerallgemeinert_testwerte1_terminierung_PUBLIC_TEST() {
		for (int i = 0; i < 3; i++) {
			checkelement(1.5d, -0.5d, 3, i, i);
		}
	}

	@Test(timeout = 1000)
	public void test_fibonacciVerallgemeinert_testwerte1_gerade_PUBLIC_TEST() {
		for (int i = 4; i < testwerte1.length; i += 2) {
			checkelement(1.5, -0.5, 3, i, testwerte1[i]);
		}
	}

	@Test(timeout = 1000)
	public void test_fibonacciVerallgemeinert_testwerte1_ungerade_PUBLIC_TEST() {
		for (int i = 3; i < testwerte1.length; i += 2) {
			checkelement(1.5, -0.5, 3, i, testwerte1[i]);
		}
	}

	// ================================================================================

	@Test(timeout = 1000)
	public void test_fibonacciVerallgemeinert_testwerte2_terminierung_PUBLIC_TEST() {
		for (int i = 0; i < 4; i++) {
			checkelement(1.5, 2.5, 4, i, i);
		}
	}

	@Test(timeout = 1000)
	public void test_fibonacciVerallgemeinert_testwerte2_gerade_PUBLIC_TEST() {
		for (int i = 4; i < testwerte2.length; i += 2) {
			checkelement(1.5, 2.5, 4, i, testwerte2[i]);
		}
	}

	@Test(timeout = 1000)
	public void test_fibonacciVerallgemeinert_testwerte2_ungerade_PUBLIC_TEST() {
		for (int i = 5; i < testwerte2.length; i += 2) {
			checkelement(1.5, 2.5, 4, i, testwerte2[i]);
		}
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