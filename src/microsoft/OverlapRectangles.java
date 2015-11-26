package microsoft;

public class OverlapRectangles {
	public static boolean isOverlap(Point l1, Point r1, Point l2, Point r2) {
		// If one rectangle is on left side of other
		if (l1.x > r2.x || l2.x > r1.x)
			return false;

		// If one rectangle is above other
		if (l1.y < r2.y || l2.y < r1.y)
			return false;
		return true;
	}

	class Point {
		int x;
		int y;
	}
}
