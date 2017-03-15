import java.util.*;

public class WebOfTrustNode {
	public ArrayList<WebOfTrustNode> trustees;

	/**
	 * Adds a directed edge from <code>this</code> to
	 * <code>other</code> to the graph.
	 */
	public void trusts(WebOfTrustNode whom) {

	}

	/**
	 * Traverses the Graph in Breadth-First order starting from this
	 * node until <code>other</code> is found. Afterwards reconstructs
	 * the path to other and returns it to the caller.
	 */
	public ArrayList<WebOfTrustNode> findTrustPath(WebOfTrustNode other) {
		return new ArrayList<WebOfTrustNode>();
	}

	/**
	 * Calculates the set of all nodes that can be reached from this
	 * node.
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
