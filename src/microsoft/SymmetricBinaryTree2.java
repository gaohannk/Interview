package microsoft;

import java.util.ArrayList;

public class SymmetricBinaryTree2 {
	public static boolean isSysmetric(TreeNode root) {
		if (root == null)
			return true;
		ArrayList<TreeNode> layer = new ArrayList<TreeNode>();
		layer.add(root);
		while (true) {
			if (layer.isEmpty())
				break;
			ArrayList<TreeNode> nextlayer = new ArrayList<TreeNode>();
			ArrayList<Integer> currlayer = new ArrayList<Integer>();
			for (TreeNode node : layer) {
				currlayer.add(node.val);
				if (node.left != null) {
					nextlayer.add(node.left);
				}
				if (node.right != null) {
					nextlayer.add(node.right);
				}
			}
			for (int i = 0; i < nextlayer.size(); i++) {
				if (nextlayer.get(i) != nextlayer.get(nextlayer.size() - i))
					return false;
			}
			layer = nextlayer;
		}
		return true;
	}
}
