public class KenKen {
	
	// public constants
	public final int[][] state = new int[1][];
	
	public static final int spc = (int)' ';
	public static final int mul = (int)'*';
	public static final int div = (int)'/';
	public static final int add = (int)'+';
	public static final int sub = (int)'-';
	
	// Constructor
	public KenKen() {}
	
	/*
	 * Checks the structural integrity of the 3D-array kenken
	 * returns the number of the first condition not met (smallest number) otherwise
	 * 0, if all the conditions for structural integrity above are met
    */
	public static int checkIntegrity(int[][][] kenken){
		
				
		// kenken is non-null and contains at least one entry, i.e. a "row" in the first dimension representing a "partition"
    	if (kenken == null || kenken.length == 0 || kenken[0].length == 0 || kenken[0][0].length == 0)
			return 1;
    	
		for (int i = 0; i < kenken.length; i++){
			
			// each row (partition) contains a non-null 2D-array 
	    	// of type int[][] with at least two sub-entries of type int[]
			if (kenken[i] == null || kenken[i][0] == null || kenken[i][1] == null)
				return 2;
			
			// Counts the SubEntrys after the operation. 
			int followingSubEntry = 0;
			
			// Saves the Operation and Result for later usage
			int result = kenken[i][0][0];
			int operation = kenken[i][0][1];
			
			for (int j = 0; j < kenken[i].length; j++){
				
				// each sub-entry in a row (partition) is non-null and has length 2
				if(kenken[i][j] == null || kenken[i][j].length != 2)
					return 3;
								
				// Check if the result and operation are correct
				if (j==0){
					
					// the first sub-entry in a row is a pair {result, operation}, 
			    	// where result is an integer number and operation is a char(acter)
					if (result <= 0 || operation < 0 || operation > 127)
						return 4;
					
					// operation must be one of '+', '-', '/', '*', ' ' (whitespace)
					if (operation != add && operation != sub && operation != div && operation != mul && operation != spc)
						return 5;	
					
				} else {
					followingSubEntry++;
				}
				
				if (kenken[i][j][0] < 0 || kenken[i][j][1] < 0)
					return 6;
				
				
			}
			
			// if operation is ' ' (whitespace), then exactly one sub-entry must follow the {result, operation}-pair
			// if operation is '-' or '/', then exactly two sub-entries must follow the {result, operation}-pair
			// if operation is '+' or '*', then at least two sub-entries must follow the {result, operation}-pair
			
			switch (operation){
			
			case spc: if (followingSubEntry != 1)
						return 7; 
					break;
			case sub: if (followingSubEntry != 2)
						return 8; 
					break;
			case div: if (followingSubEntry != 2)
						return 8; 
					break;
			case add: if (followingSubEntry < 2)
						return 9;
					break;
			case mul: if (followingSubEntry < 2)
						return 9;
					break;
			}
		}	
		return 0;
	}
	
	/*
	 * Checks the semantical validity of the 3D-array kenken
	 */
    public static int checkValidity(int[][][] kenken){
		
    	int ret = checkIntegrity(kenken);
    	
    	if (ret != 0)
    		return 1;
	 
    	int[][] square = initSquare(kenken);
    	
     	// A square has to have as many columns as it has rows
    	if (square.length != square[0].length)
    		return 2;
    	   	
    	// Another iteration to check all used fields.
    	for (int i=0; i<kenken.length;i++){
    		for (int j=1; j<kenken[i].length;j++){

    			int row = kenken[i][j][0];
    			int col = kenken[i][j][1];
    			
    			// 0 is the default value for int[]
    			if (square[col][row] == 0)
    				square[col][row] = 1;
    			else return 2;
    		}
    	}
    	
    	// Every iteration counts
    	for (int i=0; i<square.length;i++){
    		for (int j=0; j<square[i].length;j++){
    			
    			if (square[i][j] != 1)
    				return 2;
    		}
    	}
    	return 0;
	}
        
