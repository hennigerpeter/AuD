
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
		int mid = (array.length - 1) / 2;

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

		E p = array[pivot];
		int l = start - 1;
		int r = end + 1;

		// Von Links und Rechts vergleichen, bis wir uns in der Mitte treffen
		while (l < r) {
			// Von Links nach Rechts
			for (l++; array[l].compareTo(p) < 0; l++)
				;
			// Von Rechts nach Links
			for (r--; array[r].compareTo(p) > 0; r--)
				;
			// Haben wir zwei Kandidaten zum Tauschen gefunden
			if (l < r)
				swap(array, l, r);
		}
		return r;
	}

	public static <E extends Comparable<? super E>> void sort(E[] array) {

		// Leere oder zu kleine Arrays werden abgefangen
		if (array != null && array.length > 0)
			sortRecursive(array, 0, array.length - 1);
	}

	private static <E extends Comparable<? super E>> void sortRecursive(E[] array, int start, int end) {

		// Basisfall
		if (start < end) {
			// Komplettes Array
			int pivot = choosePivot(array, start, end);
			pivot = partition(array, pivot, start, end);

			// Linke Seite
			sortRecursive(array, start, pivot - 1);

			// Rechte Seite
			sortRecursive(array, pivot + 1, end);
		}
	}
}
