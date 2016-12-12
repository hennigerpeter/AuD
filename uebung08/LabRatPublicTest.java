import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;


public class LabRatPublicTest {
	
	private Point startPosition = new Point(9, 9);
	private Point endPosition = new Point(7, 9);

	private boolean[][] walls = new boolean[][] {
			new boolean[] { true, true, true, true, true, true, true, true, true, true, true, true, true },
			new boolean[] { true, false, false, false, false, false, false, false, true, false, false, false, true },
			new boolean[] { true, false, true, true, true, true, true, false, true, false, true, false, true },
			new boolean[] { true, false, false, false, false, false, true, false, false, false, true, false, true },
			new boolean[] { true, true, true, true, true, false, true, true, true, true, true, false, true },
			new boolean[] { true, false, false, false, true, false, false, false, true, false, false, false, true },
			new boolean[] { true, false, true, false, true, true, true, false, true, false, true, true, true },
			new boolean[] { true, false, true, false, false, false, true, false, true, false, false, false, true },
			new boolean[] { true, false, true, true, true, false, true, false, true, true, true, false, true },
			new boolean[] { true, false, true, false, false, false, true, false, true, false, true, false, true },
			new boolean[] { true, false, true, true, true, true, true, true, true, false, true, false, true },
			new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, true },
			new boolean[] { true, true, true, true, true, true, true, true, true, true, true, true, true }, };

	// ========== LabRat - A ===========

	@Test(timeout = 1000)
	public void testTurnLeft() {
		Lab lab = new Lab(startPosition, endPosition, walls);
		LabRat labRat = new LabRat(lab);
		labRat.turnLeft();
		assertEquals("turnLeft()", LabRat.WEST, labRat.getCurrentDirection());
	}

	@Test(timeout = 1000)
	public void testTurnRight() {
		Lab lab = new Lab(startPosition, endPosition, walls);
		LabRat labRat = new LabRat(lab);
		labRat.turnRight();
		assertEquals("turnLeft()", LabRat.EAST, labRat.getCurrentDirection());
	}

	@Test(timeout = 1000)
	public void testgetCurrentPosition() {
		Lab lab = new Lab(startPosition, endPosition, walls);
		LabRat labRat = new LabRat(lab);
		labRat.turnRight();
		labRat.stepForward();
		assertEquals("getCurrentPosition()", new Point(10, 9), labRat.getCurrentPosition());
	}

	@Test(timeout = 1000)
	public void testFacingWall1() {
		Lab lab = new Lab(startPosition, endPosition, walls);
		LabRat labRat = new LabRat(lab);
		assertEquals("getCurrentPosition()", true, labRat.facingWall());
	}

	@Test(timeout = 1000)
	public void testFacingWall2() {
		Lab lab = new Lab(startPosition, endPosition, walls);
		LabRat labRat = new LabRat(lab);
		labRat.turnRight();
		assertEquals("getCurrentPosition()", false, labRat.facingWall());
	}

	@Test(timeout = 1000)
	public void testIsAtStartingPosition1() {
		Lab lab = new Lab(startPosition, endPosition, walls);
		LabRat labRat = new LabRat(lab);
		assertEquals("getCurrentPosition()", true, labRat.isAtStartPosition());
	}

	@Test(timeout = 1000)
	public void testIsAtStartingPosition2() {
		Lab lab = new Lab(startPosition, endPosition, walls);
		LabRat labRat = new LabRat(lab);
		labRat.turnRight();
		labRat.stepForward();
		assertEquals("getCurrentPosition()", false, labRat.isAtStartPosition());
	}

	@Test(timeout = 1000)
	public void testIsAtTheExit1() {
		Lab lab = new Lab(startPosition, endPosition, walls);
		LabRat labRat = new LabRat(lab);
		assertEquals("getCurrentPosition()", false, labRat.isAtEndPosition());
	}

	@Test(timeout = 1000)
	public void testIsAtTheExit2() {
		Lab lab = new Lab(startPosition, startPosition, walls);
		LabRat labRat = new LabRat(lab);
		assertEquals("getCurrentPosition()", true, labRat.isAtEndPosition());
	}

	@Test(timeout = 1000)
	public void testGetStartPosition() {
		Lab maze = new Lab(startPosition, endPosition, walls);
		assertEquals("getStartPosition()", startPosition, maze.getStartPosition());
	}

	@Test(timeout = 1000)
	public void testCheckWall1() {
		Lab maze = new Lab(startPosition, endPosition, walls);
		for (int y = 2; y < 9; y++)
			for (int x = 2; x < 9; x++)
				assertEquals("checkWall()", walls[x][y], maze.checkWall(x, y));
	}

	@Test(timeout = 1000)
	public void testCheckWall2() {
		Lab maze = new Lab(startPosition, endPosition, walls);
		for (int y = 2; y < 9; y++)
			for (int x = 2; x < 9; x++)
				assertEquals("checkWall()", walls[x][y], maze.checkWall(new Point(x, y)));
	}

	// ========== LabRat - B ===========

	@Test(timeout = 1000)
	public void testSolve1() {
		Lab maze = new Lab(startPosition, endPosition, walls);
		LabRat mouse = new LabRat(maze);
		assertEquals("getStartPosition()", endPosition, LabRatSolver.solve(mouse));
	}

	@Test(timeout = 1000)
	public void testSolve2() {
		Lab maze = new Lab(startPosition, endPosition, walls);
		LabRat mouse = new LabRat(maze);
		assertEquals("getStartPosition()", endPosition, LabRatSolver.solve(mouse));
	}

	// ========== LabRat - C ===========

	@Test(timeout = 1000)
	public void testSolveShortestPath1() {
		Point startPosition = new Point(3, 9);
		Point endPosition = new Point(7, 9);
		Lab maze = new Lab(startPosition, endPosition, walls);
		LabRat mouse = new LabRat(maze);
		
		final List<String> stackTrace = new ArrayList<>();
		int shortestPath = LabRatSolver.solveShortestPath(mouse, 0, new LabRatSolver() {
			@Override
			public void check() {
				stackTrace.clear();
				for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
					stackTrace.add(ste.getMethodName());
				}
			}
		});
		
		assertTrue("check recursion", Collections.frequency(stackTrace, "solveShortestPath") > 1);
		assertEquals("solveShortestPath()", 12, shortestPath);
	}

	@Test(timeout = 1000)
	public void testSolveShortestPath2() {
		Point startPosition = new Point(1, 1);
		Point endPosition = new Point(9, 9);
		Lab maze = new Lab(startPosition, endPosition, walls);
		LabRat mouse = new LabRat(maze);
		
		final List<String> stackTrace = new ArrayList<>();
		int shortestPath = LabRatSolver.solveShortestPath(mouse, 0, new LabRatSolver() {
			@Override
			public void check() {
				stackTrace.clear();
				for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
					stackTrace.add(ste.getMethodName());
				}
			}
		});
		
		assertTrue("check recursion", Collections.frequency(stackTrace, "solveShortestPath") > 1);
		assertEquals("solveShortestPath()", 32, shortestPath);
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
