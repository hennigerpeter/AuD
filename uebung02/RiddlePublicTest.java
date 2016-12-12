import static org.junit.Assert.*;
import org.junit.*;

public class RiddlePublicTest {


	@Test(timeout = 666)
	public void testImplies_PUBLIC_TEST() {
		assertTrue("true => true should be 'true'", Riddle.implies(true, true));
	}

	@Test(timeout = 666)
	public void testA0_PUBLIC_TEST() throws Exception {
		assertFalse("A0 should not be satisfied for (false, true, true)", Riddle.a0(false, true, true));
	}

	@Test(timeout = 666)
	public void testA1_PUBLIC_TEST() throws Exception {
		assertFalse("A1 should not be satisfied for (true, false, true)", Riddle.a1(true, false, true));
	}

	@Test(timeout = 666)
	public void testA2_PUBLIC_TEST() throws Exception {
		assertTrue("A2 should be satisfied for (false,false, true)", Riddle.a2(false, false,true));
	}

	@Test(timeout = 666)
	public void testA3_PUBLIC_TEST() throws Exception {
		assertTrue("A3 should be satisfied for (false, false, true)", Riddle.a3(false, false, true));
	}

	@Test(timeout = 666)
	public void testEval_PUBLIC_TEST() throws Exception {
		assertTrue("Eval should be true for (false, true, false)", Riddle.eval(false, true, false));
	}

	@Test(timeout = 666)
	public void testCheckRiddle_PUBLIC_TEST() throws Exception {
		assertEquals("Riddle should return 1 (Cartman)", 1,  Riddle.checkRiddle());
	}

	// ========== main ==========
	// nothing to do ;) - please do nothing here:
	public static void main(String args[]) {
		// to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
		// to run on command line: java -cp .:/usr/share/java/junit4.jar $(ls * | grep PublicTest.class | sed s/.class//)

		// starts junit runner - don't try to understand!
		org.junit.runner.JUnitCore.main(new Object() {
		}.getClass().getEnclosingClass().getSimpleName());
	}
}
