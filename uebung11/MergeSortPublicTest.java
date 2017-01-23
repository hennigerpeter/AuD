import static org.junit.Assert.*;
import org.junit.*;

public class MergeSortPublicTest {

	@Test(timeout = 100)
	public void testMerge() throws Exception {
		MergeSort mergeSort = new MergeSort();
		List left = new List(new Element(7, null));
		left.first = new Element(4, left.first);
		left.first = new Element(2, left.first);

		List right = new List(new Element(6, null));
		right.first = new Element(3, right.first);

		List merge = mergeSort.merge(left, right);
		assertSame("Should modify and not create new Liste", left, merge);
		Element ptr = merge.first;
		assertEquals("Sorted order", 2, ptr.value);
		ptr = ptr.next;
		assertEquals("Sorted order", 3, ptr.value);
		ptr = ptr.next;
		assertEquals("Sorted order", 4, ptr.value);
		ptr = ptr.next;
		assertEquals("Sorted order", 6, ptr.value);
		ptr = ptr.next;
		assertEquals("Sorted order", 7, ptr.value);
		ptr = ptr.next;
		assertNull("Liste datastructure consistency", ptr);
	}

	@Test(timeout = 100)
	public void testSort0() throws Exception {
		MergeSort mergeSort = new MergeSort();
		List list = new List(new Element(5, null));
		list.first = new Element(4, list.first);
		list.first = new Element(1, list.first);
		list.first = new Element(3, list.first);
		list.first = new Element(2, list.first);
		List liste = mergeSort.doSort(list, 5);
		Element ptr = liste.first;
		assertEquals("Sorted order", 1, ptr.value);
		ptr = ptr.next;
		assertEquals("Sorted order", 2, ptr.value);
		ptr = ptr.next;
		assertEquals("Sorted order", 3, ptr.value);
		ptr = ptr.next;
		assertEquals("Sorted order", 4, ptr.value);
		ptr = ptr.next;
		assertEquals("Sorted order", 5, ptr.value);
		ptr = ptr.next;
		assertNull("Liste datastructure consistency", ptr);
	}

	@Test(timeout = 100)
	public void testSort1() throws Exception {
		MergeSort mergeSort = new MergeSort();
		List liste = new List(new Element(5, null));
		liste.first = new Element(4, liste.first);
		liste.first = new Element(1, liste.first);
		liste.first = new Element(3, liste.first);
		liste.first = new Element(2, liste.first);
		mergeSort.sort(liste);
		Element ptr = liste.first;
		assertEquals("Sorted order", 1, ptr.value);
		ptr = ptr.next;
		assertEquals("Sorted order", 2, ptr.value);
		ptr = ptr.next;
		assertEquals("Sorted order", 3, ptr.value);
		ptr = ptr.next;
		assertEquals("Sorted order", 4, ptr.value);
		ptr = ptr.next;
		assertEquals("Sorted order", 5, ptr.value);
		ptr = ptr.next;
		assertNull("Liste datastructure consistency", ptr);
	}

	public static void main(String args[]) {
		// to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
		// to run on command line: java -cp .:/usr/share/java/junit4.jar Bin2LongPublicTest

		// starts junit runner - don't try to understand!
		org.junit.runner.JUnitCore.main(new Object() {
		}.getClass().getEnclosingClass().getSimpleName());
	}
}
