public class Point {

	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}

	@Override
	public boolean equals(Object obj) {
		Point other = (Point) obj;
		return this.x == other.x && this.y == other.y;
	}
}
