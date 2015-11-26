package microsoft;

import java.util.ArrayList;

/* Method 1 (By Storing root to n1 and root to n2 paths):
 * Following is simple O(n) algorithm to find LCA of n1 and n2.
 * 1) Find path from root to n1 and store it in a vector or array.
 * 2) Find path from root to n2 and store it in another vector or array.
 * 3) Traverse both paths till the values in arrays are same. Return the common element just before the mismatch.
 */
public class CommonAncestorinBT2 {
	public static TreeNode commonAncestorinBT2(TreeNode root, TreeNode node1, TreeNode node2) {
		ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();
		findPath(root, node1, path1);
		findPath(root, node2, path2);
		TreeNode res = null;
		int size1 = path1.size();
		int size2 = path2.size();
		int size = Math.min(size1, size2);
		for (int i = 0; i < size; i++) {
			if (path1.get(i).val == path2.get(i).val)
				res = path1.get(i);
			else
				return res;
		}
		return path1.get(size - 1);
	}

	private static void findPath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
		if (root == null)
			return;
		path.add(root);
		if (root.left != null)
			findPath(root.left, node, path);
		if (root.right != null)
			findPath(root.right, node, path);
		path.remove(root);
		return;
	}

	public static void main(String[] args) {

	}
}
