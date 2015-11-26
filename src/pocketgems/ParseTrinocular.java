package pocketgems;

import java.util.ArrayList;
import java.util.Stack;

public class ParseTrinocular {
	static class TreeNode {
		char val;
		TreeNode left;
		TreeNode right;

		public TreeNode(char charAt) {
			this.val = charAt;
		}
	}

	public static TreeNode parseTrinocular(String str) {
		Stack<Character> stack = new Stack<Character>();
		if (str.length() == 0 || str == null)
			return null;
		TreeNode root = new TreeNode(str.charAt(0));
		String left = "", right = "";

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == '?')
				stack.push(str.charAt(i));
			else if (str.charAt(i) == ':') {
				stack.pop();
				if (stack.isEmpty()) {
					left = str.substring(2, i);
					right = str.substring(i + 1);
					break;        // don't forget: 找到和一个出现的？匹配的：
				}
			}
		}
		root.left = parseTrinocular(left);
		root.right = parseTrinocular(right);
		return root;
	}

	public static void inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return;
		helper(root, list);
	}

	public static void helper(TreeNode root, ArrayList<Integer> list) {
		if (root != null) {
			helper(root.left, list);
			System.out.println(root.val);
			helper(root.right, list);
		}
	}

	public static void main(String[] args) {
		String str = "a?b:c?d?e:f:g?h:i";
		TreeNode root = parseTrinocular(str);
		inorderTraversal(root);
	}
}
