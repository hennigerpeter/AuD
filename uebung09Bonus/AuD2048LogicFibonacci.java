public class AuD2048LogicFibonacci extends AuD2048Logic {

	// ToDo
	final int randomNumber1 = 1;
	final int randomNumber2 = 2;
	final int percentageNumber1 = 75;

	@Override
	public void startNewGame() {
		// TODO Auto-generated method stub
		this.gameBoard = new long[this.cols][this.rows];
	}

	@Override
	public void move(Direction direction) {
		// TODO Auto-generated method stub

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