package pocketgems;

import java.util.Arrays;

public class MinCosttoConnect {
	public static int findMinCosttoConnect(int[] len) {
		Arrays.sort(len);
		int sum = 0;
		int cost = len[0];
		for (int i = 1; i < len.length; i++) {
			cost = cost + len[i];
			sum += cost;
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] num={2,8,6,3,4};
		System.out.println(findMinCosttoConnect(num));
	}

		
}
