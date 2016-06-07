public class Point {

	private int x, y;               // (x, y) co-ordinates

	public Point(int x, int y) {    // constructor
		this.x = x;
		this.y = y;
	}

	public Point() {                // no-arg constructor
		this.x = 0;
		this.y = 0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}
}


