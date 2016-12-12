import static org.junit.Assert.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import org.junit.*;

public class GameOfDicePublicTest {

	@Test(timeout = 666)
	public void pubTest() {
		assertEquals("Player 1 should win this", 1, GameOfDice.game(new String[]{"4", "6", "1", "3"}));
		assertEquals("Player 2 should win this", 2, GameOfDice.game(new String[]{"2", "6", "5", "4"}));
		assertEquals("Should be a draw", 0, GameOfDice.game(new String[]{"3", "5", "4", "4"}));
	}

	@Test(timeout = 666)
	public void pubTest2() {
		assertEquals("Game Error", -1, GameOfDice.game(new String[]{"6", "1", "3"}));
		assertEquals("Game Error", -1, GameOfDice.game(new String[]{"1", "2", "6", "5", "4"}));
		//assertEquals("Game Error", -1, GameOfDice.game(new String[]{"1", "5", "4", "4"}));
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
