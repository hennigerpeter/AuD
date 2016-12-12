public class Maze {

	// public constants for directions
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;

	// array containing all directions
	protected static final int[] DIRECTIONS = new int[] { NORTH, EAST, SOUTH, WEST };
	// 3d-boolean array containing the actual maze
	protected boolean[][][] maze;
	// 2d-boolean array containing marked dead ends
	protected boolean[][] deadEnds;

	public Maze(Maze maze) {
		this.maze = maze.maze.clone();
		this.deadEnds = new boolean[getHeight()][getWidth()];
	}

	public Maze(boolean[][][] maze) {
		this.maze = maze;
		this.deadEnds = new boolean[getHeight()][getWidth()];
	}

	/**
	 * @return maze width as integer
	 */
	public int getWidth() {
		return maze[0].length;
	}

	/**
	 * @return maze height as integer
	 */
	public int getHeight() {
		return maze.length;
	}

	/**
	 * @param y y-coordinate
	 * @param x x-coordinate
	 * @return Boolean if position (x,y) inside maze is dead end (true) or not (false)
	 */
	public boolean isDeadEnd(int y, int x) {
		// TODO
		
		int count = 0;
		
		// Pruefe alle moeglichen Himmelsrichtungen, sowie Sackgassen in allen Richtungen
		if(maze[y][x][NORTH] == false )
			count++;
		else if (y-1 >= 0){
			if(deadEnds[y-1][x]){
				count++;
			}
		}
		
		if(maze[y][x][EAST] == false )
			count++;
		else if (x+1 < getWidth()){
			if(deadEnds[y][x+1]){
				count++;
			}
		}
		
		
		if(maze[y][x][SOUTH] == false )
			count++;
		else if (y+1 < getHeight()){
			if(deadEnds[y+1][x]){
					count++;
			}
		}
		
		if(maze[y][x][WEST] == false )
			count++;
		else if (x-1 >= 0){
			if(deadEnds[y][x-1]){
					count++;
			}
		}
		
		// Wurden mehr als 2 Wege versperrt, handelt es sich um eine neue Sackgasse
		if(count > 2)
			return true;
		
		return false;
	}
	
	/**
	 * @return First dead end that was found when iterating the maze (int[0] = y, int[1] = x)
	 */
	public int[] seekDeadEnd() {
		// TODO
		//Startposition links oben
//		int x = 0, y = 0;
//		int[] pos = {0,0};
		
		// Klappert das Labyrinth in Leserichtung ab, bis das letzte Feld erreicht ist, 
		// oder eine Sackgasse gefunden wurde, welche noch nicht gekennzeichnet ist.
//		while (x < getWidth() && y < getHeight()){
//			if(isDeadEnd(y,x) && !deadEnds[y][x]){
//				pos[0] = y;
//				pos[1] = x;
//				return pos;
//			}
//			
//			// Position nach rechts verschieben falls moeglich
//			// ansonsten in die naechste Zeile wechseln, dabei x wieder auf 0 stellen
//			if (x < getWidth()){
//				x++;
//			} else if (y < getHeight()){
//				x=0;
//				y++;
//			} 
		for (int x=0; x < getWidth(); x++){
			for (int y=0; y < getHeight(); y++){	
				if(isDeadEnd(y,x) && !deadEnds[y][x]){
					int[] pos = {1,1};
					pos[0] = y;
					pos[1] = x;
					return pos;
			}
		}
				
			}
		
		
			
		return null;
	}

	/**
	 * @return 2d-boolean array containing all marked dead ends (see attribute deadEnds)
	 */
	public boolean[][] solveMaze() {
		// TODO
		
		// Array deadEnds initialisieren
		for (int x=0; x < getWidth(); x++){
			for (int y=0; y < getHeight(); y++){	
				deadEnds[y][x] = false;
				
			}
		}
		
		// Solange die Funktion Werte liefert, werden diese im Array gespeichert
		while(seekDeadEnd() != null){
			int[] dE = seekDeadEnd();
			deadEnds[dE[0]][dE[1]] = true;
		}
			
		return deadEnds;
	}

	/**
	 * @return Minimal amount of steps through the maze (from entry to exit)
	 */
	public int getSteps() {
		// TODO
		int count = 0;
		
		for (int x=0; x < getWidth(); x++){
			for (int y=0; y < getHeight(); y++){
				if (!deadEnds[y][x]){
					count++;
				}
			}
		}
		
		return count;
	}
}