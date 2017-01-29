public class QuickSort {

	public static <E> E[] swap(E[] array, int i, int j) {
		// TODO

		E tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;

		return array;
	}

	public static <E extends Comparable<? super E>> int choosePivot(E[] array, int start, int end) {
		// TODO
		int mid = (array.length-1) / 2;

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
		E p = array[pivot];
		int i = start;
		int j = end;

		while (i < end) {
			// {I: ...}
			if (array[j].compareTo(p) <= 0) {
				i++;
				swap(array, i, j);
			}
			j--;
		}
		// {S: ...}
		int r = i + 1;
		swap(array, r, start);
		// {Q: ...}
		return r;
	}

	public static <E extends Comparable<? super E>> void sort(E[] array) {
		// TODO
		
		sortRecursive(array, 0, array.length-1);
	}

	private static <E extends Comparable<? super E>> void sortRecursive(E[] array, int start, int end) {

		// Komplettes Array
		int pivot = choosePivot(array, start, end);
		pivot = partition(array, pivot, start, end);

		// Linke Seite
		sortRecursive(array, 0, pivot-1);
		
		// Rechte Seite
		sortRecursive(array, pivot, end);
		
	}
}
