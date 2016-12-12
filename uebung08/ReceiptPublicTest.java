import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class ReceiptPublicTest {
	
	private static final int ARITHMETIC = 0;
	private static final int NEGATIVE_ARRAY_SIZE = 1;
	private static final int ARRAY_BOUNDS_MINUS = 2;
	private static final int ARRAY_BOUNDS_PLUS = 3;
	private static final int NPE_INTARRAY = 4;
	private static final int NPE_PRODUCT = 5;
	private static final int NUMBERFORMAT = 6;
	private static final int OOM = 7;
	private static final Map<Integer, Boolean> found = new HashMap<>();

	@BeforeClass
	public static void a_callAllTheMethods() {

		try {
			ReceiptTest.triggerException1();
		} catch (Throwable t) {
			classifyEx(t);
		}

		try {
			ReceiptTest.triggerException2();
		} catch (Throwable t) {
			classifyEx(t);
		}

		try {
			ReceiptTest.triggerException3();
		} catch (Throwable t) {
			classifyEx(t);
		}

		try {
			ReceiptTest.triggerException4();
		} catch (Throwable t) {
			classifyEx(t);
		}

		try {
			ReceiptTest.triggerException5();
		} catch (Throwable t) {
			classifyEx(t);
		}

		try {
			ReceiptTest.triggerException6();
		} catch (Throwable t) {
			classifyEx(t);
		}

		try {
			ReceiptTest.triggerException7();
		} catch (Throwable t) {
			classifyEx(t);
		}

		try {
			ReceiptTest.triggerException8();
		} catch (Throwable t) {
			classifyEx(t);
		}

		try {
			ReceiptTest.triggerException9();
		} catch (Throwable t) {
			classifyEx(t);
		}
	}

	public static void classifyEx(Throwable t) {

		if (t.getClass() == NegativeArraySizeException.class) {
			StackTraceElement[] trace = t.getStackTrace();
			if (trace[0].getClassName().equals(Receipt.class.getName()) && trace[0].getLineNumber() == 8) {
				found.put(NEGATIVE_ARRAY_SIZE, true);
				return;
			}
		}

		if (t.getClass() == ArrayIndexOutOfBoundsException.class) {
			StackTraceElement[] trace = t.getStackTrace();
			int illegalIndex = Integer.parseInt(t.getMessage());

			if (!trace[0].getClassName().equals(Receipt.class.getName())) {
				return;
			}

			if (illegalIndex >= 0) {
				found.put(ARRAY_BOUNDS_PLUS, true);
				return;
			} else {
				found.put(ARRAY_BOUNDS_MINUS, true);
				return;
			}
		}

		if (t.getClass() == NullPointerException.class) {
			StackTraceElement[] trace = t.getStackTrace();

			if (!trace[0].getClassName().equals(Receipt.class.getName())) {
				return;
			}

			switch (trace[0].getLineNumber()) {
			case 13:
				found.put(NPE_PRODUCT, true);
				break;
			case 29:
				found.put(NPE_INTARRAY, true);
				break;
			}
		}

		if (t.getClass() == NumberFormatException.class) {
			StackTraceElement[] trace = t.getStackTrace();
			for (StackTraceElement ste : trace) {
				if (ste.getClassName().equals(Receipt.class.getName()) && ste.getLineNumber() == 18) {
					found.put(NUMBERFORMAT, true);
					return;
				}
			}
		}

		if (t.getClass() == ArithmeticException.class) {
			StackTraceElement[] trace = t.getStackTrace();
			if (trace[0].getClassName().equals(Receipt.class.getName()) && trace[0].getLineNumber() == 41) {
				found.put(ARITHMETIC, true);
				return;
			}
		}

		if (t.getClass() == OutOfMemoryError.class) {
			StackTraceElement[] trace = t.getStackTrace();
			if (trace[0].getClassName().equals(Receipt.class.getName())) {
				found.put(OOM, true);
				return;
			}
		}
	}

	@Test(timeout = 1000)
	public void foundAnything() {
		assertFalse(found.isEmpty());
	}

	@Test(timeout = 1000)
	public void NameTooLong() {
		boolean pass = false;
		try {
			ReceiptImproved receiptImproved = new ReceiptImproved(2);
			receiptImproved.register("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "12");
		} catch (Exception e) {
			assertEquals(IllegalArgumentException.class, e.getClass());
			pass = true;
		}
		assertTrue(pass);
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
