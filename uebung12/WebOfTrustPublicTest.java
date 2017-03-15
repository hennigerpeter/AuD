import static org.junit.Assert.*;
import org.junit.*;
import java.util.HashSet;

public class WebOfTrustPublicTest {

	@Test(timeout=100)
	public void pubTest_simpleAddEdge() {
		WebOfTrustNode alice = new WebOfTrustNode();
		WebOfTrustNode bob   = new WebOfTrustNode();
		WebOfTrustNode carol = new WebOfTrustNode();
		WebOfTrustNode dave  = new WebOfTrustNode();

		alice.trusts(bob);
		alice.trusts(carol);
		alice.trusts(dave);

		HashSet<WebOfTrustNode> children = new HashSet<WebOfTrustNode>();
		children.addAll(alice.trustees);
		assertEquals(3, children.size());
		assertTrue(children.contains(bob));
		assertTrue(children.contains(carol));
		assertTrue(children.contains(dave));
	}

	@Test(timeout=100)
	public void pubTest_simplePathFound() {
		WebOfTrustNode alice = new WebOfTrustNode();
		WebOfTrustNode bob   = new WebOfTrustNode();
		WebOfTrustNode carol = new WebOfTrustNode();
		WebOfTrustNode dave  = new WebOfTrustNode();

		alice.trusts(bob);
		bob.trusts(carol);
		carol.trusts(dave);

		assertEquals(4, alice.findTrustPath(dave).size());
	}

	@Test(timeout=100)
	public void pubTest_simplePathFoundWithCycles() {
		WebOfTrustNode alice = new WebOfTrustNode();
		WebOfTrustNode bob   = new WebOfTrustNode();
		WebOfTrustNode carol = new WebOfTrustNode();
		WebOfTrustNode dave  = new WebOfTrustNode();

		alice.trusts(bob);
		bob.trusts(carol);
		carol.trusts(bob);
		carol.trusts(dave);

		assertEquals(4, alice.findTrustPath(dave).size());
	}
	
	@Test(timeout=100)
	public void pubTest_noPathFoundisNull() {
		WebOfTrustNode alice = new WebOfTrustNode();
		WebOfTrustNode bob   = new WebOfTrustNode();
		WebOfTrustNode carol = new WebOfTrustNode();
		WebOfTrustNode dave  = new WebOfTrustNode();

		alice.trusts(bob);
		bob.trusts(carol);
		carol.trusts(dave);

		WebOfTrustNode eve = new WebOfTrustNode();
		assertNull(alice.findTrustPath(eve));
	}

	@Test(timeout=100)
	public void pubTest_reachableSet() {
		WebOfTrustNode alice = new WebOfTrustNode();
		WebOfTrustNode bob   = new WebOfTrustNode();
		WebOfTrustNode carol = new WebOfTrustNode();
		WebOfTrustNode dave  = new WebOfTrustNode();

		alice.trusts(bob);
		bob.trusts(carol);
		carol.trusts(dave);

		WebOfTrustNode eve = new WebOfTrustNode();

		HashSet<WebOfTrustNode> result = alice.calculateReachableSubset();
		assertEquals(4, result.size());
		assertTrue(result.contains(alice));
		assertTrue(result.contains(bob));
		assertTrue(result.contains(carol));
		assertTrue(result.contains(dave));
		assertFalse(result.contains(eve));
	}

	@Test(timeout=100)
	public void pubTest_trivialReachableSet() {
		WebOfTrustNode alice = new WebOfTrustNode();
		HashSet<WebOfTrustNode> result = alice.calculateReachableSubset();
		assertEquals(1, result.size());
		assertTrue(result.contains(alice));
	}

	@Test(timeout=100)
	public void pubTest_reachableCyclicSet() {
		WebOfTrustNode alice = new WebOfTrustNode();
		WebOfTrustNode bob   = new WebOfTrustNode();
		WebOfTrustNode carol = new WebOfTrustNode();
		WebOfTrustNode dave  = new WebOfTrustNode();

		alice.trusts(bob);
		bob.trusts(alice);
		bob.trusts(carol);
		carol.trusts(dave);

		WebOfTrustNode eve = new WebOfTrustNode();

		HashSet<WebOfTrustNode> result = alice.calculateReachableSubset();
		assertEquals(4, result.size());
		assertTrue(result.contains(alice));
		assertTrue(result.contains(bob));
		assertTrue(result.contains(carol));
		assertTrue(result.contains(dave));
		assertFalse(result.contains(eve));
	}

	
	@Test(timeout=100)
	public void pubTest_strongSet() {
		WebOfTrustNode alice = new WebOfTrustNode();
		WebOfTrustNode bob   = new WebOfTrustNode();
		WebOfTrustNode carol = new WebOfTrustNode();
		WebOfTrustNode dave  = new WebOfTrustNode();

		alice.trusts(bob);
		bob.trusts(alice);
		bob.trusts(carol);
		carol.trusts(dave);

		WebOfTrustNode eve = new WebOfTrustNode();

		HashSet<WebOfTrustNode> result = alice.calculateStrongSubset();
		assertEquals(2, result.size());
		assertTrue(result.contains(alice));
		assertTrue(result.contains(bob));
		assertFalse(result.contains(carol));
		assertFalse(result.contains(dave));
		assertFalse(result.contains(eve));
	}

	@Test(timeout=100)
	public void pubTest_trivialStrongSet() {
		WebOfTrustNode alice = new WebOfTrustNode();

		HashSet<WebOfTrustNode> result = alice.calculateStrongSubset();
		assertEquals(1, result.size());
		assertTrue(result.contains(alice));
	}
   	
	// ========== main ==========
	public static void main(String args[]) {
		// to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
		// to run on command line: java -cp .:/usr/share/java/junit4.jar WebOfTrustPublicTest

		// starts junit runner - don't try to understand!
		org.junit.runner.JUnitCore.main(new Object() {
		}.getClass().getEnclosingClass().getSimpleName());
	}
}
