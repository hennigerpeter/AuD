import org.junit.*;

public class SolverPublicTest {

	@Test(timeout = 1000)
	public void testMain() {
		SolverTest.test0();
		SolverTest.test1();
		SolverTest.test2();
		SolverTest.test3();
		SolverTest.test4();
		SolverTest.test5();
		SolverTest.test6();
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
