public class QuickSort {

	public static <E> E[] swap(E[] array, int i, int j) {
		// TODO

		E e1 = array[i];
		E e2 = array[j];

		array[i] = e2;
		array[j] = e1;

		return array;
	}

	public static <E extends Comparable<? super E>> int choosePivot(E[] array, int start, int end) {
		// TODO
		int mid = array.length / 2;

		if (array.length % 2 != 0)
			mid -= 1;

		// start ist == mitte oder == end -> start hat kleinesten index
		if (array[start].compareTo(array[mid]) == 0 || array[start].compareTo(array[end]) == 0)
			return start;

		if (array[mid].compareTo(array[end]) == 0)
			return mid;

		// start liegt zwischen mid und end
		if (array[start].compareTo(array[mid]) < 0 && array[start].compareTo(array[end]) > 0)
			return start;

		if (array[start].compareTo(array[end]) < 0 && array[start].compareTo(array[mid]) > 0)
			return start;

		// mid liegt zwischen start und end
		else if (array[mid].compareTo(array[start]) < 0 && array[mid].compareTo(array[end]) > 0)
			return mid;

		else if (array[mid].compareTo(array[end]) < 0 && array[mid].compareTo(array[start]) > 0)
			return mid;

		return end;
	}

	public static <E extends Comparable<? super E>> int partition(E[] array, int pivot, int start, int end) {
		// TODO!
		return -1;
	}

	public static <E extends Comparable<? super E>> void sort(E[] array) {
		// TODO
	}
}
