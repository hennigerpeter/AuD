public class TreeDetector {

	public boolean isHeap(Node node) {
		// MaxHeap
		// Left < Value > Right
		// Left < Right

		// Sonderfall Teilaufgabe c
		if (node == null)
			return true;

		Node l = node.getLeftChild();
		Node r = node.getRightChild();

		// Sonderfall Teilaufgabe c
		if (l == null && r == null)
			return true;

		// Wenn rechts groesser ist, ist es kein Max Heap
		if (l != null) {
			if (l.getValue().compareTo(node.getValue()) > 0)
				return false;

			// Ist die linke Seite kein Max Heap, haben wir keinen Max Heap
			if (!isHeap(l))
				return false;
		}

		// Wenn links groesser ist, ist es kein Max Heap
		if (r != null) {
			if (r.getValue().compareTo(node.getValue()) > 0)
				return false;

			// Ist die rechte Seite kein Max Heap, haben wir keinen Max Heap
			if (!isHeap(r))
				return false;
		}

		// if (l != null && r != null)
		// if (l.getValue().compareTo(r.getValue()) > 0)
		// return false;

		return true;
	}

	public boolean isBinarySearchTree(Node node) {
		// Sonderfall Teilaufgabe c
		if (node == null)
			return true;

		Node l = node.getLeftChild();
		Node r = node.getRightChild();

		// Sonderfall Teilaufgabe c
		if (l == null && r == null)
			return true;

		// Wenn links groesser ist, ist es kein Binaerer Suchbaum
		if (l != null) {
			if (l.getValue().compareTo(node.getValue()) >= 0)
				return false;

			// Ist die linke Seite kein Max Heap, haben wir keinen Max Heap
			if (!isBinarySearchTree(l))
				return false;
		}

		// Wenn rechts kleiner ist, ist es kein Binaerer Suchbaum
		if (r != null) {
			if (r.getValue().compareTo(node.getValue()) <= 0)
				return false;

			// Ist die rechte Seite kein Max Heap, haben wir keinen Max Heap
			if (!isBinarySearchTree(r))
				return false;
		}

		if (l != null && r != null)
			if (l.getValue().compareTo(r.getValue()) >= 0)
				return false;

		return true;
	}
}
