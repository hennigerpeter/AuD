import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class NegafibonacciPublicTest {

	private int[] fibonacciSequence = new int[] { -21, 13, -8, 5, -3, 2, -1, 1, 0, 1, 1, 2, 3, 5, 8, 13, 21 };

	@Test(timeout = 1000)
	public void testNegafibonacciRecursion() {
		for (int n = -8; n <= 8; n++)
			checkelement(n, fibonacciSequence[n + 8]);
	}

	@Test(timeout = 1000)
	public void testNegafibonacci() {
		for (int n = -8; n <= 8; n++)
			checkelement(n, fibonacciSequence[n + 8]);
	}

	private static void checkelement(int n, int excpectedValue) {
		final List<String> stackTrace = new ArrayList<>();
		int value = Negafibonacci.solve(n, new Negafibonacci() {
			@Override
			public void check() {
				stackTrace.clear();
				for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
					stackTrace.add(ste.getMethodName());
				}
			}
		});

		assertTrue(Collections.frequency(stackTrace, "solve") > 1 || n <= 2 && n >= -2);
		assertEquals("checking element: F[ " + n + " ]", excpectedValue, value);
	}
}