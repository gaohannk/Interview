package microsoft;

public class CommonAncestorinBST2 {
	public static TreeNode commonAncestorinBST2(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null)
			return null;
		int left = node1.val;
		int right = node2.val;

		if (left > right) {
			int temp = left;
			left = right;
			right = temp;
		}
		if (root.val == left || root.val == right)
			return root;
		else if (root.val < left)
			return commonAncestorinBST2(root.right, node1, node2);
		else if (right < root.val)
			return commonAncestorinBST2(root.left, node1, node2);
		else
			return root;
	}
}
