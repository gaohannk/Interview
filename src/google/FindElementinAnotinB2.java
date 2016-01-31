package google;

import java.util.Arrays;
import java.util.HashSet;

/* Given 2 int arrays A and B. Find elems in A that are not in B.
 * 
 */
public class FindElementinAnotinB2 {

	public static HashSet<Integer> findElementinAnotinB(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int p1 = 0, p2 = 0;
		HashSet<Integer> res = new HashSet<>();
		if (A.length == 0)
			return res;
		if (B.length == 0) {
			for (int i : A)
				res.add(i);
		}
		while (p1 < A.length && p2 < B.length) {
			if (A[p1] < B[p2]) {
				res.add(A[p1]);
				p1++;
			} else if (A[p1] > B[p2])
				p2++;
			else {
				p1++;
				p2++;
			}

		}
		// corner case
		if (p2 >= B.length)
			res.add(A[p1]);
		return res;
	}

	public static void main(String[] args) {

		int[] A = {1,2,3};
		int[] B = {};
		HashSet<Integer> res = findElementinAnotinB(A, B);
		for (int num : res)
			System.out.print(num + " ");
	}
}
