import java.util.HashMap;

public class BinNode<T extends java.lang.Comparable<T>> extends AbstractBinNode<T> {

	/*
	 * value: The payload wrapped by the current node. This reference might be
	 * null.
	 * 
	 * sibling: The next sibling of the current node. This reference is null if
	 * the current node is the last ("rightmost") node.
	 * 
	 * child: The first ("leftmost") child, i.e. the head of the linked list
	 * comprising all the children of the current node. This reference is null
	 * if the current node is a leaf (with no children).
	 */
	public BinNode(T value, BinNode<T> sibling, BinNode<T> child) {
		super(value, sibling, child);
	}

	/*
	 * Computes the maximum branching factor of the tree with the current node
	 * as root, if this is the root of a legal tree.
	 * 
	 */
	@Override
	public int getBranchingFactor() {

//		if (!this.isTree())
//			return -1;

		return getBranchingHelper();
	}

	private int getBranchingHelper() {

		int siblingCount = 0;
		if (this.child != null) {

			BinNode<T> sibling = this.child.sibling;
			while (sibling != null) {
				siblingCount++;
				siblingCount += sibling.getBranchingHelper();
				sibling = sibling.sibling;
				
			}
			int others = this.child.getBranchingFactor();

			if (others > siblingCount)
				return others;

			return siblingCount;

		}
		return 0;
	}

	/**
	 * Computes the height of the current node in the tree, if this is the root
	 * of a legal tree.
	 * 
	 * @return
	 *         <ul>
	 *         <li>-1 if the current node is not the root of a legal tree</li>
	 *         <li>0 if the current node is a leaf</li>
	 *         <li>its height in the tree otherwise</li>
	 *         </ul>
	 * @see <a href=
	 *      "http://en.wikipedia.org/wiki/Tree_%28data_structure%29#Terminologies_used_in_Trees">Terminology:
	 *      Height of node</a>
	 * @see #isTree()
	 */
	@Override
	public int getHeight() {

		if (!isTree())
			return -1;

		int childCount = 0;
		int childCountChild = 0;
		int childCountSibling = 0;
		BinNode<T> child = this.child;
		BinNode<T> sibling = this.sibling;

		if (this.child != null) {
			childCountChild = 1 + child.getHeight();
		}

		if (this.sibling != null)
			childCountSibling = 1 + this.sibling.getHeight();

		if (childCountSibling > childCountChild)
			return childCountSibling;

		return childCountSibling;
	}

	/**
	 * Checks if the current node is the root of a legal <i>AVL tree</i>, i.e.
	 * if the current tree is a balanced binary search tree.
	 * 
	 * @return true if the current node is the root of an <i>AVL tree</i>; false
	 *         otherwise.
	 * @see <a href="http://en.wikipedia.org/wiki/AVL_tree">AVL tree</a>
	 * @see #isBinarySearchTree()
	 * @see #getHeight()
	 */
	@Override
	public boolean isAVLTree() {
		// TODO Auto-generated method stub
		if (isBinaryTree() == false)
			return false;

		int left = 0;
		int right = 0;

		if (child != null) {
			left = child.getHeight();
			if (child.sibling != null)
				right = child.sibling.getHeight();
		}
		int h = child.getHeight() - child.sibling.getHeight();

		if (h >= -1 && h <= 1)
			return true;

		return false;
	}

	/*
	 * Checks if the current node is the root of a legal binary search tree,
	 * i.e.(non-Javadoc)
	 * 
	 */
	@Override
	public boolean isBinarySearchTree() {
		// TODO Auto-generated method stub
		if (isBinaryTree() == false)
			return false;

		BinNode<T> node = this;
		BinNode<T> left = node.child;
		BinNode<T> right = node.child.sibling;

		while (node != null) {

			if (left.value.compareTo(value) >= 0)
				return false;
			if (left.value.compareTo(right.value) >= 0)
				return false;
			if (left.value.compareTo(child.sibling.value) >= 0)
				return false;
			if (right.value.compareTo(value) <= 0)
				return false;

			node = node.child;
		}

		return true;
	}

