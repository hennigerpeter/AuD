// ***** DO NOT MODIFY THE CODE BELOW ***** //

enum Direction {
	// used to denote, which arrow key has been pressed by the player:
	UP, DOWN, LEFT, RIGHT
}

public abstract class AuD2048Logic {
	protected int rows, cols; // the size of the game board (number of rows resp. number of columns, must always be rectangular!)
	protected long[][] gameBoard; // negative values indicate blocked fields and a value of 0 will not show up in the GUI
	protected long score;

	public static final AuD2048Logic loadLogic(String logicName) {
		try {
			return Class.forName(logicName).asSubclass(AuD2048Logic.class).newInstance();
		} catch (Throwable t) {
		}
		return null;
	}

	public final void initializeLogic(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}

	public final long[][] getGameBoard() {
		return gameBoard;
	}

	public final long getScore() {
		return score;
	}

	// (Re)Initializes the game board, preparing it for a new game.
	public abstract void startNewGame();

	// Executes the move requested by the player.
	public abstract void move(Direction direction);

	// Checks if the player has lost the game (i.e. no move is possible anymore).
	public abstract boolean isGameOver();

	// Checks if the player has won the game (according to the corresponding 2048 variant rules).
	public abstract boolean hasWinner();

	@Override
	public final String toString() {
		return this.getClass().getName();
	}
}