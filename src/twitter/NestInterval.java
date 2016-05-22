package twitter;

import java.util.LinkedList;
import java.util.List;

/* Given a set of [a,b] intervals on the number line, find the longest ordered sequence (consecutive in original order) of (a subset of) the intervals such that each consecutive interval is nested inside the previous one.
 * "Nested" means this: If interval X is nested inside Y, then Y.a < X.a and X.b < Y.b.
 * E.g. given [[3,4], [1,9], [2,8], [4,5], [11,12]]
 * Return: [[1, 9], [2, 8], [4, 5]]
Follow-up #1:
Given a set of [a,b] intervals on the number line, find the longest ordered sequence of (a subset of) the intervals such that each consecutive interval is nested inside the previous one.
"Nested" means this: If interval X is nested inside Y, then Y.a < X.a and X.b < Y.b.
E.g. given [[1,10], [3,4], [2,9], [3,8], [4,5], [11,12]].
Return: [[1,10], [2,9], [3,8], [4,5]].
Follow-up #2:
Given a set of [a,b] intervals on the number line, find the longest sequence of (a subset of) the intervals such that each consecutive interval is nested inside the previous one.
"Nested" means this: If interval X is nested inside Y, then Y.a < X.a and X.b < Y.b.
Note: the original order doesn't need to be maintained.
E.g. given [[1,10], [3,4], [4,5], [11,12], [3,8], [2,9]]
Return: [[1,10], [2,9], [3,8], [4,5]]
*/
public class NestInterval {
	public List<Interval> maxNextInterval(Interval[] interval) {
		List<Interval> list = new LinkedList<>();
		List<Interval> res = new LinkedList<>();
		if (interval.length == 0)
			return list;
		list.add(interval[0]);
		for (int i = 1; i < interval.length; i++) {
			if (interval[i].start <= interval[i - 1].start || interval[i].end >= interval[i].end) {
				if (list.size() > res.size())
					res = new LinkedList<>(list);
				list.clear();
			} else {
				list.add(interval[i]);
			}
		}
		if (list.size() > res.size())
			res = new LinkedList<>(list);
		return res;
	}
}
