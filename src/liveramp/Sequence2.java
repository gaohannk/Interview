package liveramp;

import java.util.Arrays;

public class Sequence2 {
	public static int solution(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		Arrays.sort(A);
		int res = 1;
		int firstLength = 0;
		int pointIndex = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[i - 1]) {
				continue;
			} else {
				res = Math.max(res, i - pointIndex + firstLength);
				firstLength = A[i] - A[i - 1] == 1 ? i - pointIndex : 0;
				pointIndex = i;
			}
		}
		res = Math.max(res, A.length - pointIndex + firstLength);
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 2, 2, 3, 4, 4, 4, 4, 4, 5, 5, 6 };
		System.out.println(solution(A));
	}
}
