public class BTree {
	private BTreeNode root = null;
	private final int degree;

	public BTree(int degree) {
		this.degree = degree;
	}

	public int getDegree() {
		return degree;
	}

	public void setRoot(BTreeNode root) {
		this.root = root;
	}

	public BTreeNode getRoot() {
		return root;
	}

	public boolean hasKey(int key) {
		// TODO
		return true;
	}

	public void insert(int key) {
		// TODO
	}

	public String toJson() {
		// TODO
		return null;
	}

	public void printTree() {
		if (root != null) {
			root.print("");
		}
	}
}
