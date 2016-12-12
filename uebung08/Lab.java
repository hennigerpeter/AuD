import java.util.*;

public class Lab {
	
	protected boolean[][] walls;
	private int height;
	private int width;
	protected Point startPosition;
	protected Point endPosition;

	public Lab(Point startPosition, Point endPosition, boolean[][] walls) {
		if (startPosition == null)
			throw new IllegalArgumentException("Start position is null");
		if (endPosition == null)
			throw new IllegalArgumentException("End position is null");
		if (walls == null)
			throw new IllegalArgumentException("Walls is null");

		this.walls = walls;
		this.startPosition = startPosition;
		this.endPosition = endPosition;
		this.width = walls.length;
		this.height = walls[0].length;
	}

	public Lab(int height, int width) {
		if (height < 5 || width < 5)
			throw new IllegalArgumentException("Size and width must be at least 5");
		if (height % 2 == 0 || width % 2 == 0)
			throw new IllegalArgumentException("Size and width must be an odd number");

		this.height = height;
		this.width = width;
		generateWalls();
	}

	public void generateWalls() {
		this.walls = new boolean[width][height];

		// Initialize maze with walls
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
				walls[x][y] = true;

		Random rand = new Random();

		// Generate random y
		int y = rand.nextInt(height);
		while (y % 2 == 0)
			y = rand.nextInt(height);

		// Generate random x
		int x = rand.nextInt(width);
		while (x % 2 == 0)
			x = rand.nextInt(width);

		// Starting position
		walls[x][y] = false;
		this.startPosition = new Point(x, y);

		// Generate maze
		doGenerateWalls(x, y);
	}

	public void doGenerateWalls(int x, int y) {
		// 4 random directions
		List<Integer> directions = new ArrayList<>();
		directions.add(1);
		directions.add(2);
		directions.add(3);
		directions.add(4);

		Collections.shuffle(directions);
		this.endPosition = new Point(x, y);

		for (int direction : directions) {

			switch (direction) {

			case 1:
				// Up
				if (y - 2 <= 0)
					continue;

				if (walls[x][y - 2]) {
					walls[x][y - 2] = false;
					walls[x][y - 1] = false;
					doGenerateWalls(x, y - 2);
				}
				break;

			case 2:
				// Right
				if (x + 2 >= width)
					continue;

				if (walls[x + 2][y]) {
					walls[x + 2][y] = false;
					walls[x + 1][y] = false;
					doGenerateWalls(x + 2, y);
				}
				break;

			case 3:
				// Down
				if (y + 2 >= height)
					continue;

				if (walls[x][y + 2]) {
					walls[x][y + 2] = false;
					walls[x][y + 1] = false;
					doGenerateWalls(x, y + 2);
				}
				break;

			case 4:
				// Left
				if (x - 2 <= 0)
					continue;

				if (walls[x - 2][y]) {
					walls[x - 2][y] = false;
					walls[x - 1][y] = false;
					doGenerateWalls(x - 2, y);
				}
				break;
			}
		}
	}

	public void printMaze() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++)
				if (walls[x][y])
					System.out.print(" * ");
				else {
					if (startPosition.x == x && startPosition.y == y)
						System.out.print(" S ");
					else if (endPosition.x == x && endPosition.y == y)
						System.out.print(" E ");
					else
						System.out.print(" O ");
				}
			System.out.println("");
		}
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Point getStartPosition() {
		return startPosition;
	}

	public Point getEndPosition() {
		return endPosition;
	}

	public boolean checkWall(Point position) {
		//TODO
		if (position == null)
			throw new IllegalArgumentException("chekWall(Point position)");	
		
		return checkWall(position.x, position.y);
		
	}

	public boolean checkWall(int x, int y) {
		//TODO
		
		if (walls[x][y] == false)
			return false;
		
		return true;
		
	}
}
