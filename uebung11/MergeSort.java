public class MergeSort {

	public void sort(List list) {
		// TODO
	}

	public List doSort(List list, int n) {
		// TODO
		return null;
	}

	public List merge(List left, List right) {
		// TODO

		// int l =0;
		// Element currentRight = right.first;
		// Element currentLeft = getItem(l, left);
		//
		// while (currentRight != null) { // Reissverschluss
		// currentRight = right.first;
		// currentLeft = getItem(l, left);
		//
		// if (currentLeft.getValue() <= currentRight.getValue() &&
		// currentLeft.next.getValue() > currentRight.getValue()) {
		//
		// Element temp = new Element(currentLeft.getValue(),currentLeft.next);
		// currentLeft.next = currentRight;
		// currentLeft.next.next = temp;
		//
		// Element temp2 = new Element(right.first.next.getValue(),
		// right.first.next.next);
		// right.first = temp2;
		// }
		// }
		//
		// return left;

		
		
	}

	private List mergeSort(List list){
		if (list.size() <= 1)
			return list;
		
		// divide and conquer
		int mitte = list.size()/2;
		List links = mergeSort();
		
	}
	
	private List split(int i, List list){
		
		Element last = new Element(list.first.getValue(), list.first.next);
		
		for (int x = 0; x < i; x++){
			last = last.next;
		}
		
		List temp = new List(new Element(last.getValue(), null));
		
	}
	
	private Element getItem(int i, List list) {
		Element elem = list.first;

		for (int n = 0; n < i; n++) {
			elem = elem.next;
		}

		return elem;
	}

	public static void main(String[] args) {
		List left = new List(new Element(7, null));
		left.first = new Element(4, left.first);
		left.first = new Element(2, left.first);

		List right = new List(new Element(6, null));
		right.first = new Element(3, right.first);

		// List merge = merge(left, right);

	}
}
