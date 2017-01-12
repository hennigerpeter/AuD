
public class EntklammernKnoten extends EntklammernMischKnoten {

	private EntklammernAbstrakterKnoten kind = null;

	public EntklammernKnoten(EntklammernAbstrakterKnoten kind) {
		this.kind = kind;
		// if (kind.getClass() != EntklammernBlatt.class)
		super.add(kind);

	}

	public String toString() {
		return "(" + kind.toString() + ")";
	}
}
