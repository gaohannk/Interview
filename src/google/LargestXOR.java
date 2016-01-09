package google;

import java.util.ArrayList;

/* Given an array of integers ,You have to find two elements whose XOR is maximum.
 * 
 */
public class LargestXOR {

	public static int findLargestXOR(int[] arr) {
		if (arr.length <= 2)
			return 0;
		TreeNode head = new TreeNode(-1);
		for (int i = 0; i < arr.length; i++) {
			buildTierTree(arr[i], head);
		}
		String res = "";
		int[] max = { 0 };
		if (head.left != null && head.right != null)
			helper(head.left, head.right, res, max);
		else if (head.left == null)
			helper(head.right, head.right, res, max);
		else if (head.right == null)
			helper(head.left, head.left, res, max);
		return max[0];
	}

	public static void buildTierTree(int num, TreeNode head) {
		int len = 31;
		TreeNode root = head;
		while (len-- > 0) {
			int n = num >> len & 1;
			if (n == 1) {
				if (root.right == null)
					root.right = new TreeNode(1);
				root = root.right;
			} else {
				if (root.left == null)
					root.left = new TreeNode(0);
				root = root.left;
			}
		}
	}

	private static void helper(TreeNode left, TreeNode right, String res, int[] max) {

		if (left.left != null && right.right != null) {
			res += "1";
			helper(left.left, right.right, res, max);
		} else if (left.right != null && right.left != null) {
			res += "1";
			helper(left.right, right.left, res, max);
		} else if (left.left != null && right.left != null) {
			if (res != "")
				res += "0";
			helper(left.left, right.left, res, max);
		} else if (left.right != null && right.right != null) {
			if (res != "")
				res += "0";
			helper(left.right, right.right, res, max);
		} else {
			if (Integer.valueOf(res, 2) > max[0]) {
				max[0] = Integer.valueOf(res, 2);
				//System.out.println(max[0]);
			}
			return;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 1, 4, 3, 0, 2 };
		System.out.println(findLargestXOR(arr));

	}

}
