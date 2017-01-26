public class MergeSort {

	public void sort(List list) {
		// TODO
	}

	public List doSort(List list, int n) {
		// TODO
		return null;
	}

	public static List merge(List left, List right) {
		// TODO
		if (left == null)
			return new List(null);

		if (right == null)
			return left;

		Element currentL = left.first;
		Element nextL = currentL.next;
		Element r1 = right.first;

		while (r1 != null) {
			while (currentL.getValue() > r1.getValue() && nextL != null) {

				currentL = nextL;
				nextL = currentL.next;
			}

			// Reissverschluss
			currentL.next = r1;
			currentL.next.next = nextL;

			r1 = r1.next;
		}
		// Right List doesnt get smaller -> stack overflow

		return left;
	}

	public static void main(String[] args) {
		List left = new List(new Element(7, null));
		left.first = new Element(4, left.first);
		left.first = new Element(2, left.first);

		List right = new List(new Element(6, null));
		right.first = new Element(3, right.first);

		List merge = merge(left, right);

	}
}
