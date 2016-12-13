
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
			throw new RuntimeException("Undefined Runtime Exception");
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
			// Base
			if (labRat.isAtEndPosition())
				return hops;
			
			// Check the possible Directions. These are all directions without walls
			// In the first run, all these directions are possible. After that, the 
			// direction from which we came is filtered out.
			int[] posDirections;
			
			if (hops == 0)
				posDirections = getPossibleDirections(labRat, true);	
			else
				posDirections = getPossibleDirections(labRat, false);	
			
			// Iterate and try all possible directions
			for (int i=0; i < posDirections.length; i++){
				
				// try to move in this direction
				labRat.moveToDirection(posDirections[i]);
				hops += 1;
				
				int newHops = solveShortestPath(labRat, hops, r);
				if (newHops != -1)
					return newHops;
					
				// return
				labRat.moveToDirection(labRat.getOppositeDirection(posDirections[i]));
				hops -= 1;
			}
			
			// No solution found
			return -1;
			
		} catch (Exception exc) {
			throw new RuntimeException("Unimplemented Exception");
		}
	}

	private static int[] getPossibleDirections(LabRat labRat, Boolean Init){
		// Array 1 contains all directions that exist
		int[] posDir = {LabRat.NORTH, LabRat.EAST, LabRat.SOUTH, LabRat.WEST};
		int actDirection = labRat.getCurrentDirection();
		int oppDirection = labRat.getOppositeDirection();
		
		// Array 2 contains directions without walls. Directions with walls are temporarily saved as 999
		// the number of directions without walls is saved in "c" in order to create an array with that dimension
		int c = 0;
		int[] posDir2 = new int[posDir.length];
		for(int i=0; i<posDir.length;i++){
			labRat.turnToDirection(posDir[i]);
			
			// In order to only go back if we want to, the direction we came from is only used in the first run. 
			if(!Init && oppDirection == posDir[i])
				posDir2[i] = 999;
			else if(!labRat.facingWall()){
						
				posDir2[i] = posDir[i];
				c +=1;
			} else {
				posDir2[i] = 999;
			}
		}
		
		// Array 3 contains only directions that are possible to move to
		// variable a is used to point to the position in the smaller Array 3
		int[] posDir3 = new int[c];
		int a = 0;
		for (int i = 0; i< posDir2.length; i++){
			if (posDir2[i] != 999){
				posDir3[a] = posDir[i];
				a +=1;
			}
		}
		
		// Turn to the previous direction
		labRat.turnToDirection(actDirection);
		
		return posDir3;
		
	}
	
	// Don't delete!! Tests will fail otherwise
	public abstract void check();
	
}
