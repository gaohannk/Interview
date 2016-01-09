package google;

import java.util.HashMap;
import java.util.HashSet;

/* Given a large set of "transactions" of the form
 * A pays B,  B pays C, B pays D, ..., W pays X, Y pays C, X pays B
 * write code to determine if anyone who has paid money has some of that money coming back.
 * How would you represent this data. Discuss space complexity.
 * How would you solve the problem. Discuss time complexity..
 * N people
 * T transactions
 */

public class DetectCyclePay {
	public static boolean hasCyclePay(int N, char[][] trans) {
		// 0 for white, unvisited
		// 1 for grey, in stack
		// 2 for black, fully explored
		int[] status = new int[N];
		for (int i = 0; i < N; i++) {
			if (status[i] == 0) {
				if (DFS(i, trans, status)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean DFS(int curr, char[][] trans, int[] status) {
		if (status[curr] == 1) {
			return true;
		}
		status[curr] = 1;
		for (char[] p : trans) {
			if ((p[0] - 'A') == curr && status[p[1] - 'A'] != 2) {
				if (DFS(p[1] - 'A', trans, status)) {
					return true;
				}
			}
		}
		status[curr] = 2;
		return false;
	}

	public static void main(String[] args) {
		char[][] trans = { { 'A', 'B' }, { 'B', 'C' }, { 'C', 'D' }, { 'B', 'E' }, { 'C', 'A' } };
		int N = 5;
		System.out.println(hasCyclePay(N, trans));
	}
}
