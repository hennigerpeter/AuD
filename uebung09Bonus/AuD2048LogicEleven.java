public class AuD2048LogicEleven extends AuD2048LogicCommon {

	final int randomNumber1 = 1;
	final int randomNumber2 = 2;
	final int percentageNumber1 = 75;

	public AuD2048LogicEleven() {

		// overwrite Game Settings
		super.randomNumber1 = randomNumber1;
		super.randomNumber2 = randomNumber2;
		super.percentageNumber1 = percentageNumber1;
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

			if (gameBoard[y][x] == gameBoard[y_neighbour][x_neighbour]) {
				score += gameBoard[y][x];
				gameBoard[y][x] += gameBoard[y][x];
				gameBoard[y_neighbour][x_neighbour] = 0;

				if (gameBoard[y][x] == 11) {
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