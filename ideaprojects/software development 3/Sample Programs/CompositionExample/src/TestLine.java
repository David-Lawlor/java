public class TestLine {
	public static void main(String[] args) {
		Point p1 = new Point(1, 2);
		System.out.println(p1);
		Point p2 = new Point(3, 4);
		System.out.println(p2);

		Line line1 = new Line(p1, p2);
		System.out.println(line1);

		Line line2 = new Line(0, 0, 1, 1);
		System.out.println(line2);
	}
}


