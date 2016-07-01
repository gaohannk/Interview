package liveramp;

import java.util.Arrays;

public class Sequence {
	public static int solution(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		Arrays.sort(A);
		int count = 1;
		int res = 1;
		int firstLenth = 0;
		int pointIndex = 0;
		boolean flag = false;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[i - 1]) {
				count++;
			} else if (A[i] == A[i - 1] + 1) {
				if (!flag) {
					pointIndex = i;
					firstLenth = count;
					count++;
					flag = true;
				} else {
					res = res > count ? res : count;
					count -= firstLenth;
					firstLenth = i - pointIndex;
					pointIndex = i;
					flag = false;
				}
			} else {
				res = res > count ? res : count;
				firstLenth = 0;
				flag = false;
				pointIndex = i;
				count = 1;
			}
		}
		res = res > count ? res : count;
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 2,2, 3, 4, 4, 4, 4, 4, 5, 5, 6 };
		System.out.println(solution(A));
	}
}
