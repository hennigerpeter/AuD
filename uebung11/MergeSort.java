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

		Element currentRight = new Element(right.first.getValue(), right.first.next);
		Element currentLeft = new Element(left.first.getValue(), left.first.next);

		while (currentRight.next != null) { // Reissverschluss

			if (currentLeft.getValue() <= currentRight.getValue()
					&& currentLeft.next.getValue() > currentRight.getValue()) {

				// Linke Liste verlaengern
				Element temp = new Element(currentLeft.next.getValue(), currentLeft.next.next);
				currentLeft.next = currentRight;
				currentRight.next = temp;

				// Rechte Liste verkuerzen
				 Element temp2 = new Element(right.first.getValue(),
				 right.first.next);
				 right.first = new Element(right.first.next.getValue(),null);
			}

			// naechste Elemente
			currentLeft = new Element(currentLeft.next.getValue(), currentLeft.next.next);
			if (currentRight.next != null)
				currentRight = new Element(currentRight.next.getValue(), currentRight.next.next);
			else
				currentRight = new Element(currentRight.next.getValue(), null);
		}

		return left;
	}

	public static void main(String[] args) {
//		List left = new List(new Element(7, null));
//		left.first = new Element(4, left.first);
//		left.first = new Element(2, left.first);
//
//		List right = new List(new Element(6, null));
//		right.first = new Element(3, right.first);

		List left = new List(new Element(11, null));
		left.first = new Element(8, left.first);
		left.first = new Element(3, left.first);

		List right = new List(new Element(6, null));
		right.first = new Element(3, right.first);
		
		
		List merge = merge(left, right);

	}
}
