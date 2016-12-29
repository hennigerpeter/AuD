import static org.junit.Assert.*;
import org.junit.*;

public class AuD2048LogicPublicTest {

	// ================================================================================

	// ---------- AuD2048LogicNormalGame ----------------------------------------
	@Test(timeout = 666)
	public void test_AuD2048LogicNormalGame_CheckInterface_PUBLIC_MAIN_TEST() {
		AuD2048Logic logic = new AuD2048LogicNormalGame();
		logic.initializeLogic(4, 4);
		logic.startNewGame();
		assertNotNull("AuD2048LogicNormalGame(4,4): New game and game board is null? wtf?", logic.getGameBoard());
		assertEquals("AuD2048LogicNormalGame(4,4): New game and we already have some score? wtf?", 0, logic.getScore());
		assertFalse("AuD2048LogicNormalGame(4,4): New game and game is already over? wtf?", logic.isGameOver());
		assertFalse("AuD2048LogicNormalGame(4,4): New game and we already have a winner? wtf?", logic.hasWinner());
		logic.move(Direction.DOWN);
	}

	// ---------- AuD2048LogicEleven ----------------------------------------
	@Test(timeout = 666)
	public void test_AuD2048LogicEleven_CheckInterface_PUBLIC_MAIN_TEST() {
		AuD2048Logic logic = new AuD2048LogicEleven();
		logic.initializeLogic(4, 4);
		logic.startNewGame();
		assertNotNull("AuD2048LogicEleven(4,4): New game and game board is null? wtf?", logic.getGameBoard());
		assertEquals("AuD2048LogicEleven(4,4): New game and we already have some score? wtf?", 0, logic.getScore());
		assertFalse("AuD2048LogicEleven(4,4): New game and game is already over? wtf?", logic.isGameOver());
		assertFalse("AuD2048LogicEleven(4,4): New game and we already have a winner? wtf?", logic.hasWinner());
		logic.move(Direction.DOWN);
	}

	// ---------- AuD2048LogicFibonacci ----------------------------------------
	@Test(timeout = 666)
	public void test_AuD2048LogicFibonacci_CheckInterface_PUBLIC_MAIN_TEST() {
		AuD2048Logic logic = new AuD2048LogicFibonacci();
		logic.initializeLogic(4, 4);
		logic.startNewGame();
		assertNotNull("AuD2048LogicFibonacci(4,4): New game and game board is null? wtf?", logic.getGameBoard());
		assertEquals("AuD2048LogicFibonacci(4,4): New game and we already have some score? wtf?", 0, logic.getScore());
		assertFalse("AuD2048LogicFibonacci(4,4): New game and game is already over? wtf?", logic.isGameOver());
		assertFalse("AuD2048LogicFibonacci(4,4): New game and we already have a winner? wtf?", logic.hasWinner());
		logic.move(Direction.DOWN);
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