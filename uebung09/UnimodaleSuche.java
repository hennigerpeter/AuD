import java.util.Comparator;

public abstract class UnimodaleSuche<T extends Comparable<T>> implements UnimodaleListe<T> {

	public static <T> T suche(UnimodaleListe<T> ulldComparator, int von, int bis, Comparator<T> cldc) {
		if (ulldComparator == null)
			return null;

		// Basisfall = Feld gefunden
		if (cldc.compare(ulldComparator.hole(von), ulldComparator.hole(bis)) == 0)
			return ulldComparator.hole(von);

		int half = (von + bis) / 2;
		int comparisonVH = cldc.compare(ulldComparator.hole(von), ulldComparator.hole(half));

		// VON < HALF: Suche in der zweiten haelfte
		if (comparisonVH < 0)
			return suche(ulldComparator, half, bis, cldc);
		// VON > HALF: Suche in der ersten haelfte
		else // if (comparisonVH > 0)
			return suche(ulldComparator, von, half, cldc);

	}

	public static <T> T suche(UnimodaleListe<T> ulldComparable, int von, int bis) {
		if (ulldComparable == null)
			return null;

		if (ulldComparable.hole(von).equals(ulldComparable.hole(bis)))
			return ulldComparable.hole(von);

		return null;
	}

}