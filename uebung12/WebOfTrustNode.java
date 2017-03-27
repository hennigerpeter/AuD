import java.util.*;

public class WebOfTrustNode {
	public ArrayList<WebOfTrustNode> trustees;

	/**
	 * Adds a directed edge from <code>this</code> to <code>other</code> to the
	 * graph.
	 */
	public void trusts(WebOfTrustNode whom) {

		if (whom == null)
			return;
		if (!trustees.contains(whom))
			trustees.add(whom);

	}

	/**
	 * Traverses the Graph in Breadth-First order starting from this node until
	 * <code>other</code> is found. Afterwards reconstructs the path to other
	 * and returns it to the caller.
	 */
	public ArrayList<WebOfTrustNode> findTrustPath(WebOfTrustNode other) {

		ArrayList<WebOfTrustNode> path = null;

		// ich kenne den gesuchten knoten selbst
		if (trustees.contains(other)) {
			path = new ArrayList<WebOfTrustNode>();
			path.add(this);
			return path;
		}

		// schauen ob meine freunde den gesuchten knoten kennen
		for (WebOfTrustNode node : trustees) {

			ArrayList<WebOfTrustNode> route = node.findTrustPath(other);
			// node kennt den gesuchten knoten
			if (route != null) {

				path = new ArrayList<WebOfTrustNode>();

				path.add(this);

				for (WebOfTrustNode n : route) {
					path.add(n);
				}

				return path;
			}
		}

		return null;
	}

	/**
	 * Calculates the set of all nodes that can be reached from this node.
	 */
	public HashSet<WebOfTrustNode> calculateReachableSubset() {
		return new HashSet<WebOfTrustNode>();
	}

	/**
	 * Calculates the strong set that contains the current node.
	 */
	public HashSet<WebOfTrustNode> calculateStrongSubset() {
		return new HashSet<WebOfTrustNode>();
	}
}
