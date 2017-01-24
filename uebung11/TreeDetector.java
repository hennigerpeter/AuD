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

		int leftint = -1;
		int rightint = -1;

		if (l != null)
			leftint = l.getValue();

		if (r != null)
			rightint = r.getValue();

		if (checkValues(node, leftint, rightint) == false)
			return false;

		// Pruefung auf linker Seite fortsetzen
		if (l != null)
			if (!isBinarySearchTree(l))
				return false;

		// Pruefung auf rechter Seite fortsetzen
		if (r != null)
			if (!isBinarySearchTree(r))
				return false;

		return true;
	}

	private boolean checkValues(Node node, int l, int r) {

		int n = node.getValue();

		if (l != -1) {
			// Wenn links groesser ist, ist es kein Binaerer Suchbaum
			if (l >= n)
				return false;
		}
		if (r != -1) {
			// Wenn rechts kleiner ist, ist es kein Binaerer Suchbaum
			if (r <= n)
				return false;
		}
		if (l != -1 && r != -1)
			if (l >= r)
				return false;

		return true;
	}
}
