
public class EntklammernKnoten extends EntklammernMischKnoten {

	private EntklammernAbstrakterKnoten kind = null;

	public EntklammernKnoten(EntklammernAbstrakterKnoten kind) {
		this.kind = kind;

	}

	public String toString() {
		return "("+kind.toString()+")";
	}
}
