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

		int siblingCount = 1;
		BinNode<T> sibling = this.sibling;

		while (sibling != null) {
			sibling = sibling.sibling;
			siblingCount++;
		}
		return siblingCount;
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

		int childCount = 1;
		int childCountSibling = 0;
		BinNode<T> child = this.child;
		BinNode<T> sibling = this.sibling;

		if (this.child != null)
			childCount += child.getHeight();

		if (this.sibling != null)
			childCountSibling = this.sibling.getHeight();

		if (childCountSibling > childCount)
			return childCountSibling;

		return childCount;
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
		return false;
	}

	/*
	 * Checks if the current node is the root of a legal binary
	 * tree.(non-Javadoc)
	 * 
	 */
	@Override
	public boolean isBinaryTree() {
		// TODO Auto-generated method stub
		return false;
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
		
		if (child != null){
			
			if(child.value.compareTo(value) > 1)
				return false;
			
			if (child.isMinHeap() == false)
				return false;
		}

		if (sibling != null) {
			
			if(sibling.value.compareTo(value) > 1)
				return false;
			
			if (sibling.isMinHeap() == false)
				return false;
		}
		
//		if (child != null && sibling != null)
//			if (child.value.compareTo(child.sibling.value) > 1)
//				return false;

		return true;
	}

	/**
	 * Checks if the current node is the root of a legal <i>Minheap</i> satisfying the shape and the heap properties and having the smallest {@linkplain #value} in this (root) node.
	 * 
	 * @return true if the current node is the root of an <i>Minheap</i>; false otherwise.
	 * @see <a href="http://en.wikipedia.org/wiki/Binary_heap">Binary heap</a>
	 * @see Comparable
	 */
	@Override
	public boolean isMinHeap() {
		
		if (child != null){
		
			if(child.value.compareTo(value) < 1)
				return false;
			
			if (child.isMinHeap() == false)
				return false;
		}

		if (sibling != null) {
			
			if(sibling.value.compareTo(value) < 1)
				return false;
			
			if (sibling.isMinHeap() == false)
				return false;
		}
		
//		if (child != null && sibling != null)
//			if (child.value.compareTo(child.sibling.value) > 1)
//				return false;

		
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

		if (child != null)
			if (child.isTree() == false)
				return false;

		if (sibling != null) {
			if (sibling.isTree() == false)
				return false;
			if (sibling.value == null)
				return false;
		}

		return true;
	}

	/**
	 * Returns a string representation of the current node and its descendants
	 * using the <i>Newick tree format</i>. If the current node and its
	 * descendants represent a cyclic structure, then this method will not
	 * terminate (or probably end up with a {@link StackOverflowError}).
	 * 
	 * @return a string representation of the current node and its descendants
	 *         using the <i>Newick tree format</i>.
	 * @see <a href="http://en.wikipedia.org/wiki/Newick_format">Newick
	 *      notation</a>
	 */
	@Override
	public String toString() {
		return "NotYetImplemented";
	}

}