	/*
	 * Checks if the current node is the root of a legal binary
	 * tree.(non-Javadoc)
	 * 
	 */
	@Override
	public boolean isBinaryTree() {
		// TODO Auto-generated method stub
		if (isTree() == false)
			return false;

		BinNode<T> node = this;

		if (node.sibling != null)
			return false;

		while (node.child != null) {

			// Check Child
			node = node.child;

			// children can only have 1 sibling
			if (node.sibling != null) {
				if (node.sibling.sibling != null)
					return false;
			}

		}

		return true;
	}

	/**
	 * Checks if the current node is the root of a legal <i>Maxheap</i>
	 * satisfying the shape and the heap properties and having the greatest
	 * {@linkplain #value} in this (root) node.
	 * 
	 * @return true if the current node is the root of an <i>Maxheap</i>; false
	 *         otherwise.
	 * @see <a href="http://en.wikipedia.org/wiki/Binary_heap">Binary heap</a>
	 * @see Comparable
	 */
	@Override
	public boolean isMaxHeap() {

		if (child != null) {

			if (child.value.compareTo(value) > 1)
				return false;

			if (child.isMinHeap() == false)
				return false;
		}

		if (sibling != null) {

			if (sibling.value.compareTo(value) > 1)
				return false;

			if (sibling.isMinHeap() == false)
				return false;
		}

		// if (child != null && sibling != null)
		// if (child.value.compareTo(child.sibling.value) > 1)
		// return false;

		return true;
	}

	/**
	 * Checks if the current node is the root of a legal <i>Minheap</i>
	 * satisfying the shape and the heap properties and having the smallest
	 * {@linkplain #value} in this (root) node.
	 * 
	 * @return true if the current node is the root of an <i>Minheap</i>; false
	 *         otherwise.
	 * @see <a href="http://en.wikipedia.org/wiki/Binary_heap">Binary heap</a>
	 * @see Comparable
	 */
	@Override
	public boolean isMinHeap() {

		if (child != null) {

			if (child.value.compareTo(value) < 1)
				return false;

			if (child.isMinHeap() == false)
				return false;
		}

		if (sibling != null) {

			if (sibling.value.compareTo(value) < 1)
				return false;

			if (sibling.isMinHeap() == false)
				return false;
		}

		// if (child != null && sibling != null)
		// if (child.value.compareTo(child.sibling.value) > 1)
		// return false;

		return true;

	}

	/**
	 * Checks if the current node is the root of a legal general tree.
	 * 
	 * @return true if the current node is the root of a tree; false otherwise
	 *         (e.g. in the case of a <a href=
	 *         "http://en.wikipedia.org/wiki/Directed_acyclic_graph">DAG</a>).
	 * @see <a href=
	 *      "http://de.wikipedia.org/wiki/Gewurzelter_Baum">Arborescence</a>
	 * @see <a href="http://de.wikipedia.org/wiki/Out-Tree">Out-Tree</a>
	 */
	@Override
	public boolean isTree() {

		// If the root has siblings, we are all doomed
		if (this.sibling != null)
			return false;

		// checks if all nodes are only pointed at once - recursive for all
		// children
		HashMap<BinNode<T>, Boolean> NodeMap = new HashMap<BinNode<T>, Boolean>();
		return checkChildren(this, NodeMap);

	}

	private boolean checkChildren(BinNode<T> node, HashMap<BinNode<T>, Boolean> nodeMap) {

		// Check if the Node is already listed
		if (nodeMap.get(node) != null)
			return false;

		nodeMap.put(node, true);

		if (node.child != null) {
			node = node.child;

			// Check the child's children
			while (node != null) {
				if (checkChildren(node, nodeMap) == false)
					return false;

				// Check the siblings
				node = node.sibling;
			}
		}
		return true;
	}
}
