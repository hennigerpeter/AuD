import static org.junit.Assert.*;
import java.lang.reflect.*;
import org.junit.*;

public class BTreePublicTest {

	private static void setRoot(BTree tree, BTreeNode node) {
		try {
			Object[] parameters = { node };

			Method method = null;
			Method[] methods = tree.getClass().getDeclaredMethods();
			for (int i = 0; i < methods.length; i++) {
				if (methods[i].getName().equals("setRoot")) {
					method = methods[i];
					break;
				}
			}
			method.setAccessible(true);
			method.invoke(tree, parameters);
		} catch (Exception e) {
		}
	}

	private static <T extends Comparable<? super T>> boolean containsKey(BTree tree, Integer key) {
		BTreeNode root = tree.getRoot();
		return (root == null) ? false : root.hasKey(key);
	}

	private static <T extends Comparable<? super T>> void insertKey(BTree tree, Integer key) {
		if (!containsKey(tree, key)) {
			BTreeNode root = tree.getRoot();
			int degree = tree.getDegree();
			if (root == null) {
				root = new BTreeNode(degree);
				setRoot(tree, root);
			}
			OverflowNode o = root.insert(key);
			if (o != null) {
				BTreeNode newRoot = new BTreeNode(degree);
				newRoot.addKey(o.getValue());
				newRoot.addChild(root);
				newRoot.addChild(o.getRightChild());
				root = newRoot;
				setRoot(tree, root);
			}
		}
	}

	private static void checkDegree(BTree tree) {
		checkNodeDegreeRec(tree.getRoot(), tree.getDegree(), true);
	}

	private static void checkNodeDegreeRec(BTreeNode node, int degree, boolean root) {
		int n_val = node.getKeys().size();
		int n_children = node.getChildren().size();
		int d = node.getDegree();
		assertTrue("checking degree of the node... (lower bound)", n_val >= d || root);
		assertTrue("checking degree of the node... (upper bound)", n_val <= 2 * d);
		assertEquals("checking degree of the node... (degree field) ", d, degree);
		assertTrue("checking degree of the node... (values and children relation) ",
				n_val + 1 == n_children || n_children == 0);
		for (BTreeNode next : node.getChildren()) {
			checkNodeDegreeRec(next, degree, false);
		}
	}

	private static void checkSearchProperty(BTree tree) {
		checkSearchPropertyRec(tree.getRoot(), null, null);
	}

	private static void checkSearchPropertyRec(BTreeNode node, Integer valLeft, Integer valRight) {
		int n_children = node.getChildren().size();
		int n_val = node.getKeys().size();
		for (int i = 0; i < n_children; i++) {
			BTreeNode child = node.getChildren().get(i);
			Integer nextLeft = i > 0 ? node.getKeys().get(i - 1) : null;
			Integer nextRight = i < n_val ? node.getKeys().get(i) : null;

			assertTrue("checking the search property... (lower bound)",
					nextLeft == null || valRight == null || nextLeft.compareTo(valRight) < 0);
			assertTrue("checking the search property... (upper bound)",
					nextLeft == null || valLeft == null || nextLeft.compareTo(valLeft) > 0);
			assertTrue("checking the search property... (local order)",
					nextLeft == null || nextRight == null || nextLeft.compareTo(nextRight) < 0);
			checkSearchPropertyRec(child, nextLeft, nextRight);
		}
	}

	private static void checkBalance(BTree tree) {
		checkNodeBalanceRec(tree.getRoot());
	}

	private static int checkNodeBalanceRec(BTreeNode node) {
		int hight = 0;
		for (BTreeNode next : node.getChildren()) {
			int h_i = checkNodeBalanceRec(next);
			if (hight == 0) {
				hight = h_i;
			}
			assertEquals("checking the balance property...", hight, h_i);
		}
		return hight + 1;
	}

	private static void checkBTree(BTree tree) {
		checkBalance(tree);
		checkSearchProperty(tree);
		checkDegree(tree);
	}

	private static <T extends Comparable<? super T>> void checkContains(BTree tree, Integer elem, boolean contains) {
		assertTrue("checking element... " + elem + " (" + contains + ")", tree.hasKey(elem) == contains);
	}

	private static void checkValues(BTree tree, Integer[] elems) {
		for (int i = 0; i < elems.length; i++) {
			checkContains(tree, elems[i], true);
		}
	}

