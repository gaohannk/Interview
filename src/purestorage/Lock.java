package purestorage;

import java.util.HashSet;
import java.util.Stack;

public class Lock {

	static int check_log_history(String[] events) {
		HashSet<Integer> set = new HashSet<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < events.length; i++) {
			String[] split = events[i].split(" ");
			int num = Integer.parseInt(split[1]);
			if (split[0].equals("ACQUIRE")) {
				if (set.contains(num))
					return i + 1;
				else {
					set.add(num);
					stack.push(num);
				}
			} else {
				if (stack.peek() == num) {
					stack.pop();
					set.remove(num);
					continue;
				} else {
					return i + 1;
				}
			}
		}
		if (set.isEmpty())
			return 0;
		else
			return events.length;
	}
}
