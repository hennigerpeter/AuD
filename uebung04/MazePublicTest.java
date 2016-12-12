import static org.junit.Assert.*;
import org.junit.*;

public class MazePublicTest {

	public static boolean[][][] simpleMaze() {
		boolean[][][] l = new boolean[3][3][4];
		l[0][0][Maze.WEST] = true; // entry
		l[2][2][Maze.EAST] = true; // exit
		l[0][1][Maze.EAST] = l[0][2][Maze.WEST] = true;
		l[0][0][Maze.SOUTH] = l[1][0][Maze.NORTH] = true;
		l[0][1][Maze.SOUTH] = l[1][1][Maze.NORTH] = true;
		l[1][0][Maze.EAST] = l[1][1][Maze.WEST] = true;
		l[1][1][Maze.EAST] = l[1][2][Maze.WEST] = true;
		l[1][1][Maze.SOUTH] = l[2][1][Maze.NORTH] = true;
		l[1][2][Maze.SOUTH] = l[2][2][Maze.NORTH] = true;
		l[2][0][Maze.EAST] = l[2][1][Maze.WEST] = true;
		return l;
	}

	@Test(timeout = 1000)
	public void testIsDeadEnd__small_labyrinth__this_field_always_gives_true() {
		Maze maze = new Maze(simpleMaze());
		assertTrue(maze.isDeadEnd(0, 2));
	}

	@Test(timeout = 1000)
	public void testIsDeadEnd__small_labyrinth__this_field_always_gives_false() {
		Maze maze = new Maze(simpleMaze());
		assertFalse(maze.isDeadEnd(1, 1));
	}
	

	@Test(timeout = 1000)
	public void testIsDeadEnd__small_labyrinth__false_0_2() {
		Maze maze = new Maze(simpleMaze());
		assertTrue(maze.isDeadEnd(0, 2));
	}


	@Test(timeout = 1000)
	public void testIsDeadEnd__small_labyrinth__true_2_0() {
		Maze maze = new Maze(simpleMaze());
		assertTrue(maze.isDeadEnd(2, 0));
	}

	
	@Test(timeout = 1000)
	public void testSeekDeadEnd__small_labyrinth_before_dead_ends__gives_upper_right_field() {
		Maze maze = new Maze(simpleMaze());
		assertArrayEquals(new int[] { 0, 2 }, maze.seekDeadEnd());
	}

	@Test(timeout = 1000)
	public void testGetDeadEnds() {
		Maze maze = new Maze(simpleMaze());
		boolean[][] actualDeadEnds = new boolean[maze.getHeight()][maze.getWidth()];
		actualDeadEnds[0][2] = actualDeadEnds[0][1] = actualDeadEnds[2][0] = actualDeadEnds[2][1] = true;
		boolean[][] deadEnds = maze.solveMaze();
		assertArrayEquals(actualDeadEnds, deadEnds);
	}

	@Test(timeout = 1000)
	public void testGetSteps() {
		Maze maze = new Maze(simpleMaze());
		assertEquals(5, maze.getSteps());
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