	private static BTree buildTree(int deg, Integer[] elems) {
		BTree ret = new BTree(deg);
		for (int i = 0; i < elems.length; i++) {
			insertKey(ret, elems[i]);
		}
		return ret;
	}

	private static BTree buildTreeInsert(int deg, Integer[] elems) {
		BTree ret = new BTree(deg);
		for (int i = 0; i < elems.length; i++) {
			ret.insert(elems[i]);
		}
		return ret;
	}

	private static BTree buildIntTree1_i() {
		Integer elems[] = { 17, 23, 21 };
		return buildTreeInsert(2, elems);
	}

	private static BTree buildIntTree2_i() {
		Integer elems[] = { 17, 23, 21, 22, 2, 8, 9 };
		return buildTreeInsert(2, elems);
	}

	private static BTree buildIntTree3_i() {
		Integer elems[] = { 17, 23, 21, 22, 2, 8, 9, 13, 18, 19 };
		return buildTreeInsert(2, elems);
	}

	private static BTree buildIntTree2() {
		Integer elems[] = { 17, 23, 21, 22, 2, 8, 9 };
		return buildTree(2, elems);
	}

	private static BTree buildIntTree3() {
		Integer elems[] = { 17, 23, 21, 22, 2, 8, 9, 13, 18, 19 };
		return buildTree(2, elems);
	}

	@Test(timeout = 1000)
	public void main_insert1() {
		BTree tree = buildIntTree1_i();
		checkBTree(tree);
		Integer elems[] = { 17, 23, 21 };
		checkValues(tree, elems);
	}

	@Test(timeout = 1000)
	public void main_insert2_i() {
		BTree tree = buildIntTree2();
		checkBTree(tree);
		Integer elems[] = { 17, 23, 21, 22, 2, 8, 9 };
		checkValues(tree, elems);
	}

	@Test(timeout = 1000)
	public void main_insert3_i() {
		BTree tree = buildIntTree3();
		checkBTree(tree);
		Integer elems[] = { 17, 23, 21, 22, 2, 8, 9, 13, 18, 19 };
		checkValues(tree, elems);
	}

	@Test(timeout = 1000)
	public void main_insert1n() {
		BTree tree = buildIntTree1_i();
		checkBTree(tree);
		Integer elems[] = { 17, 23, 21 };
		checkValues(tree, elems);
	}

	@Test(timeout = 1000)
	public void main_insert2n() {
		BTree tree = buildIntTree2_i();
		checkBTree(tree);
		Integer elems[] = { 17, 23, 21, 22, 2, 8, 9 };
		checkValues(tree, elems);
	}

	@Test(timeout = 1000)
	public void main_insert3n() {
		BTree tree = buildIntTree3_i();
		checkBTree(tree);
		Integer elems[] = { 17, 23, 21, 22, 2, 8, 9, 13, 18, 19 };
		checkValues(tree, elems);
	}

	@Test(timeout = 1000)
	public void main_contains1() {
		BTree tree = buildIntTree3();
		checkContains(tree, 18, true);
		checkContains(tree, 2, true);
		checkContains(tree, 116, false);
		checkContains(tree, -1, false);
	}

	@Test(timeout = 1000)
	public void main_contains1n() {
		BTree tree = buildIntTree3();
		checkContains(tree, 18, true);
		checkContains(tree, 2, true);
		checkContains(tree, 116, false);
		checkContains(tree, -1, false);
	}

	@Test(timeout = 1000)
	public void testToJson_WithComplexEntries_Public() {
		BTree tree = new BTree(2);
		tree.insert(17);
		tree.insert(23);
		tree.insert(21);
		tree.insert(22);
		tree.insert(2);
		tree.insert(8);
		tree.insert(9);
		tree.insert(13);
		tree.insert(18);
		tree.insert(19);

		assertEquals("{node:[9,21],children:[{node:[2,8]},{node:[13,17,18,19]},{node:[22,23]}]}",
				removeWhiteSpace(tree.toJson()));
	}

	protected static String removeWhiteSpace(String _str) {
		return _str.replaceAll("\\s+", "");
	}

	public static void main(String args[]) {
		// to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
		// to run on command line: java -cp .:/usr/share/java/junit4.jar Bin2LongPublicTest

		// starts junit runner - don't try to understand!
		org.junit.runner.JUnitCore.main(new Object() {
		}.getClass().getEnclosingClass().getSimpleName());
	}
}
