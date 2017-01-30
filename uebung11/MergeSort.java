public class MergeSort {

	public void sort(List list) {
		List dontcare = doSort(list, list.size());
	}

	public List doSort(List list, int n) {

		// Basisfall
		if (list.size() > 0) {

			int mid = n / 2;

			// divide
			List otherhalf = div(list, mid);
			list = doSort(list, list.size());
			otherhalf = doSort(otherhalf, otherhalf.size());

			// conquer
			return merge(list, otherhalf);
		}
		return list;
	}

	public static List merge(List left, List right) {
		// TODO

		// Basisfall
		if (right == null)
			return left;
		if (left == null)
			return right;

		Element currentRight = right.first;
		Element currentLeft = left.first;

		if (currentRight.getValue() < currentLeft.getValue()) {
			left.first = new Element(right.first.getValue(), left.first);
			right.first = right.first.next;
			currentLeft = left.first;
		}

		while (currentLeft.next != null) {
			if (right.first != null) {
				if (currentLeft.next.getValue() > right.first.getValue()) {
					currentLeft.next = new Element(right.first.getValue(), currentLeft.next);
					right.first = right.first.next;
				}
			} else
				break;

			currentLeft = currentLeft.next;
		}
		return left;
	}

	// public static void main(String[] args) {
	// // List left = new List(new Element(7, null));
	// // left.first = new Element(4, left.first);
	// // left.first = new Element(2, left.first);
	// //
	// // List right = new List(new Element(6, null));
	// // right.first = new Element(3, right.first);
	//
	// List left = new List(new Element(11, null));
	// left.first = new Element(8, left.first);
	// left.first = new Element(3, left.first);
	//
	// List right = new List(new Element(6, null));
	// right.first = new Element(3, right.first);
	//
	// List merge = merge(left, right);

	// }
	private List div(List list, int i) {

		int temp = 0;
		for (Element elem = list.first; elem != null; elem = elem.next) {
			if (temp == i - 1) {
				List anotherList = new List(elem.next);
				elem.next = null;
				return anotherList;
			}
			temp++;
		}

		return list;
	}
}
