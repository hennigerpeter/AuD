public class List {
	public Element first;

	public List(Element first) {
		this.first = first;
	}

	public int size() {
		if (first == null)
			return 0;

		int size = 0;
		for (Element element = first; element != null; element = element.next) {
			size++;
		}
		return size;
	}
}
