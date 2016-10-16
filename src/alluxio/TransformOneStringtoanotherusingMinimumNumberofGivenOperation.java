package alluxio;

import java.util.HashMap;
import java.util.Set;

/**
 * Given two strings A and B, the task is to convert A to B if possible. The only operation allowed is to put any character from A and insert it at front. Find if it’s possible to convert the string. If yes, then output minimum no. of operations required for transformation.
 * <p>
 * Input:  A = "ABD", B = "BAD"
 * Output: 1
 * Explanation: Pick B and insert it at front.
 * <p>
 * Input:  A = "EACBD", B = "EABCD"
 * Output: 3
 * Explanation: Pick B and insert at front, EACBD => BEACD
 * Pick A and insert at front, BEACD => ABECD
 * Pick E and insert at front, ABECD => EABCD
 */
public class TransformOneStringtoanotherusingMinimumNumberofGivenOperation {
    public boolean canTransform(String A, String B) {
        if (A == null && B == null)
            return true;
        if (A == null || B == null)
            return false;
        if (A.length() != B.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            if (map.containsKey(A.charAt(i))) {
                map.put(A.charAt(i), map.get(A.charAt(i) + 1));
            } else {
                map.put(A.charAt(i), 1);
            }
        }
        for (int i = 0; i < B.length(); i++) {
            if (!map.containsKey(B.charAt(i)))
                return false;
            else {
                map.put(B.charAt(i), map.get(B.charAt(i) - 1));
            }
        }
        Set<Character> set = map.keySet();
        for (char c : set) {
            if (map.get(c) != 0)
                return false;
        }
        return true;
    }

    public int numOfOperation(String A, String B) {
        if (!canTransform(A, B))
            return 0;
        int count = 0;
        for (int i = A.length() - 1, j = B.length() - 1; i >= 0; i--) { //i==-1
            if (A.charAt(i) == B.charAt(j)) {
                continue;
            } else {
                while (i >= 0 && A.charAt(i) != B.charAt(j)) {
                    count++; //1
                    i--; //0
                }
                if (i >= 0) {
                    // i =0
                    j--; // j=0
                }
            }
        }
        return count;
    }
}
