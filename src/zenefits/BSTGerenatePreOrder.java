package zenefits;

import java.util.Stack;

public class BSTGerenatePreOrder {
	public static boolean canGeneratePreOrderBST(int[] num) {
		Stack<Integer> stack = new Stack<Integer>();
		int leftmost = Integer.MIN_VALUE;
		for (int i = 0; i < num.length; i++) {
			if (num[i] < leftmost) {
				return false;
			} else if (num[i] > leftmost) {
				while (!stack.isEmpty()) {
					if (num[i] == stack.peek())
						return false;
					if (num[i] < stack.peek()) {
						stack.push(num[i]);
						break;
					} else {
						leftmost = stack.pop();
						stack.push(num[i]);
					}
				}
			} else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] num = { 100, 90, 80, 95, 99, 120,98, 115 };
		System.out.print(canGeneratePreOrderBST(num));
		
	}
}
