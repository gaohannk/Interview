package pocketgems;

public class CommonAncestorinBT {
	public static TreeNode commonAncestorinBT(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null)
			return null;
		if (root.val == node1.val || root.val == node2.val)
			return root;
		TreeNode left = commonAncestorinBT(root.left, node1, node2);
		TreeNode right = commonAncestorinBT(root.right, node1, node2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left != null && right != null)
			return root;

		// Otherwise check if left subtree or right subtree is LCA
		return (left != null) ? left : right;
	}
}
