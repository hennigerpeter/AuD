public class LabRat {

	// lab rat directions
	protected final static int NORTH = 0;
	protected final static int EAST = 1;
	protected final static int SOUTH = 2;
	protected final static int WEST = 3;

	private Point currentPosition;
	private int currentDirection;
	private Lab lab;

	public LabRat(Lab lab) {
		if (lab == null)
			throw new IllegalArgumentException("Lab object is null");

		this.lab = lab;
		this.currentDirection = NORTH;
		this.currentPosition = new Point(lab.getStartPosition());
	}

	public LabRat(LabRat labRat) {
		if (labRat == null)
			throw new IllegalArgumentException("LabRat object is null");

		this.lab = labRat.lab;
		this.currentDirection = labRat.currentDirection;
		this.currentPosition = new Point(labRat.currentPosition);
	}

	public Point getCurrentPosition() {
		return currentPosition;
	}

	public int getCurrentDirection() {
		return currentDirection;
	}

	public void stepForward() {
		//TODO
		switch (getCurrentDirection()) {
		
		case NORTH: this.currentPosition.y -= 1; break;
		case EAST: 	this.currentPosition.x += 1; break;
		case SOUTH: this.currentPosition.y += 1; break;
		case WEST:	this.currentPosition.x -= 1; break;
		}
	}

	public boolean facingWall() {
		//TODO
		switch (getCurrentDirection()) {
		
		case NORTH: return this.lab.checkWall(getCurrentPosition().x, getCurrentPosition().y - 1);
		case EAST: 	return this.lab.checkWall(getCurrentPosition().x + 1, getCurrentPosition().y);
		case SOUTH: return this.lab.checkWall(getCurrentPosition().x, getCurrentPosition().y + 1);
		case WEST:	return this.lab.checkWall(getCurrentPosition().x - 1, getCurrentPosition().y);
		}
		return false;
	}

	public boolean isAtEndPosition() {
		//TODO
		return isAtPosition(lab.endPosition.x, lab.endPosition.y);
	}

	public boolean isAtStartPosition() {
		//TODO
		return isAtPosition(lab.startPosition.x, lab.startPosition.y);
	}
	
	private boolean isAtPosition(int x, int y){
		
		if(x == getCurrentPosition().x && y == getCurrentPosition().y)
			return true;
		
		return false;
	}

	public void turnRight() {
		//TODO
		switch (getCurrentDirection()) {
		
		case NORTH: this.currentDirection = EAST; 	break;
		case EAST: 	this.currentDirection = SOUTH; 	break;
		case SOUTH: this.currentDirection = WEST; 	break;
		case WEST:	this.currentDirection = NORTH; 	break;
		}
	}

	public void turnLeft() {
		//TODO
		switch (getCurrentDirection()) {
		
		case NORTH: this.currentDirection = WEST; 	break;
		case EAST: 	this.currentDirection = NORTH; 	break;
		case SOUTH: this.currentDirection = EAST; 	break;
		case WEST:	this.currentDirection = SOUTH; 	break;
		}
	}
	
	public void turnToDirection(int direction){
		
		while(getCurrentDirection() != direction)
			turnLeft();
		
	}
	
	public void moveToDirection(int direction){
		turnToDirection(direction);
		
		if (!facingWall())
			stepForward();
	}

	public void moveBack(int i) {
		// TODO Auto-generated method stub
		switch (i) {
		
		case NORTH: this.moveToDirection(SOUTH); 	break;
		case EAST: 	this.moveToDirection(WEST); 	break;
		case SOUTH: this.moveToDirection(NORTH); 	break;
		case WEST:	this.moveToDirection(EAST); 	break;
		}
	}

//	public void moveBack(LabRat labRat, int acthops, int hops) {
//		// TODO Auto-generated method stub
//		
//		int returntohops = hops - acthops;
//		
//		while(hops != returntohops){
//		if(labRat.facingWall())
//			labRat.turnRight();
//		
//		if(labRat.facingWall()){
//			labRat.turnLeft();
//			labRat.turnLeft();
//		}
//		if(labRat.facingWall())
//			return;
//		
//		labRat.stepForward();
//		hops -= 1;
//		}
//		
//	}

	public int getOppositeDirection(int actualDirection){
		int dir = getCurrentDirection();
		int res = -1;
		
		switch (actualDirection) {
		
		case NORTH: res = SOUTH; break;
		case EAST: 	res =  WEST; break;
		case SOUTH: res =  NORTH; break;
		case WEST:	res =  EAST; break;
		}
		
		this.turnToDirection(dir);
		return res;
	}
	
	
	public int getOppositeDirection() {
		// TODO Auto-generated method stub
		return getOppositeDirection(this.getCurrentDirection());
	}
	
}
