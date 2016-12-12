import java.util.ArrayList;
import java.util.List;

public abstract class LabRatSolver {

	// Don't delete!! Tests will fail otherwise
	public LabRatSolver() {
	}

	/**
	 * Simulates rat movements through the maze from start to end point.
	 * 
	 * @param labRat The rat object
	 * @return The end point
	 */
	public static Point solve(LabRat labRat) {
		// TODO
		if(labRat == null)
			throw new IllegalArgumentException("labRat Objekt ist null");
		
		
		while (!labRat.isAtEndPosition()){
			
			while(!labRat.facingWall())
				labRat.stepForward();
			
			labRat.turnRight();
			
		}
		
		return labRat.getCurrentPosition();
	}

	/**
	 * Simulates the shortest way through the maze from start to end point.
	 * 
	 * @param labRat The rat object
	 * @param hops The shortest amount of hops through the maze
	 * @param r Ignore this, only for test purposes!
	 * @return Shortest amount of hops through the maze
	 */
	public static int solveShortestPath(LabRat labRat, int hops, LabRatSolver r) {
		// Don't delete!! Tests will fail otherwise
		// Pass object r to other function calls of solveShortestPath (e.g. for recursion). Do not create other instances of object r
		// Function solveShortestPath(...) must be recursive, don't implement other recursive helper functions
		r.check();

		// TODO
		if(labRat == null)
			throw new IllegalArgumentException("labRat Objekt ist null");

		
		
		return hops = solveshrtst(labRat, hops, r);
	}

	private static int solveshrtst(LabRat labRat, int hops, LabRatSolver r){
		
		// Sackgasse gefunden
		if(labRat.facingWall() && !labRat.isAtEndPosition() && !labRat.isAtStartPosition())
			return 0;
		
		// FinalState
		if (labRat.isAtEndPosition())
			return hops;
		
		int[] posDir = getPossibleDirections(labRat);
		for(int i=0; i<posDir.length; i++){
			
			int acthops = hops;
			// nur bewegen wenn dort keine wand ist ! 
			labRat.moveToDirection(posDir[i]);
			hops = solveshrtst(labRat, hops+1, r);
			
			// Ansonsten gibt es Probleme mit dem moveback
			if (hops == 0){
				hops = acthops;
				labRat.moveBack(posDir[i]);
			}
			
		}

		
		return 0;
			
		
	}
	
	private static int[] getPossibleDirections(LabRat labRat){
		// Array 1 enthaelt noch alle moeglichen Richtungen
		int[] posDir = {labRat.NORTH, labRat.EAST, labRat.SOUTH, labRat.WEST};
		int actDirection = labRat.getCurrentDirection();
		
		// Array 2 enthalt die Richtungen bei denen keine Wand kommt, ansonsten 999
		// in c wird die Anzahl an moeglichen Richtungen gespeichert
		int c = 0;
		int[] posDir2 = new int[posDir.length];
		for(int i=0; i<posDir.length;i++){
			labRat.turnToDirection(posDir[i]);
			if(!labRat.facingWall()){
				posDir2[i] = posDir[i];
				c +=1;
			} else {
				posDir2[i] = 999;
			}
			
		}
		
		// In diesem Array sind nur die Richtungen ohne Wand enthalten
		// mit a wird der Zeiger innerhalb des neuen Arrays hochgezaehlt (Array 3 ist kleiner als Array 2)
		int[] posDir3 = new int[c];
		int a = 0;
		for (int i = 0; i< posDir2.length; i++){
			if (posDir2[i] != 999){
				posDir3[a] = posDir[i];
				a +=1;
			}
		}
		
		// zurueck drehen
		labRat.turnToDirection(actDirection);
		
		
		return posDir3;
		
	}
	
	// Don't delete!! Tests will fail otherwise
	public abstract void check();
	
	
	
	// Test
	private static boolean[][] walls = new boolean[][] {
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
		
	public static void main(String[] args){
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
		
	}
}
