import static org.junit.Assert.*;
import org.junit.*;

public class GaussschesEliminationsverfahrenPublicTest {

	// ================================================================================
	@Test(timeout = 666)
	public void test_pivotisiere_0_PUBLIC_TEST() {
		long[][] matrix = { //
				{ 3, 11, 19 }, //
				{ 5, 13, 23 }, //
				{ 7, 17, 29 }, //
		};
		long[] vektor = //
				{ 101, 103, 107 };
		long[][] matrixExpected = { //
				{ 7, 17, 29 }, //
				{ 5, 13, 23 }, //
				{ 3, 11, 19 }, //
		};
		long[] vektorExpected = //
				{ 107, 103, 101 };
		GaussschesEliminationsverfahren.pivotisiere(matrix, vektor, 0);
		assertArrayEquals("Matrix ist kaputt.", matrixExpected, matrix);
		assertArrayEquals("Vektor ist kaputt.", vektorExpected, vektor);
	}

	@Test(timeout = 666)
	public void test_eliminiere_0_PUBLIC_TEST() {
		long[][] matrix = { //
				{ 7, 17, 29 }, //
				{ 5, 13, 23 }, //
				{ 3, 11, 19 }, //
		};
		long[] vektor = //
				{ 107, 103, 101 };
		long[][] matrixExpected = { //
				{ 7, 17, 29 }, //
				{ 0, -6, -16 }, // { 0, 5 * 17 - 7 * 13, 5 * 29 - 7 * 23 }, // mit pA = 7 und pB = 5 //
				{ 0, -26, -46 }, // { 0, 3 * 17 - 7 * 11, 3 * 29 - 7 * 19 }, // mit pA = 7 und pB = 3 //
		};
		long[] vektorExpected = //
				{ 107, -186, -386 }; // { 107, 5 * 107 - 7 * 103, 3 * 107 - 7 * 101 }; // mit pA = 7 und pB = 5 bzw. 3 //
		GaussschesEliminationsverfahren.eliminiere(matrix, vektor, 0);
		assertArrayEquals("Matrix ist kaputt.", matrixExpected, matrix);
		assertArrayEquals("Vektor ist kaputt.", vektorExpected, vektor);
	}

	// ================================================================================
	@Test(timeout = 666)
	public void test_pivotisiere_1_PUBLIC_TEST() {
		long[][] matrix = { //
				{ 7, 17, 29 }, //
				{ 0, -6, -16 }, //
				{ 0, -26, -46 }, //
		};
		long[] vektor = //
				{ 107, -186, -386 };
		long[][] matrixExpected = { //
				{ 7, 17, 29 }, //
				{ 0, -26, -46 }, //
				{ 0, -6, -16 }, //
		};
		long[] vektorExpected = //
				{ 107, -386, -186 };
		GaussschesEliminationsverfahren.pivotisiere(matrix, vektor, 1);
		assertArrayEquals("Matrix ist kaputt.", matrixExpected, matrix);
		assertArrayEquals("Vektor ist kaputt.", vektorExpected, vektor);
	}

	@Test(timeout = 666)
	public void test_eliminiere_1_PUBLIC_TEST() {
		long[][] matrix = { //
				{ 7, 17, 29 }, //
				{ 0, -26, -46 }, //
				{ 0, -6, -16 }, //
		};
		long[] vektor = //
				{ 107, -386, -186 };
		long[][] matrixExpected = { //
				{ 7, 17, 29 }, //
				{ 0, -26, -46 }, //
				{ 0, 0, -140 }, // { 0, 0, -6 * -46 - -26 * -16 }, //
		};
		long[] vektorExpected = //
				{ 107, -386, -2520 }; // { 107, -386, -6 * -386 - -26 * -186 };
		GaussschesEliminationsverfahren.eliminiere(matrix, vektor, 1);
		assertArrayEquals("Matrix ist kaputt.", matrixExpected, matrix);
		assertArrayEquals("Vektor ist kaputt.", vektorExpected, vektor);
	}

	// ================================================================================
	@Test(timeout = 666)
	public void test_loese_ganzzahlig_PUBLIC_TEST() {
		long[][] matrix = { //
				{ 7, 17, 29 }, //
				{ 0, -26, -46 }, //
				{ 0, 0, -140 }, //
		};
		long[] vektor = //
				{ 107, -386, -2520 }; //
		long[][] matrixExpected = { //
				{ 7, 17, 29 }, //
				{ 0, -26, -46 }, //
				{ 0, 0, -140 }, //
		};
		long[] vektorExpected = //
				{ 107, -386, -2520 }; //
		double[] loesungExpected = //
				{ -18, -17, 18 }; // { (107 - 17 * -17 - 29 * 18) / 7, (-386 - -46 * 18) / -26 , -2520 / -140 };
		double[] loesung = GaussschesEliminationsverfahren.loese(matrix, vektor);
		assertArrayEquals("Matrix ist kaputt.", matrixExpected, matrix);
		assertArrayEquals("Vektor ist kaputt.", vektorExpected, vektor);
		assertArrayEquals("Loesung ist kaputt.", loesungExpected, loesung, 666e-6);
	}

	@Test(timeout = 666)
	public void test_loese_gleitkomma_PUBLIC_TEST() {
		long[][] matrix = { //
				{ 29, 23, 19 }, //
				{ 0, 13, 11 }, //
				{ 0, 0, 5 }, //
		};
		long[] vektor = //
				{ 17, 7, 3 }; //
		long[][] matrixExpected = { //
				{ 29, 23, 19 }, //
				{ 0, 13, 11 }, //
				{ 0, 0, 5 }, //
		};
		long[] vektorExpected = //
				{ 17, 7, 3 }; //
		double x3 = 3D / 5, x2 = (7 - 11 * x3) / 13, x1 = (17 - 23 * x2 - 19 * x3) / 29;
		double[] loesungExpected = //
				{ x1, x2, x3 };
		double[] loesung = GaussschesEliminationsverfahren.loese(matrix, vektor);
		assertArrayEquals("Matrix ist kaputt.", matrixExpected, matrix);
		assertArrayEquals("Vektor ist kaputt.", vektorExpected, vektor);
		assertArrayEquals("Loesung ist kaputt.", loesungExpected, loesung, 666e-6);
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