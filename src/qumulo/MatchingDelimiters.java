package qumulo;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/* The input consists of a single, non-empty line of text, consisting only of the characters 
 * ( ) { } [ ] < > and The program should print "true" if the delimiters are matched and properly nested or "false" otherwise. 
 * For example, these strings are balanced and properly matched and should print "true":
 * {}{}{}
 * [{<()>()}]
 * The input has proper count of delimiters, but they are not properly matched so the output should be false.
 * [{]}
 * The input does not have approporiate number of braces and should also return false.
 * {{{}}
 * The input string will be no longer than 1000 characters, including the terminating newline character
 */
public class MatchingDelimiters {

	public boolean isMatchingDelimiters() {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		if (s.length() % 2 == 1)
			return false;
		HashMap<Character, Character> map = new HashMap<>();
		Stack<Character> stack = new Stack<Character>();
		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');
		map.put('<', '>');
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i)))
				stack.push(s.charAt(i));
			else {
				if (stack.isEmpty())
					return false;
				char ch = stack.pop();
				if (map.get(ch) != s.charAt(i))
					return false;
			}
		}
		return stack.isEmpty();
	}
}
