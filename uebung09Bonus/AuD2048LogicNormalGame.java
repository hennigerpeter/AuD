
public class AuD2048LogicNormalGame extends AuD2048LogicCommon {

	// AuD2048Logic game = AuD2048Logic.loadLogic("AuD2048LogicNormalGame");

	final int randomNumber1 = 2;
	final int randomNumber2 = 4;
	final int percentageNumber1 = 75;

	public AuD2048LogicNormalGame() {
		// startNewGame();
	}

	
	void handleMovement(int y, int x, Direction direction) {

		int y_neighbour = getYNeighbour(y, x, direction);
		int x_neighbour = getXNeighbour(y, x, direction);

		try {
			// Cell is zero - possible new value
			if (cellIsRelevant(y, x)) {
				gameBoard[y][x] = gameBoard[y_neighbour][x_neighbour];
				gameBoard[y_neighbour][x_neighbour] = 0;
			}
			// Cell is > zero - possible melting
			else {
				melt(y, x, direction);
			}

			handleMovement(y_neighbour, x_neighbour, direction);

		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	void melt(int y, int x, Direction direction) {
		// TODO Auto-generated method stub
		int y_neighbour = getYNeighbour(y, x, direction);
		int x_neighbour = getXNeighbour(y, x, direction);

		try {
			if (gameBoard[y][x] == gameBoard[y_neighbour][x_neighbour]) {
				gameBoard[y][x] *= 2;
				gameBoard[y_neighbour][x_neighbour] = 0;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// If the Neighbour doesnt exist, just do nothing here.
			e.printStackTrace();
		}
		return;
	}


}