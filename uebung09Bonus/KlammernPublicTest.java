import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class KlammernPublicTest {

	/** ######################################################################################################################## **/

	// ========== example from exercise ==========
	@Test(timeout = 666)
	public void pubTest_Parenthesize_exampleFromEx() {
		List<String> expected = Arrays.asList("ab", "(a)b", "((a)(b))", "a(b)", "(ab)", "(a)(b)", "((a)b)", "(a(b))");
		List<String> actual = Klammern.klammern("ab");
		assertEquals("Wrong number of elements.", expected.size(), actual.size());
		for (String s : expected) {
			assertTrue("Expected but not found in solution: " + s, actual.contains(s));
		}
		for (String s : actual) {
			assertTrue("Found in solution but not expected: " + s, expected.contains(s));
		}
	}

	/** ######################################################################################################################## **/

	// ========== UML2Java ==========
	@Test(timeout = 666)
	public void pubTest_ParseParentheses_UMLinterface_ParParLeaf() {
		EntklammernAbstrakterKnoten blatt = new EntklammernBlatt("AuD");
		assertNull(blatt.kinder());
		assertEquals("AuD", blatt.toString());
	}

	@Test(timeout = 666)
	public void pubTest_ParseParentheses_UMLinterface_ParParParNode() {
		EntklammernAbstrakterKnoten blatt = new EntklammernBlatt("AuD");
		EntklammernAbstrakterKnoten knoten = new EntklammernKnoten(blatt);
		assertNotNull(knoten.kinder());
		assertEquals(1, knoten.kinder().size());
		assertSame(blatt, knoten.kinder().get(0));
		assertEquals("(AuD)", knoten.toString());
	}

	@Test(timeout = 666)
	public void pubTest_ParseParentheses_UMLinterface_ParParMixedNode() {
		EntklammernAbstrakterKnoten blattLinks = new EntklammernBlatt("AuD");
		EntklammernAbstrakterKnoten knotenLinks = new EntklammernKnoten(blattLinks);
		EntklammernAbstrakterKnoten blattRechts = new EntklammernBlatt("PFP");
		List<EntklammernAbstrakterKnoten> kinder = new LinkedList<>();
		kinder.add(knotenLinks);
		kinder.add(blattRechts);
		EntklammernAbstrakterKnoten knoten = new EntklammernMischKnoten(kinder);
		assertNotNull(knoten.kinder());
		assertEquals(2, knoten.kinder().size());
		assertEquals("(AuD)PFP", knoten.toString());
	}

	// ========== simple string ==========
	@Test(timeout = 666)
	public void pubTest_ParseParentheses_simpleString() {
		EntklammernAbstrakterKnoten actual = Entklammern.entklammern("AuD");
		assertNotNull(actual);
		assertNull(actual.kinder());
		assertSame(EntklammernBlatt.class, actual.getClass());
		assertEquals("AuD", actual.toString());
	}

	// ========== double par ==========
	@Test(timeout = 666)
	public void pubTest_ParseParentheses_doublePar() {
		EntklammernAbstrakterKnoten actual = Entklammern.entklammern("(AuD)(PFP)");
		assertNotNull(actual);
		assertSame(EntklammernMischKnoten.class, actual.getClass());
		assertNotNull(actual.kinder());
		assertEquals(2, actual.kinder().size());
		for (EntklammernAbstrakterKnoten kind : actual.kinder()) {
			assertNotNull(kind);
			assertSame(EntklammernKnoten.class, kind.getClass());
			assertNotNull(kind.kinder());
			assertEquals(1, kind.kinder().size());
			assertTrue("(AuD)".equals(kind.toString()) || "(PFP)".equals(kind.toString()));
			for (EntklammernAbstrakterKnoten enkel : kind.kinder()) {
				assertNotNull(enkel);
				assertNull(enkel.kinder());
				assertSame(EntklammernBlatt.class, enkel.getClass());
				assertTrue("AuD".equals(enkel.toString()) || "PFP".equals(enkel.toString()));
			}
		}
		assertEquals("(AuD)(PFP)", actual.toString());
	}

	// ==================== main ====================
	// nothing to do ;) - please do nothing here:
	public static void main(String args[]) {
		// to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
		// to run on command line: java -cp .:/usr/share/java/junit4.jar $(ls * | grep PublicTest.class | sed s/.class//)

		// starts junit runner - don't try to understand!
		org.junit.runner.JUnitCore.main(new Object() {
		}.getClass().getEnclosingClass().getSimpleName());
	}
}