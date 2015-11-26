package zenefits;
/* You have a set of String {"a", "b", "ba", "bca", "bda", "bcda"};
 * Each time delete one charater in the String , if the new String is still in the array, keep doing delete until just one charater.
 * This will form a chain of deleting. 
 * For exmaple: bcda->bca->ba->a, the length of chain is 4.
 * Output the length of longest chain that can from in the set.
 */
import java.util.HashSet;

public class LongestChain {
	public static int longestChain(String[] strs) {
		if (strs.length == 0 || strs == null)
			return 0;
		HashSet<String> set = new HashSet<>();
		for (String str : strs)
			set.add(str);
		int res = 0;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() > res) {
				res = Math.max(res, getlongestchain(set, strs[i], 1));
			}
		}
		return res;
	}

	private static int getlongestchain(HashSet<String> set, String string, int count) {
		int res=count;
		for (int i = 0; i < string.length(); i++) {
			String nextString = string.substring(0, i) + string.substring(i + 1);
			if (set.contains(nextString))
				res = Math.max(count, getlongestchain(set, nextString, count + 1));
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strs = { "a", "b", "ba", "bca", "bda", "bcda" };
		System.out.println(longestChain(strs));
	}

}
