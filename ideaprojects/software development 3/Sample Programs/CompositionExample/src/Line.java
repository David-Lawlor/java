public class Line {
	Point begin, end; // begin and end Points

	public Line(int x1, int y1, int x2, int y2) { // constructor 1
		begin = new Point(x1, y1);
		end = new Point(x2, y2);
	}

	public Line(Point begin, Point end) { // constructor 2
		this.begin = begin;
		this.end = end;
	}

	public String toString() {
		return "Line from " + begin + " to " + end;
	}
}

