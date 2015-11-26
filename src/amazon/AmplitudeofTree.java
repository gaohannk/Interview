package amazon;
/* Given a tree of N nodes, return the amplitude of the tree.
 */
public class AmplitudeofTree {
	public int getAmplitudeofTree(TreeNode root) {
		if (root == null)
			return 0;
		int min = 0;
		int max = Integer.MAX_VALUE;
		int amp = 0;
		dfs(root, min, max, amp);
		return amp;
	}

	private void dfs(TreeNode root, int min, int max, int amp) {
		if (root == null)
			return;
		min = Math.min(min, root.val);
		max = Math.max(max, root.val);
		if (root.left == null && root.right == null)
			amp = Math.max(amp, max - min);
		dfs(root.left, min, max, amp);
		dfs(root.right, min, max, amp);
	}
}