	private static int[][] initSquare(int[][][] kenken) {

    	int maxrow = 0;
		int maxcol = 0;
		
		// Iterate through all row/col combinations to get the amount of rows and columns needed
    	for (int i=0; i<kenken.length;i++){
    		for (int j=1; j<kenken[i].length;j++){

    		if (maxrow < kenken[i][j][0])
    			maxrow = kenken[i][j][0];
    		
    		if (maxcol < kenken[i][j][1])
    			maxcol = kenken[i][j][1];
    		}
    	}
    	
    	int[][] square = new int[maxcol+1][maxrow+1];
    	
		return square;
	}

	/*
	 * Tries to solve the KenKenTM puzzle encoded in the 3D-array kenken
	 */
    public static int[][] solve(int[][][] kenken){
		
    	//null, if kenken is illegal according to checkIntegrity(int[][][]) and checkValidity(int[][][]) or has no solution
    	if (checkValidity(kenken) != 0)
    		return null;
    	
		int[][] state = initSquare(kenken);
		
		state = backtrack(kenken, state);
			
		return state;
	}
	

	private static int[][] backtrack(int[][][] kenken, int[][]state) {
    	// Ab dem n+1 Durchlauf alle Validierungen durchfuehren
		if (isNotReady(state) && !checkPartition(kenken, state))
			return null;
		
		// Pruefen ob wir das Raetsel geloest haben
		if(isFinal(state, kenken)){
			return state;
		} else {
			int[] location = getNextLocation(state, kenken);

			// Die Schleife ersetzt die getExtensions Methode der Uebungsfolien
			for (int i=1;i<=state.length;i++){
				
				// Setze Zahl ein
				state = apply(state, i, location);
				
					
				// Pruefen ob Loesung gefunden wurde
				if (backtrack(kenken, state) != null) {
					return state;
				}
				
				state = revert(state, location); // Zahl wieder loeschen
				
			}
			return null;
		}
    }

	private static boolean isFinal(int[][] state, int[][][] kenken) {

		// Pruefen ob alle Felder der Loesung gefuellt sind
		
		for (int y=0;y<state.length;y++){
			
			for (int x=0;x<state[y].length;x++){
				if (state[y][x] == 0)
					return false;
			}
		}
				
		if (checkPartition(kenken, state))
			return true;
		
		return false;
	}
	
	private static boolean isValid(int[][] state){
		
		// Jedes Feld wird einmal geprueft
		for (int yCurrent=0;yCurrent<state.length;yCurrent++){
			for (int xCurrent=0;xCurrent<state.length;xCurrent++){
		
				// Feld das geprueft wird
				int current = state[yCurrent][xCurrent];
			
				if (current > 0){
					for (int j=0;j<state.length;j++){
						
						// Es wird nur mit benachbarten Feldern der x-Achse verglichen, nicht mit dem eigenen Feld
						if (j != xCurrent){
							int nextx = state[yCurrent][j];
							
							if(current == nextx)
								return false;
						}
						// Es wird nur mit benachbarten Feldern der y-Achse verglichen, nicht mit dem eigenen Feld
						if (j != yCurrent){
							int nexty = state[j][xCurrent];
						
							if(current == nexty)
								return false;
						}
					}
				}
			}
		}
		
		return true;
	}

	private static int[] getNextLocation(int[][] state, int[][][] kenken) {

		int[] location = new int[2];
		
		// Iteriert durch alle Spalten und dann Zeilen
//		for (int y = 0; y<state.length; y++){
//			
//			for (int x = 0; x<state.length; x++){
//		
//				if (state[y][x] == 0){
//					location[0] = y;
//					location[1] = x;
//					return location;
//				}
//			}
//		}
//		
//		return null;
		
		// Alternativ: Iteriert durch alle Partitionen und darin durch alle Felder bis das erste mit 0 gefunden wurde
		
		for (int i=0; i<kenken.length;i++){
    		for (int j=1; j<kenken[i].length;j++){

    			if (state[kenken[i][j][0]][kenken[i][j][1]] == 0){
    				location[0] =  kenken[i][j][0];
    				location[1] =  kenken[i][j][1];
    				return location;
    			}
    		}
    	}
		
		
		
		return null;
		
	}

	

