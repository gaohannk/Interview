package microsoft;

import java.util.Stack;

public class StackWithGetmax {
	public static int getMax(Stack<Integer> stack) {
		int max = Integer.MIN_VALUE;
		Stack<Integer> temp = new Stack<Integer>();
		while (!stack.isEmpty()) {
			if (stack.peek() > max)
				max = stack.peek();
			temp.add(stack.pop());
		}
		while (!temp.isEmpty()) {
			if (temp.peek() != max)
				stack.add(temp.pop());
		}
		return max;
	}
}
