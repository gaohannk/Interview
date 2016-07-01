package liveramp;

public class Solution {
	public static int solution(int[] A, int D) {
		if (D > A.length)
			return 0;
		for (int time = A.length / D; time <= A.length - D + 1; time++) {
			boolean isBreak = false;
			for (int i = D; i < A.length; i++) {
				if (A[i] <= time) {
					boolean flag = false;
					for (int j = 1; j <= D; j++) {
						if (A[i - j] <= time) {
							flag = true;
							break;
						}
					}
					if (flag == false) {
						isBreak = true;
						break;
					}
				}
			}
			if (!isBreak) {
				for (int j = 1; j <= D; j++) {
					if (A[A.length - j] <= time) {
						return time;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] A = { 1, -1, 0, 2, 3, 5, 8, 7 };
		int D = 3;
		System.out.println(solution(A, D));
	}
}
