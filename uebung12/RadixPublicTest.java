import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class RadixPublicTest {

	@Test(timeout=100)
	public void testGetChar() throws Exception {
		String a = "Bach";
		String b = "Bachmann";
		String c = "";
		for(int i=0; i<b.length(); ++i){
			c += NameSorter.getCharOrDefault(a, i);
		}
		assertTrue(c.compareTo(b) < 0);
	}
	
	@Test(timeout=100)
	public void testOneStep() throws Exception {
		ArrayList<NameEntry> list = new ArrayList<NameEntry>();
		list.add(new NameEntry("Schmitt","Bernd"));
		list.add(new NameEntry("Mueller","David"));
		list.add(new NameEntry("Schmitt","Conrad"));
		list.add(new NameEntry("Mueller","Adam"));
		list = NameSorter.radixOneStep(list, true, 0);
		assertEquals("Adam", list.get(0).firstName);
		assertEquals("Bernd", list.get(1).firstName);
		assertEquals("Conrad", list.get(2).firstName);
		assertEquals("David", list.get(3).firstName);
	}

	@Test(timeout=100)
	public void testSort() throws Exception {
		ArrayList<NameEntry> list = new ArrayList<NameEntry>();
		list.add(new NameEntry("Schmitt","Bernd"));
		list.add(new NameEntry("Mueller","David"));
		list.add(new NameEntry("Schmitt","Conrad"));
		list.add(new NameEntry("Mueller","Adam"));
		list = NameSorter.sortEntries(list);
		assertEquals("Adam", list.get(0).firstName);
		assertEquals("David", list.get(1).firstName);
		assertEquals("Bernd", list.get(2).firstName);
		assertEquals("Conrad", list.get(3).firstName);
	}
	
	public static void main(String args[]) {
		// to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
		// to run on command line: java -cp .:/usr/share/java/junit4.jar RadixPublicTest

		// starts junit runner - don't try to understand!
		org.junit.runner.JUnitCore.main(new Object(){}.getClass().getEnclosingClass().getSimpleName());
	}
}
