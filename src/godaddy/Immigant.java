package godaddy;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Immigant {
	public static int[] findPairs(int[] a1, int[] a2) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < a1.length; i++) {
			if (map.containsKey(a1[1]))
				map.put(a1[i], map.get(a1[i]) + 1);
			else {
				map.put(a1[i], 1);
			}
		}
		int result[] = new int[a1.length];
		int index = 0;
		for (int i = 0; i < a2.length; i++) {
			if (map.containsKey(a2[i])) {
				result[index] = a2[i];
				index++;
				if (map.get(a2[i]) == 1)
					map.remove(a2[i]);
				else {
					map.put(a2[i], map.get(a2[i]) - 1);
				}
			}
		}
		return result;
	}
}
