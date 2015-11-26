package epic;
/* Given a string that has {},[],(), and characters. Write a function to check if the string is balanced. 
 * E.g. {a[(b)]} is balanced. {a[(b])} isunbalanced.
 */

import java.util.HashMap;
import java.util.Stack;

public class BalancedString {
	public static void main(String[] args) {
		System.out.println(isBalanced("234(45[65[46{78}]])"));
	}

	public static boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<Character>();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		// if(str==null || str.length()%2!=0) return false;
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if (c == '(' || c == '[' || c == '{')
				stack.push(c);
			if (!stack.empty() && map.get(stack.peek()) == c) {
				stack.pop();
			}
		}
		return stack.empty();
	}

}
