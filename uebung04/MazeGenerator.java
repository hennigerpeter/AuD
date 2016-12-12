public class MazeGenerator {
	private static final int[] DIRECTIONS = new int[] { Maze.NORTH, Maze.EAST, Maze.SOUTH, Maze.WEST };
	private static boolean[][][] maze;
	private static boolean[][] visited;

	/**
	 * @param width maze width
	 * @param height maze height
	 * @return Random generated width x height maze
	 */
	public static Maze generate(int width, int height) {
		maze = new boolean[height][width][4];
		visited = new boolean[height][width];
		shuffle(DIRECTIONS);

		int entry = (int) (Math.random() * 4);
		int exit = (int) (Math.random() * 4);
		if (entry == exit) {
			exit = (exit + 1) % 4;
		}
		int yEntry = DIRECTIONS[entry] == Maze.NORTH ? 0
				: DIRECTIONS[entry] == Maze.SOUTH ? height - 1 : (int) (Math.random() * height);
		int xEntry = DIRECTIONS[entry] == Maze.WEST ? 0
				: DIRECTIONS[entry] == Maze.EAST ? width - 1 : (int) (Math.random() * width);

		int yExit = DIRECTIONS[exit] == Maze.NORTH ? 0
				: DIRECTIONS[exit] == Maze.SOUTH ? height - 1 : (int) (Math.random() * height);
		int xExit = DIRECTIONS[exit] == Maze.WEST ? 0
				: DIRECTIONS[exit] == Maze.EAST ? width - 1 : (int) (Math.random() * width);

		maze[yEntry][xEntry][DIRECTIONS[entry]] = true;
		maze[yExit][xExit][DIRECTIONS[exit]] = true;
		generateRecursive(yEntry, xEntry);

		return new Maze(maze);
	}

	private static void generateRecursive(int yFrom, int xFrom) {
		visited[yFrom][xFrom] = true;
		int[] richtungen = { Maze.NORTH, Maze.EAST, Maze.SOUTH, Maze.WEST };
		shuffle(richtungen);
		for (int d : richtungen) {
			switch (d) {
			case Maze.NORTH:
				step(yFrom, xFrom, -1, 0);
				break;
			case Maze.EAST:
				step(yFrom, xFrom, 0, 1);
				break;
			case Maze.SOUTH:
				step(yFrom, xFrom, 1, 0);
				break;
			case Maze.WEST:
				step(yFrom, xFrom, 0, -1);
				break;
			}
		}
	}

	private static void shuffle(int[] feld) {
		java.util.Random r = new java.util.Random();
		int len = feld.length;
		for (int i = 0; i < feld.length; i++) {
			int pos = i + r.nextInt(len - i);
			int tmp = feld[i];
			feld[i] = feld[pos];
			feld[pos] = tmp;
		}
	}

	private static void step(int yFrom, int xFrom, int yDelta, int xDelta) {
		int yTo = yFrom + yDelta;
		int xTo = xFrom + xDelta;
		if (yTo < 0 || yTo >= maze.length || xTo < 0 || xTo >= maze[yTo].length || visited[yTo][xTo]) {
			return;
		}
		removeWall(yFrom, xFrom, yTo, xTo);
		generateRecursive(yTo, xTo);
	}

	private static void removeWall(int yFrom, int xFrom, int yTo, int xTo) {
		if (yFrom == yTo && xFrom - xTo == -1) { // "to" is Maze.EAST of "from"
			maze[yFrom][xFrom][Maze.EAST] = true;
			maze[yTo][xTo][Maze.WEST] = true;
		} else if (yFrom == yTo && xFrom - xTo == 1) { // "to" is Maze.WEST of "from"
			maze[yFrom][xFrom][Maze.WEST] = true;
			maze[yTo][xTo][Maze.EAST] = true;
		} else if (xFrom == xTo && yFrom - yTo == -1) { // "to" is Maze.SOUTH of "from"
			maze[yFrom][xFrom][Maze.SOUTH] = true;
			maze[yTo][xTo][Maze.NORTH] = true;
		} else if (xFrom == xTo && yFrom - yTo == 1) { // "to" is Maze.NORTH of "from"
			maze[yFrom][xFrom][Maze.NORTH] = true;
			maze[yTo][xTo][Maze.SOUTH] = true;
		} else { // rooms must be be adjacent to each other
			System.err.format("Cannot connect (%d,%d) and (%d,%d)", yFrom, xFrom, yTo, xTo);
			return;
		}
	}
}