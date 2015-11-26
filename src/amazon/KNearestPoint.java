package amazon;

import java.util.PriorityQueue;
import java.util.Comparator;

public class KNearestPoint {
	public Point[] Solution(Point[] array, Point origin, int k) {
		Point[] rvalue = new Point[k];
		int index = 0;
		PriorityQueue<Point> pq = new PriorityQueue<Point> (k, new Comparator<Point> () {
			@Override
			public int compare(Point a, Point b) {
				return (int) (getDistance(a, origin) - getDistance(b, origin));
			}
		});
		for (int i = 0; i < array.length; i++) {
			pq.offer(array[i]);
			if (pq.size() > k)
				pq.poll();
		}
		while (!pq.isEmpty())
			rvalue[index++] = pq.poll();
		return rvalue;
	}
	private double getDistance(Point a, Point b) {
		return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}
}
