package amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* Find all numbers in a given array that occur odd number of times.
 * 
 */
public class FindNumberOddtimes {
	public static List<Integer> findnumberappearoddtimes(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		List<Integer> res = new LinkedList<>();
		for (int n : nums) {
			if (map.containsKey(n))
				map.put(n, map.get(n) + 1);
			else
				map.put(n, 1);
		}
		for (int n : map.keySet()) {
			if (map.get(n) % 2 == 1)
				res.add(n);
		}
		return res;
	}
}
