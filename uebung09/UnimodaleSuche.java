import java.util.Comparator;

public abstract class UnimodaleSuche<T extends Comparable<T>> {

	public static <T> T suche(UnimodaleListe<T> ulldComparator, int von, int bis, Comparator<T> cldc) {
		if (ulldComparator == null || von < 0 || bis < 0 || von > bis)
			return null;
		else {
			// Basisfall = Feld gefunden
			if (bis == von)
				return ulldComparator.hole(von);
			else {
				// Fuer den Fall dass durch die Rundung die falsche Seite
				// betrachtet
				// wird, muss beidseitig geprueft werden
								
				T halfAndOne = ulldComparator.hole((von+bis)/2+1);
				T half = ulldComparator.hole((von+bis)/2);

				int comparisonVH = cldc.compare(half, halfAndOne);

				// Fall 1: Beide Felder identisch
				if (comparisonVH == 0)
					return half;
				else {
					// VON < HALF: Suche in der zweiten haelfte
					if (comparisonVH < 0) {
						if (bis != von + 1)
							return suche(ulldComparator, (von+bis)/2+1, bis, cldc);
						else
							return halfAndOne;
					}
					// VON > HALF: Suche in der ersten haelfte
					else {// if (comparisonVH > 0)
						if (bis != von + 1)
							return suche(ulldComparator, von, (von+bis)/2, cldc);
						else
							return half;
					}
				}
			}
		}
	}

	public static <T extends Comparable<T>> T suche(UnimodaleListe<T> ulldComparable, int von, int bis) {
		if (ulldComparable == null || von < 0 || bis < 0 || von > bis)
			return null;
		else {
			if (bis == von)
				return ulldComparable.hole(von);
			else {
				T halfAndOne = ulldComparable.hole((bis+von)/2+1); 
				T half = ulldComparable.hole((bis+von)/2);
				
				if (half.compareTo(halfAndOne) == 0) 
					return half; 
			 	else if (half.compareTo(halfAndOne) < 0)
				{ 
					if (bis != von + 1) 
						return suche(ulldComparable, (von+bis)/2+1, bis); else return halfAndOne; 
				} else if (bis != von + 1) 
					return suche(ulldComparable, von, (von+bis)/2); else return half; 
				
			}
		}
		
	}

}