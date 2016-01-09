package google;

import java.util.HashSet;

/* Given 2 int arrays A and B. Find elems in A that are not in B.
 * 
 */
public class FindElementinAnotinB {

	public HashSet<Integer> findElementinAnotinB(int[] A, int[] B) {
		HashSet<Integer> res = new HashSet<>();
		HashSet<Integer> bset = new HashSet<>();

		for (int i = 0; i < B.length; i++) {
			bset.add(B[i]);
		}
		for (int i = 0; i < A.length; i++) {
			if (!bset.contains(A[i]))
				res.add(A[i]);
		}
		return res;
	}
}
