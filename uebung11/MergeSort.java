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

		while (right.first != null) { // Reissverschluss
			Element l = left.first;
			Element r = right.first;

			if (l.getValue() <= r.getValue() && l.next.getValue() > r.getValue()) {

				Element temp = l.next;
				l.next = r;
				r.next = temp;

				Element temp2 = right.first.next;
				right.first = temp2;
			}
		}
		
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
