package epic;

/* Write a program to add the substring.
 * E.g. you have a list {1,7,6,3,5,8,9} and user is entering a sum 16. 
 * The output should display (2-4) that is {7,6,3} because 7+6+3 = 16;
 */

public class SubstringAddition {

	public static void main(String[] args) {
		int[] n = { 1, 7, 6, 3, 5, 8, 9 };
		System.out.println(TargetinSubstring(n, 16));
	}

	static String TargetinSubstring(int[] n, int target) {
		String res = "";
		if (n.length < 1 || n == null)
			return res;
		int start = 0;
		int sum = 0;
		for (int i = 0; i < n.length; i++) {
			if (sum + n[i] < target)
				sum += n[i];
			else if (sum + n[i] > target) {
				sum += n[i];
				while (sum > target) {
					sum -= n[start];
					start++;
					if (sum == target) {
						res = "(" + start + "-" + i + ")";
						return res;
					}

				}
			} else if (sum + n[i] == target) {
				res = "(" + start + "-" + i + ")";
				return res;
			}
		}
		return res;
	}
}
