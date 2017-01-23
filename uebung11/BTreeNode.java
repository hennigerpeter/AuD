import java.util.ArrayList;

public class BTreeNode {
	private final ArrayList<Integer> keys;
	private final ArrayList<BTreeNode> children;
	private final int degree;

	public int getDegree() {
		return degree;
	}

	public BTreeNode(int degree) {
		keys = new ArrayList<Integer>();
		children = new ArrayList<BTreeNode>();
		this.degree = degree;
	}

	public ArrayList<Integer> getKeys() {
		return keys;
	}

	public ArrayList<BTreeNode> getChildren() {
		return children;
	}

	public void addKey(int key) {
		keys.add(key);
	}

	public void addChild(BTreeNode child) {
		children.add(child);
	}

	private boolean isLeaf() {
		return (children.size() == 0);
	}

	private int identifyIndex(int key) {
		for (int i = 0; i < keys.size(); i++) {
			if (Integer.compare(key, keys.get(i)) < 0) {
				return i;
			}
		}
		return keys.size();
	}

	public boolean hasKey(int key) {
		// TODO
		return true;
	}

	public OverflowNode insert(int key) {
		// TODO
		return null;
	}

	public OverflowNode split() {
		// TODO
		return null;
	}

	public String toJson() {
		// TODO
		return null;
	}

	public void print(String pre) {
		System.out.print(pre + "--> ");
		for (Integer i : keys) {
			System.out.print(i.toString() + " ");
		}
		System.out.println();
		for (BTreeNode child : children) {
			child.print(pre + "\t");
		}
	}
}
