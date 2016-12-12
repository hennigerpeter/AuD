import static org.junit.Assert.*;
import org.junit.*;

public class FractionPublicTest {

	private Fraction[] mainFracts;

	private void initMainStuff() {
		mainFracts = new Fraction[] { new Fraction(2, 1), new Fraction(1, 2), new Fraction(3, 4), new Fraction(-10, 20) };
	}

	private static Fraction clone(Fraction f) {
		return new Fraction(f.getNumerator(), f.getDenominator());
	}

	private static void compareUnchanged(Fraction a, Fraction b) {
		assertEquals("Numerator changed after operation", a.getNumerator(), b.getNumerator());
		assertEquals("Denominator changed after operation", a.getDenominator(), b.getDenominator());
	}

	@Test(timeout = 100)
	public void test_Basic() {
		Fraction x = new Fraction(42, 24);
		assertEquals("getNumerator returns wrong value", 42l, x.getNumerator());
		assertEquals("getDenominator returns wrong value", 24l, x.getDenominator());
	}

	@Test(timeout = 100)
	public void test_Mul() {
		Fraction fraction = new Fraction(2, 1);
		Fraction mul = fraction.mul(new Fraction(4, 3));
		assertEquals("Numerator is false", 8, mul.getNumerator());
		assertEquals("Denominator is false", 3, mul.getDenominator());
	}

	@Test(timeout = 100)
	public void test_Div() {
		Fraction fraction = new Fraction(2, 1);
		Fraction div = fraction.div(new Fraction(4, 3));
		assertEquals("Numerator is false", 3, div.getNumerator());
		assertEquals("Denominator is false", 2, div.getDenominator());
	}

	@Test(timeout = 100)
	public void test_Simplify() {
		long[] tests = new long[] { 2, 2, 3, 8, -30, 80 };
		long[] answers = new long[] { 1, 1, 3, 8, -3, 8 };
		for (int i = 0; i < tests.length; i += 2) {
			Fraction x = new Fraction(tests[i], tests[i + 1]);
			x.simplify();
			assertEquals(answers[i], x.getNumerator());
			assertEquals(answers[i + 1], x.getDenominator());
		}
	}

	@Test(timeout = 100)
	public void test_Add() {
		Fraction fraction = new Fraction(2, 1);
		Fraction add = fraction.add(new Fraction(4, 3));
		assertEquals("Numerator is false", 10, add.getNumerator());
		assertEquals("Denominator is false", 3, add.getDenominator());
	}

	@Test(timeout = 100)
	public void test_Sub() {
		Fraction fraction = new Fraction(2, 1);
		Fraction sub = fraction.sub(new Fraction(4, 3));
		assertEquals("Numerator is false", 2, sub.getNumerator());
		assertEquals("Denominator is false", 3, sub.getDenominator());
	}

	@Test(timeout = 100)
	public void test_IsNonNegative() {
		Fraction fraction = new Fraction(2, -1);
		assertFalse("Fraction is not negative", fraction.isNonNegative());
	}

	@Test(timeout = 100)
	public void test_CompareTo() {
		Fraction fraction = new Fraction(2, 1);
		assertTrue("Fraction is not equal", fraction.compareTo(new Fraction(2, 1)) == 0);
	}

	@Test(timeout = 100)
	public void addSideEffectsMAIN() {
		initMainStuff();
		for (int i = 0; i < mainFracts.length - 1; i++) {
			Fraction a = mainFracts[i];
			Fraction b = mainFracts[i + 1];
			Fraction aa = clone(a);
			Fraction bb = clone(b);
			a.add(b);
			compareUnchanged(aa, a);
			compareUnchanged(bb, b);
		}
	}

	@Test(timeout = 100)
	public void nonnegSideEffectsMAIN() {
		initMainStuff();
		for (int i = 0; i < mainFracts.length - 1; i++) {
			Fraction a = mainFracts[i];
			Fraction aa = clone(a);
			a.isNonNegative();
			compareUnchanged(aa, a);
		}
	}

	@Test(timeout = 100)
	public void compareToSideEffectsMAIN() {
		initMainStuff();
		for (int i = 0; i < mainFracts.length - 1; i++) {
			Fraction a = mainFracts[i];
			Fraction b = mainFracts[i + 1];
			Fraction aa = clone(a);
			Fraction bb = clone(b);
			a.compareTo(b);
			compareUnchanged(aa, a);
			compareUnchanged(bb, b);
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
