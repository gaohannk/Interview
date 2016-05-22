package fidessa;

import java.util.Stack;

/* Matching pairs 
 * You are given a String, input, comprised of alphabetical letters with varying case. 
 * These letters should create pairs with one another, based on case. For example, the letter 'N forms a "matching pair' with the letter 'a', in that order. 
 * Rules: 
 * 1. The first letter must be upper-case. 
 * 2. Every upper-case letter must be followed by its lower-case version or any upper-case letter. 
 * 3. When an upper-case letter is followed by its lower-case version, those two letters are considered a "matching pair and can then be disregarded from further match consideration.
 * 4. If any of these rules are broken or a lower-case letter is encountered that does not create a "matching pair' with its nearest un-matched left neighbour, that letter and all following letters are considered "un-matched". 
 * Output: Your method should return the zero-based index of the last matching lower-case letter, or -1 if no pairs exist. 
 * Limits: 0 < input length < 10,000 characters The optimal method has a running time of O(input length). 
 * Sample input #1 
 * ABba 
 * Sample output #1 
 * 3 
 */

public class MatchingPairs {
	public static int matchingpairs(String str) {
		if (!isUpperCase(str.charAt(0)) || str == null)
			return -1;
		Stack<Character> stack = new Stack<>();
		stack.push(str.charAt(0));
		int res = -1;
		for (int i = 1; i < str.length(); i++) {
			if (!isUpperCase(str.charAt(i))) {
				char ch = stack.peek();
				if (ch + 32 == str.charAt(i)) {
					stack.pop();
					res = i;
				} else
					return res;
			} else {
				stack.push(str.charAt(i));
			}
		}
		if (stack.isEmpty())
			return str.length() - 1;
		else
			return res;
	}

	private static boolean isUpperCase(char ch) {
		int pos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(ch);
		return pos >= 0;
	}

	public static void main(String args[]) {
		System.out.println(matchingpairs("YVvyGSAJjJjjaWwsg"));

	}
}
