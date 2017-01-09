public class AuD2048LogicFibonacci extends AuD2048LogicCommon {

	// ToDo
	final int randomNumber1 = 1;
	final int randomNumber2 = 2;
	final int percentageNumber1 = 75;
	

	public AuD2048LogicFibonacci() {

		// overwrite Game Settings
		super.randomNumber1 = randomNumber1;
		super.randomNumber2 = randomNumber2;
		super.percentageNumber1 = percentageNumber1;
	}
	
	private long getNextFibonacci(long n){
		
		if (n <= 1) { return 1; }
	    int fim1 = 1;	// Zwischenergebnis fibonacci(i - 1)
	    int fi = 1;	// Zwischenergebnis fibonacci(i)
	    for (int i = 2; i <= n; i++) {
	        int temp = fi;
	        fi = fim1 + fi;	// Berechnung naechstes Zwischenerg.
	        fim1 = temp;	// "Aufruecken" ueber temp
	    }
	    return fi;
		
	}
	
	
	@Override
	void melt(int y, int x, Direction direction) {
		// TODO Auto-generated method stub
		int y_neighbour = getYNeighbour(y, x, direction);
		int x_neighbour = getXNeighbour(y, x, direction);

		try {

			while (!cellIsRelevant(y_neighbour, x_neighbour)) {
				y_neighbour = getYNeighbour(y_neighbour, x, direction);
				x_neighbour = getXNeighbour(y, x_neighbour, direction);
			}

			if (gameBoard[y][x] == getNextFibonacci(gameBoard[y_neighbour][x_neighbour])) {
				score += gameBoard[y][x];
				gameBoard[y][x] += gameBoard[y][x];
				gameBoard[y_neighbour][x_neighbour] = 0;

				if (gameBoard[y][x] == 2584) {
					hasWinner = true;
					gameOver = true;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// If the Neighbour doesnt exist, just do nothing here.
			// e.printStackTrace();
		}
		return;
	}

}