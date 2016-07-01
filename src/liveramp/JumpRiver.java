package liveramp;

//DP solution
// index of A is position
//B[i] represent the earlist time to arrive position i
public class JumpRiver {
	public static int solution(int[] A, int D) {
		if (A == null || A.length == 0)
			return -1;
		if (D > A.length)
			return 0;
		int B[] = new int[A.length + 1];
		for (int i = 0; i < D; i++) {
			B[i] = A[i];
		}
		for (int i = D; i < A.length; i++) {
			if (A[i] == -1) {
				B[i] = -1;
			} else {
				int temp = Integer.MAX_VALUE;
				int count = 0;
				for (int j = 1; j <= D; j++) {
					if (B[i - j] == -1) {
						count++;
						continue;
					}
					temp = Math.min(temp, B[i - j]);
				}
				B[i] = count == D ? -1 : Math.max(temp, A[i]);
			}
		}
		int res = Integer.MAX_VALUE;
		int count = 0;
		for (int j = 1; j <= D; j++) {
			if (B[A.length - j] == -1) {
				count++;
				continue;
			}
			res = Math.min(res, B[A.length - j]);
		}
		return res = count == D ? -1 : res;
	}

	public static void main(String[] args) {
		//int[] A = { 1, -1, 4, 2, 3};
		int[] A = { 1,-1,-1,6,-1,3,7};
		int D = 3;
		System.out.println(solution(A, D));
	}
}
