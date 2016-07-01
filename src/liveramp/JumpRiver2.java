package liveramp;

import java.util.Arrays;
import java.util.HashMap;

// O(max(A)) solution
// f: A[i]=k
public class JumpRiver2 {
	public static class Range {
		int min;
		int max;

		Range(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

	public static int solution(int[] A, int D) {
		if (A == null || A.length == 0)
			return -1;
		if (D > A.length)
			return 0;
		int maxA = 0;
		// O(N) N is the length of array A. find the max time in A
		for (int i = 0; i < A.length; i++) {
			if (A[i] > maxA)
				maxA = A[i];
		}
		// Exchange the value and index of A
		int[] B = new int[maxA + 1];
		Arrays.fill(B, -1);
		for (int i = 0; i < A.length; i++) {
			if (A[i] == -1)
				continue;
			else
				B[A[i]] = i;
		}
		//System.out.println();
		HashMap<Integer, Range> map = new HashMap<>();
		int totalBin = (int) Math.ceil((double) A.length / (double) D);
		// System.out.println(totalBin);
		int connectionNeed = totalBin;
		boolean connected[] = new boolean[totalBin];
		int count = 0;
		boolean flag=false;
		for (int i = 0; i < B.length; i++) {
			if (B[i] == -1)
				continue;
			int binNum = B[i] / D;
			if (!map.containsKey(binNum))
				map.put(binNum, new Range(B[i] - D, B[i] + D));
			else {
				map.get(binNum).max = Math.max(map.get(binNum).max, B[i] + D);
				map.get(binNum).min = Math.max(map.get(binNum).min, B[i] - D);
			}
			if (binNum == totalBin - 2 && map.get(binNum).max >= A.length&& flag==false) {
				//System.out.println(i+" "+count);
				count++;
				flag=true;
				connectionNeed--;
			}
			if (binNum == totalBin - 1)
				count++;
			if (map.containsKey(binNum + 1)) {
				if (!connected[binNum] && map.get(binNum + 1).min <= B[i]) {
					connected[binNum] = true;
					count++;
				}
			}
			if (map.containsKey(binNum - 1)) {
				if (!connected[binNum - 1] && map.get(binNum - 1).max >= B[i]) {
					connected[binNum - 1] = true;
					count++;
				}
			}
			//System.out.println(i+" "+count);
			if (count == connectionNeed) {
				return i;
			}
		}
		return -1;
	}
	// 0 1 2 |3 4 5| 6|7
	// 0 1 2 | 3 4 |5
	// 0 1 2 | 3 4 5|6,7，8|9
	public static void main(String[] args) {
		// int[] A = { 2, 3, 1, 6, 7, 4, 5 };
		//int[] A = { 1, -1, 2, 4, 3 };
		// int[] A = { 1, -1, 2, 4, 3, 5, 6,7,0 };
		int[] A = { 1,-1,-1,6,-1,3,7};
		int D = 3;
		System.out.println(solution(A, D));
	}
}
