
public class EntklammernKnoten extends EntklammernMischKnoten {

	private EntklammernAbstrakterKnoten kind = null;

	public EntklammernKnoten(EntklammernAbstrakterKnoten kind) {
		this.kind = kind;
		super.add(kind);

	}

	public String toString() {
		return "("+kind.toString()+")";
	}
}
