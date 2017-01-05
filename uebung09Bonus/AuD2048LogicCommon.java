public abstract class AuD2048LogicCommon extends AuD2048Logic {

	public int randomNumber1 = 1;
	final int randomNumber2 = 2;
	final int percentageNumber1 = 75;

	protected boolean gameOver = false;
	protected boolean hasWinner = false;

	@Override
	public void startNewGame() {

		this.gameBoard = new long[this.cols][this.rows];
		placeRndNumbers();
	}

	@Override
	public void move(Direction direction) {

		// Iterate through cells
		// Direction: LEFT/RIGHT: Zeile fuer Zeile durchgehen, UP/DOWN: Spalte
		// fuer Spalte durchgehen. jewils von der anderen Seite
		switch (direction) {
		case UP:
			for (int x = 0; x < gameBoard[0].length; x++) {
				handleMovement(gameBoard.length - 1, x, direction);
			}
			break;
		case DOWN:
			for (int x = 0; x < gameBoard[0].length; x++) {
				handleMovement(0, x, direction);
			}
			break;
		case RIGHT:
			for (int y = 0; y < gameBoard.length; y++) {
				handleMovement(y, gameBoard[0].length, direction);
			}
			break;
		case LEFT:
			for (int y = 0; y < gameBoard.length; y++) {
				handleMovement(y, 0, direction);
			}
			break;
		}

		placeRndNumbers();

	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return gameOver;
	}

	@Override
	public boolean hasWinner() {
		// TODO Auto-generated method stub
		return hasWinner;
	}

	public void placeRndNumbers() {
		int rnd1 = createRndNumbers();
		int rnd2 = createRndNumbers();

		placeIntoRandomField(rnd1);
		placeIntoRandomField(rnd2);

	}

	private void placeIntoRandomField(int rnd) {
		int counter = (int) (Math.random() * 10);
		counter *= (this.cols * this.rows);

		// The Counter Variable ensures that all Fields are considered possible
		// Spots for the new number.
		int y = 0, x = 0;
		while (counter >= 0) {
			if (gameBoard[y][x] == 0) {
				if (counter == 0) {
					gameBoard[y][x] = rnd;

				}
				counter--;

			}
			x++;
			if (x >= gameBoard[y].length) {
				x = 0;
				y += 1;
			}
			if (y >= gameBoard.length)
				y = 0;
		}
	}

	private int createRndNumbers() {

		// Random Number between 0 and 99 + 1
		int rnd = (int) (Math.random() * 100 + 1);

		if (rnd > percentageNumber1)
			return randomNumber1;
		else
			return randomNumber2;
	}

	protected boolean cellIsRelevant(int y, int x) {

		if (gameBoard[y][x] > 0)
			return true;

		return false;
	}

	protected int getXNeighbour(int y, int x, Direction direction) {
		// TODO Auto-generated method stub
		switch (direction) {
		case UP:
			return x;
		case DOWN:
			return x;
		case RIGHT:
			return x - 1;
		case LEFT:
			return x + 1;
		}
		return -1;
	}

	protected int getYNeighbour(int y, int x, Direction direction) {
		// TODO Auto-generated method stub
		switch (direction) {
		case UP:
			return y + 1;
		case DOWN:
			return y - 1;
		case RIGHT:
			return y;
		case LEFT:
			return y;
		}
		return -1;
	}

	protected void handleMovement(int y, int x, Direction direction) {

		int y_neighbour = getYNeighbour(y, x, direction);
		int x_neighbour = getXNeighbour(y, x, direction);
		if (!gameOver) {
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
		}
		return;
	}

	abstract void melt(int y, int x, Direction direction);


}