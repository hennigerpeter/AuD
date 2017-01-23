public class TreeGenerator {

	public static Node getExampleBinarySearchTree() {
		Node three, ten, one, six, fourteen, four, seven, thirteen;

		thirteen = new Node(13);
		fourteen = new Node(14, thirteen, null);
		ten = new Node(10, null, fourteen);

		four = new Node(4);
		seven = new Node(7);
		six = new Node(6, four, seven);

		one = new Node(1);
		three = new Node(3, one, six);

		return new Node(8, three, ten);
	}

	public static Node getExampleHeap() {
		Node nineteen, thirtysix, seventeen, three, twentyfive, one, two, seven;

		one = new Node(1);
		twentyfive = new Node(25);
		thirtysix = new Node(36, twentyfive, one);

		two = new Node(2);
		seven = new Node(7);
		seventeen = new Node(17, two, seven);

		three = new Node(3);
		nineteen = new Node(19, seventeen, three);

		return new Node(100, nineteen, thirtysix);
	}
}
