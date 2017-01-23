import static org.junit.Assert.*;
import org.junit.*;

public class QuickSortPublicTest {

	@Test(timeout = 100)
	public void testSwap() throws Exception {
		Integer a[] = new Integer[] { 3, 5, 1, 2, 4, 1 };
		Integer b[] = QuickSort.swap(a, 0, 3);
		assertSame("Don't create new array", a, b);
		assertArrayEquals("swap", new Integer[] { 2, 5, 1, 3, 4, 1 }, a);
	}

	@Test(timeout = 100)
	public void testChoosePivot() throws Exception {
		Integer a[] = new Integer[] { 3, 5, 1, 2, 4, 1 };
		int p = QuickSort.choosePivot(a, 0, 5);
		assertEquals("pivot", 2, p);
	}

	@Test(timeout = 100)
	public void testPartition() throws Exception {
		Integer a[] = new Integer[] { 3, 5, 1, 2, 4, 1 };
		int p = QuickSort.partition(a, 2, 0, 5);
		assertEquals("pivot index", 1, p);
		assertEquals("pre pivot value", 1, (int) a[0]);
		assertEquals("pivot value", 1, (int) a[1]);
		int t[] = new int[4];
		for (int i = 2; i <= 5; ++i) {
			assertTrue("post pivot value range", a[i] > 1 && a[i] <= 5);
			assertTrue("post pivot no double value", t[a[i] - 2] == 0);
			t[a[i] - 2]++;
		}
	}

	@Test(timeout = 100)
	public void testSort() throws Exception {
		Integer a[] = new Integer[] { 3, 5, 1, 2, 4, 1 };
		QuickSort.sort(a);
		assertArrayEquals("sort", new Integer[] { 1, 1, 2, 3, 4, 5 }, a);
	}

	public static void main(String args[]) {
		// to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
		// to run on command line: java -cp .:/usr/share/java/junit4.jar Bin2LongPublicTest

		// starts junit runner - don't try to understand!
		org.junit.runner.JUnitCore.main(new Object() {
		}.getClass().getEnclosingClass().getSimpleName());
	}
}
