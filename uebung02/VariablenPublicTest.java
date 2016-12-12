import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.*;

public class VariablenPublicTest {

	@Test(timeout = 666)
	public void testSomeCharacters_PUBLIC_TEST() {
		assertEquals("Character at position 3 is wrong", 'D', Variablen.someCharacters()[3]);
	}

	@Test(timeout = 666)
	public void testSomeMoreCharacters_PUBLIC_TEST() {
		assertEquals("Character at position [0][1] is wrong", 1, Variablen.someMoreCharacters()[0][1]);
		assertEquals("Character at position [1][1] is wrong", 66, Variablen.someMoreCharacters()[1][1]);
		assertEquals("Character at position [2][1] is wrong", 0x31, Variablen.someMoreCharacters()[2][1]);
		assertEquals("Character at position [3][1] is wrong", 0142, Variablen.someMoreCharacters()[3][1]);
	}

	@Test(timeout = 666)
	public void testTheCube_PUBLIC_TEST() {
		assertEquals("Cubevalue at position [2][1][0] is wrong", 321, Variablen.theCube()[2][1][0]);
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
