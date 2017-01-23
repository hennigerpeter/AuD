public class Element {
	public int value;
	public Element next;

	public Element(int value, Element next) {
		this.value = value;
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
