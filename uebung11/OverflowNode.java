public class OverflowNode {
	// the key in the node
	private final Integer key;
	// the right successor
	private final BTreeNode rightChild;

	OverflowNode(Integer _key, BTreeNode _rightChild) {
		key = _key;
		rightChild = _rightChild;
	}

	public Integer getValue() {
		return key;
	}

	public BTreeNode getRightChild() {
		return rightChild;
	}
}