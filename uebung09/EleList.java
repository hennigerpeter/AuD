public class EleList<T> {

	private T head;
	private EleList<T> tail;

	// erzeugt eine neue und zunaechst leere Elementare Liste
	public static EleList<?> create() {

		return new EleList<>();

	}

	// fuegt ein neues Element vorne in die Liste ein
	public static <T> EleList<T> add(EleList<T> list, T head) {

		EleList<T> list2 = new EleList<T>();
		list2.head = head;
		list2.tail = list;

		return list2;

	}

	// gibt das erste (vorderste) Element der Liste zurueck
	public static <T> T head(EleList<T> list) {

		if (list == null || list.head == null)
			return null;

		return list.head;

	}

	// gibt die Restliste ohne das erste Element zurueck
	public static <T> EleList<T> tail(EleList<T> list) {

		if (list == null || list.tail == null)
			return null;

		return list.tail;

	}

}