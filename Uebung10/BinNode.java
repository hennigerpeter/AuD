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

		if (!this.isTree())
			return -1;

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

		return getHeightHelper();
	}

	private int getHeightHelper() {

		int childCountChild = 0;
		int childCountSiblingPrev = 0;
		int childCountSibling = 0;

		// wir bewegen uns auf einer ebene, hier wird jedoch auf das Kind
		// zugegriffen
		BinNode<T> nextSibling = this.sibling;

		if (child != null) {
			childCountChild = 1;
			childCountChild += child.getHeightHelper();
		} else
			return 0;

		while (nextSibling != null) {

			childCountSibling += nextSibling.getHeightHelper();
			childCountSibling = 1;
			childCountSiblingPrev = Integer.max(childCountSiblingPrev, childCountSibling);
			nextSibling = nextSibling.sibling;
		}

		return Integer.max(childCountSiblingPrev, childCountChild);
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
		if (isBinarySearchTree() == false)
			return false;
		int h = 0;
		if (child != null)
			if (child.sibling != null) {
				int sib = child.sibling.getHeightHelper();
				int chi = child.getHeightHelper();
				h = chi - sib;
				if (h >= -1 && h <= 1)
					return true;
			}
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
		BinNode<T> right = null;
		if (left != null)
			right = node.child.sibling;
		while (node != null) {

			if (left.value.compareTo(value) >= 0)
				return false;

			if (right != null) {
				if (left.value.compareTo(right.value) >= 0)
					return false;
				if (left.value.compareTo(right.value) >= 0)
					return false;
				if (right.value.compareTo(node.value) <= 0)
					return false;
			}
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

				if (node.sibling.child != null)
					if (node.sibling.child.sibling != null)
						if (node.sibling.child.sibling.sibling != null)
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

		if (!this.isBinaryTree())
			return false;

		return isMaxHeapHelper();
	}

	private boolean isMaxHeapHelper() {
		// TODO Auto-generated method stub
		BinNode<T> currentChild = child;

		if (currentChild != null) {
			BinNode<T> currentSibling = child.sibling;

			if (currentChild.value.compareTo(value) > 0)
				return false;

			if (currentChild.isMaxHeapHelper() == false)
				return false;

			while (currentSibling != null) {

				if (currentSibling.value.compareTo(value) > 0)
					return false;

				if (currentSibling.value.compareTo(currentChild.value) > 0)
					return false;

				if (currentSibling.isMaxHeapHelper() == false)
					return false;

				currentChild = currentSibling;
				currentSibling = currentSibling.sibling;
			}
		}

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

		// Is BinaryTree vlt nicht bei jedem mal pruefen sondern nur beim ersten
		// lauf
		if (!this.isBinaryTree())
			return false;

		return isMinHeapHelper();
	}

	private boolean isMinHeapHelper() {
		// TODO Auto-generated method stub

		BinNode<T> currentChild = child;

		if (currentChild != null) {
			BinNode<T> currentSibling = child.sibling;

			if (currentChild.value.compareTo(value) < 0)
				return false;

			if (currentChild.isMinHeapHelper() == false)
				return false;

			while (currentSibling != null) {

				if (currentSibling.value.compareTo(value) < 0)
					return false;

				if (currentSibling.value.compareTo(currentChild.value) < 0)
					return false;

				if (currentSibling.isMinHeapHelper() == false)
					return false;

				currentChild = currentSibling;
				currentSibling = currentSibling.sibling;
			}
		}

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

		// now let's take a look at the child
		node = node.child;

		// Check the child's children
		while (node != null) {
			if (checkChildren(node, nodeMap) == false)
				return false;

			// Check the siblings
			node = node.sibling;
		}

		return true;
	}

	public static void main(String[] args) {
		// __________d__________
				// ______//_____\_______
				// _____b========w______
				// ___//_\_____//_\_____
				// ___a===g____h===z____
				BinNode<Alephbeth> h =
					new BinNode<>(Alephbeth.He,
								  new BinNode<>(Alephbeth.Zajin, null, null), null);
				BinNode<Alephbeth> a =
					new BinNode<>(Alephbeth.Aleph,
								  new BinNode<>(Alephbeth.Gimel, null, null), null);
				BinNode<Alephbeth> w =
					new BinNode<>(Alephbeth.Waw,
								  null, h);
				BinNode<Alephbeth> b =
					new BinNode<>(Alephbeth.Beth,
								  w,
								  a);
				BinNode<Alephbeth> simpleBinarySearchTree = new BinNode<>(Alephbeth.Daleth,
							  null, b);
		boolean res = simpleBinarySearchTree.isAVLTree();
	}
}
