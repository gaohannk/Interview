package amazon;

public class MinimumSumPath {
	public int getMinimumSumPath(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right != null)
			return getMinimumSumPath(root.right);
		if (root.left != null && root.right == null)
			return getMinimumSumPath(root.left);
		return Math.min(getMinimumSumPath(root.left), getMinimumSumPath(root.right)) + root.val;

	}
}
