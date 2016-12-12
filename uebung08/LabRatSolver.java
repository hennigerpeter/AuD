
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
			throw new IllegalArgumentException("LabRat is null");
		
		try {
		
			while (!labRat.isAtEndPosition()){
				while(!labRat.facingWall())
					labRat.stepForward();	
				labRat.turnRight();
				
			}
			
			return labRat.getCurrentPosition();
		
		} catch (Exception exc) {
			throw new RuntimeException("Unimplemented Exception");
		}
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
			throw new IllegalArgumentException("LabRat is null");
		
		try {
			if (labRat.isAtEndPosition())
				return hops;
			
			int[] posDirections;
			
			if (hops == 0)
				posDirections = getPossibleDirections(labRat, true);	
			else
				posDirections = getPossibleDirections(labRat, false);	
			
			int actDirection = labRat.getCurrentDirection();
			
			for (int i=0; i < posDirections.length; i++){
				// try
				
				labRat.moveToDirection(posDirections[i]);
				hops += 1;
				
				
				int newHops = solveShortestPath(labRat, hops, r);
				if (newHops != -1)
					return newHops;
					
				// error
				labRat.moveToDirection(labRat.getOppositeDirection(posDirections[i]));
				
				hops -= 1;
			}
					
			return -1;
			
		} catch (Exception exc) {
			throw new RuntimeException("Unimplemented Exception");
		}
	}

	private static int[] getPossibleDirections(LabRat labRat, Boolean Init){
		// Array 1 enthaelt noch alle moeglichen Richtungen
		int[] posDir = {labRat.NORTH, labRat.EAST, labRat.SOUTH, labRat.WEST};
		int actDirection = labRat.getCurrentDirection();
		int oppDirection = labRat.getOppositeDirection();
		
		// Array 2 enthalt die Richtungen bei denen keine Wand kommt, ansonsten 999
		// in c wird die Anzahl an moeglichen Richtungen gespeichert
		int c = 0;
		int[] posDir2 = new int[posDir.length];
		for(int i=0; i<posDir.length;i++){
			labRat.turnToDirection(posDir[i]);
			
			// Die Richtung aus der wir kommen ist nur beim ersten Aufruf interessant
			if(!Init && oppDirection == posDir[i])
				posDir2[i] = 999;
			else if(!labRat.facingWall()){
						
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
	
}
