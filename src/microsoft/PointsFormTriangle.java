package microsoft;

public class PointsFormTriangle {
	public class Point {
		int x;
		int y;
	}

	public static boolean canFromTriangle(Point a, Point b, Point c) {
		/*
		 * double d1 = getDistance(a, b); double d2 = getDistance(a, c); double
		 * d3 = getDistance(b, c); if(d1<d2){ if(d2<d3) if(d1+d2>d3) return
		 * true; else return false; else if(d1+d3>d2) return true; else return
		 * false; }else{ if(d3>d1) if(d1+d2>d3) return true; else return false;
		 * else { if(d3+d2>d1) return true; else return false; } }
		 */
		if (a.x == b.x) {
			if (c.x != a.x)
				return true;
			else {
				return false;
			}
		} else if (a.x == c.x || b.x == c.x) {
			if (b.x != a.x)
				return true;
			else {
				return false;
			}
		}
		if (a.y == b.y) {
			if (c.y != a.y)
				return true;
			else {
				return false;
			}
		} else if (a.y == c.y || b.y == c.y) {
			if (b.y != a.y)
				return true;
			else {
				return false;
			}
		}
		if ((a.y - b.y) / (a.x - b.x) == (a.y - c.y) / (a.x - c.x))
			return true;
		return false;

	}
}
