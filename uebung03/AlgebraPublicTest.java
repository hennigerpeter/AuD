import static org.junit.Assert.*;
import org.junit.*;

public class AlgebraPublicTest {

	@Test(timeout = 666)
	public void test_primfaktorzerlegung_1_PUBLIC_TEST() {
		long[][] expectedPFZ = { {}, {} };
		long[][] actualPFZ = Algebra.primfaktorzerlegung(1L);
		assertNotNull("Ergebnis darf nicht null sein.", actualPFZ);
		assertEquals("Ergebnis muss genau " + expectedPFZ.length + " \"Zeilen\" haben.", expectedPFZ.length, actualPFZ.length);
		for (int i = 0; i < expectedPFZ.length; i++) {
			assertNotNull("Ergebnis darf nicht null enthalten.", actualPFZ[i]);
			assertEquals("Ergebnis muss in Zeile " + i + " genau " + expectedPFZ[i].length + " \"Spalten\" haben.", expectedPFZ[i].length, actualPFZ[i].length);
		}
		for (int i = 0; i < expectedPFZ[0].length; i++) {
			assertEquals("Primzahl an Stelle " + i + " ist falsch.", expectedPFZ[0][i], actualPFZ[0][i]);
			assertEquals("Potenz an Stelle " + i + " ist falsch.", expectedPFZ[1][i], actualPFZ[1][i]);
		}
	}

	@Test(timeout = 666)
	public void test_primfaktorzerlegung_irgendwas_PUBLIC_TEST() {
		long[][] expectedPFZ = { { 7, 11, 13 }, { 2, 3, 5 } };
		long[][] actualPFZ = Algebra.primfaktorzerlegung(7L * 7 * 11 * 11 * 11 * 13 * 13 * 13 * 13 * 13);
		assertNotNull("Ergebnis darf nicht null sein.", actualPFZ);
		assertEquals("Ergebnis muss genau " + expectedPFZ.length + " \"Zeilen\" haben.", expectedPFZ.length, actualPFZ.length);
		for (int i = 0; i < expectedPFZ.length; i++) {
			assertNotNull("Ergebnis darf nicht null enthalten.", actualPFZ[i]);
			assertEquals("Ergebnis muss in Zeile " + i + " genau " + expectedPFZ[i].length + " \"Spalten\" haben.", expectedPFZ[i].length, actualPFZ[i].length);
		}
		for (int i = 0; i < expectedPFZ[0].length; i++) {
			assertEquals("Primzahl an Stelle " + i + " ist falsch.", expectedPFZ[0][i], actualPFZ[0][i]);
			assertEquals("Potenz an Stelle " + i + " ist falsch.", expectedPFZ[1][i], actualPFZ[1][i]);
		}
	}

	// ================================================================================

	@Test(timeout = 666)
	public void test_ggT_3528_3780_PUBLIC_TEST() {
		// siehe https://de.wikipedia.org/wiki/Gr%C3%B6%C3%9Fter_gemeinsamer_Teiler#Berechnung_.C3.BCber_die_Primfaktorzerlegung
		long[][] aPFZ = { { 2, 3, 7 }, { 3, 2, 2 } };
		long[][] bPFZ = { { 2, 3, 5, 7 }, { 2, 3, 1, 1 } };
		long expected = 252L;
		long actual = Algebra.ggT(aPFZ, bPFZ);
		assertEquals("ggT(" + java.util.Arrays.deepToString(aPFZ) + ", " + java.util.Arrays.deepToString(bPFZ) + ") ist falsch.", expected, actual);
	}

	// ================================================================================

	@Test(timeout = 666)
	public void test_kgV_PUBLIC_TEST() {
		long expected = 18L;
		long actual = Algebra.kgV(6, 9);
		assertEquals("Algebra.kgV(6, 9) ist falsch.", expected, actual);
	}

	
	
	

	@Test(timeout = 666)
	public void test_kgV_MY_TEST1() {
		long expected = 36L;
		long actual = Algebra.kgV(12, 18);
		assertEquals("Algebra.kgV(12, 18) ist falsch.", expected, actual);
	}


	@Test(timeout = 666)
	public void test_kgV_MY_TEST2() {
		long expected = 36L;
		long actual = Algebra.kgV(18, 12);
		assertEquals("Algebra.kgV(18,12) ist falsch.", expected, actual);
	}

	@Test(timeout = 666)
	public void test_kgV_MY_TEST3() {
		long expected = 52920L;
		long actual = Algebra.kgV(3528, 3780);
		assertEquals("Algebra.kgV(3528,3780) ist falsch.", expected, actual);
	}

	
	@Test(timeout = 666)
	public void test_kgV_MY_TEST4() {
		long expected = 52920L;
		long actual = Algebra.kgV(3780,3528);
		assertEquals("Algebra.kgV(3780, 3528) ist falsch.", expected, actual);
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