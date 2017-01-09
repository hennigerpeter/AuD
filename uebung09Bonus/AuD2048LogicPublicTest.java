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

	
	
	/* Eigene Test */
	// ---------- AuD2048LogicNormalGame ----------------------------------------
		@Test(timeout = 666)
		public void test_AuD2048LogicNormalGame_CheckMovementRIGHT_PUBLIC_MAIN_TEST() {
			AuD2048Logic logic = new AuD2048LogicNormalGame();
			logic.initializeLogic(4, 4);
			
			logic.gameBoard = new long[][]{{4,0,0,0},{8,2,0,0},{2,0,0,0},{2,2,0,0}};
			long[][] gameBoardFinal = new long[][]{{0,0,0,4},{0,0,8,2},{0,0,0,2},{0,0,0,4}};
			logic.move(Direction.RIGHT);
			
			assertEquals("Die Rechtsbewegung hat nicht das erwuenschte Ergebnis", gameBoardFinal, logic.gameBoard);
			
		}
		
	// ---------- AuD2048LogicNormalGame ----------------------------------------
		@Test(timeout = 666)
		public void test_AuD2048LogicNormalGame_CheckMovementLEFT_PUBLIC_MAIN_TEST() {
			AuD2048Logic logic = new AuD2048LogicNormalGame();
			logic.initializeLogic(4, 4);
			
			logic.gameBoard = new long[][]{{0,0,0,4},{0,0,8,2},{0,0,0,2},{0,0,2,2}};
			long[][] gameBoardFinal = new long[][]{{4,0,0,0},{8,2,0,0},{2,0,0,0},{4,0,0,0}};
			logic.move(Direction.LEFT);
			
			assertEquals("Die Rechtsbewegung hat nicht das erwuenschte Ergebnis", gameBoardFinal, logic.gameBoard);
				
		}

		// ---------- AuD2048LogicNormalGame ----------------------------------------
		@Test(timeout = 666)
		public void test_AuD2048LogicNormalGame_CheckMovementUP_PUBLIC_MAIN_TEST() {
			AuD2048Logic logic = new AuD2048LogicNormalGame();
			logic.initializeLogic(4, 4);
			
			logic.gameBoard = new long[][]{{0,0,0,0},{0,0,0,4},{0,0,8,2},{0,0,2,4}};
			long[][] gameBoardFinal = new long[][]{{0,0,8,4},{0,0,2,2},{0,0,0,4},{0,0,0,0}};
			logic.move(Direction.UP);
			
			assertEquals("Die Rechtsbewegung hat nicht das erwuenschte Ergebnis", gameBoardFinal, logic.gameBoard);
				
		}

		// ---------- AuD2048LogicNormalGame ----------------------------------------
		@Test(timeout = 666)
		public void test_AuD2048LogicNormalGame_CheckMovementDOWN_PUBLIC_MAIN_TEST() {
			AuD2048Logic logic = new AuD2048LogicNormalGame();
			logic.initializeLogic(4, 4);
			
			logic.gameBoard = new long[][]{{0,0,0,4},{0,0,8,2},{0,0,0,2},{0,0,2,2}};
			long[][] gameBoardFinal = new long[][]{{0,0,0,0},{0,0,0,4},{0,0,8,2},{0,0,2,4}};
			logic.move(Direction.DOWN);
			
			assertEquals("Die Rechtsbewegung hat nicht das erwuenschte Ergebnis", gameBoardFinal, logic.gameBoard);
				
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