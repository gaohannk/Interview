package liveramp;

import java.util.Arrays;
import java.util.HashMap;

public class Sequence3 {
	public static int solution(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int res = 1;
		for (int item : A) {
			map.put(item, map.getOrDefault(item, 0) + 1);
		}
		for (int num : map.keySet()) {
			int count = map.get(num);
			if (map.containsKey(num + 1)) {
				count += map.get(num + 1);
			}
			res = res > count ? res : count;
			count = map.get(num);
			if (map.containsKey(num - 1)) {
				count += map.get(num - 1);
			}
			res = res > count ? res : count;

		}
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 2, 2, 3, 4, 4, 4, 4, 4, 5, 5, 6 };
		System.out.println(solution(A));
	}
}
