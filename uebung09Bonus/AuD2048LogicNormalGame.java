
public class AuD2048LogicNormalGame extends AuD2048Logic {

	// AuD2048Logic game = AuD2048Logic.loadLogic("AuD2048LogicNormalGame");

	public AuD2048LogicNormalGame() {
		// startNewGame();
	}

	@Override
	public void startNewGame() {
		// TODO Auto-generated method stub
		this.gameBoard = new long[this.cols][this.rows];
		placeRndNumbers();
	}

	@Override
	public void move(Direction direction) {
		// TODO Auto-generated method stub
		for (int y = 0; y < gameBoard.length; y++) {
			for (int x = 0; x < gameBoard[y].length; x++) {
				switch (direction) {
				case UP:
					if (y != 0)
						if (gameBoard[y][x] != 0)
							if (gameBoard[y + 1][x] == 0) {
								gameBoard[y + 1][x] = gameBoard[y][x];
								gameBoard[y][x] = 0;
							} else if (gameBoard[y][x] == gameBoard[y + 1][x]) {
								gameBoard[y + 1][x] += gameBoard[y][x];
								gameBoard[y][x] = 0;
							}
					break;
				case DOWN:
					if (y != gameBoard.length)
						if (gameBoard[y][x] != 0)
							if (gameBoard[y - 1][x] == 0) {
								gameBoard[y - 1][x] = gameBoard[y][x];
								gameBoard[y][x] = 0;
							} else if (gameBoard[y][x] == gameBoard[y - 1][x]) {
								gameBoard[y - 1][x] += gameBoard[y][x];
								gameBoard[y][x] = 0;
							}

					break;
				case LEFT:
					if (x != 0)
						if (gameBoard[y][x] != 0)
							if (gameBoard[y][x - 1] == 0) {
								gameBoard[y][x - 1] = gameBoard[y][x];
								gameBoard[y][x] = 0;
							} else if (gameBoard[y][x] == gameBoard[y][x - 1]) {
								gameBoard[y][x - 1] += gameBoard[y][x];
								gameBoard[y][x] = 0;
							}
					break;
				case RIGHT:
					if (x != gameBoard[y].length)
						if (gameBoard[y][x] != 0)
							if (gameBoard[y][x + 1] == 0) {
								gameBoard[y][x + 1] = gameBoard[y][x];
								gameBoard[y][x] = 0;
							} else if (gameBoard[y][x] == gameBoard[y][x + 1]) {
								gameBoard[y][x + 1] += gameBoard[y][x];
								gameBoard[y][x] = 0;
							}
					break;
				}
				placeRndNumbers();
			}
		}
	}

	private void placeRndNumbers() {
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

		// 4: 25% Chance, 2: 75% Chance
		if (rnd > 75)
			return 4;
		else
			return 2;
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasWinner() {
		// TODO Auto-generated method stub
		return false;
	}

}