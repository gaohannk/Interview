package bloomberg;

import java.util.Stack;

public class ReverseWordsinaString {
	public String reverseWords(String s) {
		Stack<String> stack = new Stack<String>();
		s.trim();
		int p = 0, q = 0;
		while (p < s.length()) {
			while (q < s.length() && s.charAt(q) == ' ')
				q++;
			p = q;
			while (q < s.length() && s.charAt(q) != ' ')
				q++;
			stack.push(s.substring(p, q));
			p = q;
		}

		StringBuffer buf = new StringBuffer();
		while (!stack.empty()) {
			String top = stack.pop();
			buf.append(top);
			buf.append(' ');
		}
		return buf.toString().trim();
	}
}
