import static org.junit.Assert.*;
import org.junit.*;

public class TreeDetectorPublicTest {

	@Test(timeout = 1000)
	public void testIsHeap() {
		TreeDetector treeDetector = new TreeDetector();
		assertTrue("Tree is heap", treeDetector.isHeap(TreeGenerator.getExampleHeap()));
	}

	@Test(timeout = 1000)
	public void testIsBinarySearchTree() {
		TreeDetector treeDetector = new TreeDetector();
		assertTrue("Tree is binary search tree", treeDetector.isBinarySearchTree(TreeGenerator.getExampleBinarySearchTree()));
	}

	@Test(timeout = 1000)
	public void testIsCompiling() {
		TreeDetector treeDetector = new TreeDetector();
		assertTrue("Tree is compiling", treeDetector.isBinarySearchTree(null));
	}

	public static void main(String args[]) {
		// to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
		// to run on command line: java -cp .:/usr/share/java/junit4.jar Bin2LongPublicTest

		// starts junit runner - don't try to understand!
		org.junit.runner.JUnitCore.main(new Object() {
		}.getClass().getEnclosingClass().getSimpleName());
	}
}