	private static int[][] apply(int[][] state, int candidate, int[] location) {
		
		state[location[0]][location[1]] = candidate;
		
		return state;
	}
	
	private static int[][] revert(int[][] state, int[] location) {
		
		return apply(state, 0, location);
	}
			
	private static boolean checkPartition(int[][][] kenken, int[][] state) {
			
		// Durch alle Partitionen iterieren und die Berechnung pruefen
		
		for (int i=0; i < kenken.length; i++){
			
			
			// Variablen fuer die aktuelle Partition
			int current = 0;
			int result = kenken[i][0][0];
			int operation = kenken[i][0][1];
			boolean hasEmptyFields = false;
			int next = 0;
			
			for (int j=1; j<kenken[i].length; j++){
				
				next = state[kenken[i][j][0]][kenken[i][j][1]];
				
				if (next != 0){
					switch (operation) {
						case mul:	current = multiply(current, next);
									break;
						
						case div: 	current = divide(current, next);
									break;
							
						case add:	current += next;
									break;
							
						case sub: 	current = Math.abs(current - next);
									break;
							
						case spc: 	current = next;
									break;
					}
				} else {
					hasEmptyFields = true;
				}
			}
			// Die Berechnung kann erst falsch sein, wenn alle Partitionsfelder befuellt sind
			if (!hasEmptyFields && result != current)
				return false;
		}
		
		if(!isValid(state))
			return false;
		
		return true;
	}

	private static int divide(int a, int b) {
		
		if(a==0) {
			  return b;
			}
			
		if (a > b){
			a /= b;
		} else {
			a = b / a;
		}
	
		return a;
	}

	private static int multiply(int a, int b) {

		if(a==0) {
			return b;
		}
		a *= b;

		return a;
		
	}
	
	public static boolean isNotReady(int[][] state){
		
		for (int i = 0; i < state.length; i++) {
			
			for (int j = 0; j < state.length; j++) {
				
				if (state[i][j]!=0){
					return true;
				}
			}
		}
		
		return false; 
	}
	
//	public static void main (String args[]){
//    	
//    	final int[][][] kenkenWikipediaOriginal = { //
//    			{ { 11, '+' }, { 0, 0 }, { 1, 0 } }, //
//    			{ { 2, '/' }, { 0, 1 }, { 0, 2 } }, //
//    			{ { 20, '*' }, { 0, 3 }, { 1, 3 } }, //
//    			{ { 6, '*' }, { 0, 4 }, { 0, 5 }, { 1, 5 }, { 2, 5 } }, //
//    			{ { 3, '-' }, { 1, 1 }, { 1, 2 } }, //
//    			{ { 3, '/' }, { 1, 4 }, { 2, 4 } }, //
//    			{ { 240, '*' }, { 2, 0 }, { 2, 1 }, { 3, 0 }, { 3, 1 } }, //
//    			{ { 6, '*' }, { 2, 2 }, { 2, 3 } }, //
//    			{ { 6, '*' }, { 3, 2 }, { 4, 2 } }, //
//    			{ { 7, '+' }, { 3, 3 }, { 4, 3 }, { 4, 4 } }, //
//    			{ { 30, '*' }, { 3, 4 }, { 3, 5 } }, //
//    			{ { 6, '*' }, { 4, 0 }, { 4, 1 } }, //
//    			{ { 9, '+' }, { 4, 5 }, { 5, 5 } }, //
//    			{ { 8, '+' }, { 5, 0 }, { 5, 1 }, { 5, 2 } }, //
//    			{ { 2, '/' }, { 5, 3 }, { 5, 4 } } //
//    	};
//    	
//    	
//		int[][] actual = KenKen.solve(kenkenWikipediaOriginal);
//    	System.out.println(actual);
//    }
    
}