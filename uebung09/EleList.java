public class EleList<T> {

	private T head;
	private EleList<T> tail;

	// erzeugt eine neue und zunaechst leere Elementare Liste
	public static EleList<?> create() {

		return new EleList<>();

	}

	// fuegt ein neues Element vorne in die Liste ein
	public static <T> EleList<T> add(EleList<T> list, T head) {

		list.tail = list;
		list.head = head;
		return list;

	}

	// gibt das erste (vorderste) Element der Liste zurueck
	public static <T> T head(EleList<T> list) {

		if (list.equals(null) || list.head.equals(null))
			return null;

		return list.head;

	}

	// gibt die Restliste ohne das erste Element zurueck
	public static <T> EleList<T> tail(EleList<T> list) {

		if (list.equals(null) || list.tail.equals(null))
			return null;

		return list.tail;

	}

}