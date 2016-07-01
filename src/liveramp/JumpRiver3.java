package liveramp;

import java.util.Arrays;
import java.util.HashMap;

//B[i] represent the earlist time to arrive position i
public class JumpRiver3 {
	public static class Range {
		int min;
		int max;
		boolean isConnected;

		Range(int min, int max) {
			this.min = min;
			this.max = max;
			this.isConnected = false;
		}
	}

	public static int jump(int[] numbers, int D) {
		int[] nums = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == -1)
				nums[i] = -1;
			else
				nums[numbers[i]] = i + 1;
		}
		if (nums == null || nums.length == 0)
			return -1;
		if (D >= numbers.length)
			return 0;
		int totalBin = (int) Math.ceil((nums.length + 1) / D);
		HashMap<Integer, Range> map = new HashMap<Integer, Range>();
		for (int i = 0; i < nums.length; i++) {
			int NumofBin = nums[i] / (D + 1);
			int count = 0;
			if (!map.containsKey(NumofBin)) {
				map.put(NumofBin, new Range(Integer.MAX_VALUE, Integer.MIN_VALUE));
			}
			if (nums[i] == -1) {
				continue;
			}
			Range curBin = map.get(NumofBin);
			curBin.max = Math.max(nums[i], curBin.max);
			curBin.min = Math.min(nums[i], curBin.min);
			if (map.containsKey(NumofBin - 1)) {
				if (!curBin.isConnected && map.get(NumofBin - 1).max + D >= curBin.min) {
					count++;
					curBin.isConnected = true;
				}
				if (count == totalBin - 1)
					return i;
			}
			if (map.containsKey(NumofBin + 1)) {
				if (!map.get(NumofBin + 1).isConnected && map.get(NumofBin + 1).min - D <= curBin.max) {
					count++;
					map.get(NumofBin + 1).isConnected = true;
				}
				if (count == totalBin - 1)
					return i;
			}
		}
		return -1;
	}
		// 0,1,2,3|4,5
	public static void main(String[] args) {
		int[] A = { 1, -1, 2, 4, 3, 5, 6,7,0 };
		System.out.println(jump(A, 3));
	}
}