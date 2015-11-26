package amazon;

import java.util.Stack;

public class isValid {
	public boolean isValidParentheses(String s) {
		if (s == null || s.length() == 0)	return true;
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			if (stack.empty())	stack.push(s.charAt(i));
			else if (s.charAt(i) - stack.peek() == 1 || s.charAt(i) - stack.peek() == 2)	stack.pop();
			else	stack.push(s.charAt(i));
		}
		
		return stack.empty();
	}
}
