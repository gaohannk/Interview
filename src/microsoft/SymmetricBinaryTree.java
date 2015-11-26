package microsoft;

import java.util.ArrayList;

public class SymmetricBinaryTree {
	public static boolean isSysmetric(TreeNode node) {
		if (node == null) {
			return true;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(node, list);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != list.get(list.size() - i))
				return false;
		}
		return true;
	}

	private static void helper(TreeNode node, ArrayList<Integer> list) {
		if (node != null) {
			helper(node.left, list);
			list.add(node.val);
			helper(node.right, list);
		}
		return;
	}
}
