import static org.junit.Assert.*;
import org.junit.*;

public class KenKenPublicTest {

	// ================================================================================
	private static final int[][][] kenkenWikipediaOriginal = { //
			{ { 11, '+' }, { 0, 0 }, { 1, 0 } }, //
			{ { 2, '/' }, { 0, 1 }, { 0, 2 } }, //
			{ { 20, '*' }, { 0, 3 }, { 1, 3 } }, //
			{ { 6, '*' }, { 0, 4 }, { 0, 5 }, { 1, 5 }, { 2, 5 } }, //
			{ { 3, '-' }, { 1, 1 }, { 1, 2 } }, //
			{ { 3, '/' }, { 1, 4 }, { 2, 4 } }, //
			{ { 240, '*' }, { 2, 0 }, { 2, 1 }, { 3, 0 }, { 3, 1 } }, //
			{ { 6, '*' }, { 2, 2 }, { 2, 3 } }, //
			{ { 6, '*' }, { 3, 2 }, { 4, 2 } }, //
			{ { 7, '+' }, { 3, 3 }, { 4, 3 }, { 4, 4 } }, //
			{ { 30, '*' }, { 3, 4 }, { 3, 5 } }, //
			{ { 6, '*' }, { 4, 0 }, { 4, 1 } }, //
			{ { 9, '+' }, { 4, 5 }, { 5, 5 } }, //
			{ { 8, '+' }, { 5, 0 }, { 5, 1 }, { 5, 2 } }, //
			{ { 2, '/' }, { 5, 3 }, { 5, 4 } } //
	};

	private static final int[][][] deepCloneKenken(int[][][] kenken) {
		int[][][] copy = null;
		if (kenken != null) {
			copy = new int[kenken.length][][];
			for (int partition = 0; partition < kenken.length; partition++) {
				if (kenken[partition] != null) {
					copy[partition] = new int[kenken[partition].length][];
					for (int subfield = 0; subfield < kenken[partition].length; subfield++) {
						if (kenken[partition][subfield] != null) {
							copy[partition][subfield] = new int[kenken[partition][subfield].length];
							for (int subsubfield = 0; subsubfield < kenken[partition][subfield].length; subsubfield++) {
								copy[partition][subfield][subsubfield] = kenken[partition][subfield][subsubfield];
							}
						}
					}
				}
			}
		}
		return copy;
	}

	// ================================================================================

	@Test(timeout = 666)
	public void test_checkIntegrity_WikipediaOriginal_PUBLIC_TEST() {
		int[][][] testInput = deepCloneKenken(kenkenWikipediaOriginal);
		int actual = KenKen.checkIntegrity(testInput);
		assertEquals("kenkenWikipediaOriginal: checkIntegrity failed.", 0, actual);
		assertArrayEquals("kenkenWikipediaOriginal: checkIntegrity MODIFIED THE INPUT KenKen!", kenkenWikipediaOriginal, testInput);
	}

	@Test(timeout = 666)
	public void test_checkValidity_WikipediaOriginal_PUBLIC_TEST() {
		int[][][] testInput = deepCloneKenken(kenkenWikipediaOriginal);
		int actual = KenKen.checkValidity(testInput);
		assertEquals("kenkenWikipediaOriginal: checkValidity failed.", 0, actual);
		assertArrayEquals("kenkenWikipediaOriginal: checkValidity MODIFIED THE INPUT KenKen!", kenkenWikipediaOriginal, testInput);
	}

	@Test(timeout = 6666)
	public void test_solve_WikipediaOriginal_PUBLIC_TEST() {
		int[][][] testInput = deepCloneKenken(kenkenWikipediaOriginal);
		int[][] expectedSolution = { //
				{ 5, 6, 3, 4, 1, 2 }, //
				{ 6, 1, 4, 5, 2, 3 }, //
				{ 4, 5, 2, 3, 6, 1 }, //
				{ 3, 4, 1, 2, 5, 6 }, //
				{ 2, 3, 6, 1, 4, 5 }, //
				{ 1, 2, 5, 6, 3, 4 } //
		};
		int[][] studentSolution = KenKen.solve(testInput);
		assertNotNull("kenkenWikipediaOriginal: has a solution, but student didn't find it.", studentSolution);
		assertArrayEquals("kenkenWikipediaOriginal: student solution is wrong.", expectedSolution, studentSolution);
		assertArrayEquals("kenkenWikipediaOriginal: solve MODIFIED THE INPUT KenKen!", kenkenWikipediaOriginal, testInput);
	}
}