public class Node {
	private Node leftChild;
	private Node rightChild;
	private final int value;

	public Node(int value) {
		assertValueNotNull(value);
		assertValuePositiveOrZero(value);
		this.value = value;
	}

	public Node(int value, Node leftChild, Node rightChild) {
		assertValueNotNull(value);
		assertValuePositiveOrZero(value);

		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.value = value;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public Integer getValue() {
		return value;
	}

	public void setLeftChild(Node node) {
		leftChild = node;
	}

	public void setRightChild(Node node) {
		rightChild = node;
	}

	protected void assertValueNotNull(Integer value) {
		if (value == null) {
			throw new IllegalArgumentException("NULL is not accepted as a value.");
		}
	}

	protected void assertValuePositiveOrZero(Integer value) {
		if (value < 0) {
			throw new IllegalArgumentException("Value of a node must be positive or zero.");
		}
	}
}
