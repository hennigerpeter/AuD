public abstract class AbstractBinNode<T extends Comparable<T>> {
	/**
	 * The payload wrapped by the current node. This reference might be null.
	 */
	protected T value;

	/**
	 * The next sibling of the current node. This reference is null if the current node is the last ("rightmost") node.
	 */
	protected BinNode<T> sibling;

	/**
	 * The first ("leftmost") child, i.e. the head of the linked list comprising all the children of the current node. This reference is null if the current node is a leaf (with no children).
	 */
	protected BinNode<T> child;
	
	public AbstractBinNode(T value, BinNode<T> sibling, BinNode<T> child) {
		this.value = value;
		this.sibling = sibling;
		this.child = child;
	}

	/**
	 * Checks if the current node is the root of a legal general tree.
	 * 
	 * @return true if the current node is the root of a tree; false otherwise (e.g. in the case of a <a href="http://en.wikipedia.org/wiki/Directed_acyclic_graph">DAG</a>).
	 * @see <a href="http://de.wikipedia.org/wiki/Gewurzelter_Baum">Arborescence</a>
	 * @see <a href="http://de.wikipedia.org/wiki/Out-Tree">Out-Tree</a>
	 */
	public abstract boolean isTree();

	/**
	 * Computes the height of the current node in the tree, if this is the root of a legal tree.
	 * 
	 * @return <ul>
	 *         <li>-1 if the current node is not the root of a legal tree</li>
	 *         <li>0 if the current node is a leaf</li>
	 *         <li>its height in the tree otherwise</li>
	 *         </ul>
	 * @see <a href="http://en.wikipedia.org/wiki/Tree_%28data_structure%29#Terminologies_used_in_Trees">Terminology: Height of node</a>
	 * @see #isTree()
	 */
	public abstract int getHeight();

	/**
	 * Computes the maximum branching factor of the tree with the current node as root, if this is the root of a legal tree.
	 * 
	 * @return <ul>
	 *         <li>-1 if the current node is not the root of a legal tree</li>
	 *         <li>the maximum degree of the current tree and all its subtrees otherwise</li>
	 *         </ul>
	 * @see <a href="http://en.wikipedia.org/wiki/Tree_%28data_structure%29#Terminologies_used_in_Trees">Terminology: Degree</a>
	 * @see <a href="http://en.wikipedia.org/wiki/Branching_factor">Branching factor</a>
	 * @see #isTree()
	 */
	public abstract int getBranchingFactor();

	/**
	 * Checks if the current node is the root of a legal <i>binary tree</i>. The <b>root itself must not have any siblings</b>, but any other node in the subtrees may have at most one sibling.
	 * 
	 * @return true if the current node is the root of a <i>binary tree</i>; false otherwise.
	 * @see <a href="http://en.wikipedia.org/wiki/Binary_tree">Binary tree</a>
	 * @see #isTree()
	 */
	public abstract boolean isBinaryTree();

	/**
	 * Checks if the current node is the root of a legal <i>binary search tree</i>, i.e.
	 * <ul>
	 * <li>if the current tree is a binary tree</li>
	 * <li>and the {@linkplain #value}s in the tree are sorted according to their natural ordering (see {@link Comparable})</li>
	 * </ul>
	 * 
	 * @return true if the current node is the root of a <i>binary search tree</i>; false otherwise.
	 * @see <a href="http://en.wikipedia.org/wiki/Binary_search_tree">Binary search tree</a>
	 * @see #isBinaryTree()
	 * @see Comparable
	 */
	public abstract boolean isBinarySearchTree();

	/**
	 * Checks if the current node is the root of a legal <i>AVL tree</i>, i.e. if the current tree is a balanced binary search tree.
	 * 
	 * @return true if the current node is the root of an <i>AVL tree</i>; false otherwise.
	 * @see <a href="http://en.wikipedia.org/wiki/AVL_tree">AVL tree</a>
	 * @see #isBinarySearchTree()
	 * @see #getHeight()
	 */
	public abstract boolean isAVLTree();

	/**
	 * Checks if the current node is the root of a legal <i>Minheap</i> satisfying the shape and the heap properties and having the smallest {@linkplain #value} in this (root) node.
	 * 
	 * @return true if the current node is the root of an <i>Minheap</i>; false otherwise.
	 * @see <a href="http://en.wikipedia.org/wiki/Binary_heap">Binary heap</a>
	 * @see Comparable
	 */
	public abstract boolean isMinHeap();

	/**
	 * Checks if the current node is the root of a legal <i>Maxheap</i> satisfying the shape and the heap properties and having the greatest {@linkplain #value} in this (root) node.
	 * 
	 * @return true if the current node is the root of an <i>Maxheap</i>; false otherwise.
	 * @see <a href="http://en.wikipedia.org/wiki/Binary_heap">Binary heap</a>
	 * @see Comparable
	 */
	public abstract boolean isMaxHeap();

	/**
	 * Returns a string representation of the current node and its descendants using the <i>Newick tree format</i>. If the current node and its descendants represent a cyclic structure, then this method will not terminate (or probably end up with a {@link StackOverflowError}).
	 * 
	 * @return a string representation of the current node and its descendants using the <i>Newick tree format</i>.
	 * @see <a href="http://en.wikipedia.org/wiki/Newick_format">Newick notation</a>
	 */
	@Override
	public String toString() {
		String result = "";
		if (child != null) {
			result = "(";
			BinNode<T> current = child;
			while (current != null) {
				result += (current == child ? "" : ",") + current.toString();
				current = current.sibling;
			}
			result += ")";
		}
		result += value.toString();
		return result;
	}
}
