package microsoft;

public class BalancedTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		boolean left = isBalanced(root.left);
		boolean right = isBalanced(root.right);
		if (left && right && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1)
			return true;
		return false;
	}

	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		return Math.max(left, right) + 1;

	}
}
