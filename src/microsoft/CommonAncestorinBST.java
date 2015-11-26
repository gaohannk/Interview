package microsoft;

public class CommonAncestorinBST {
	public static TreeNode commonAncestorinBST(TreeNode root, TreeNode node1, TreeNode node2) {
		int left = node1.val;
		int right = node2.val;
		TreeNode parent = null;

		if (left > right) {
			int temp = left;
			left = right;
			right = temp;
		}

		while (true) {
			if (root.val < left) {
				parent = root;
				root = root.right;
			} else if (root.val > right) {
				parent = root;
				root = root.left;
			} else if (root.val == left || root.val == right) {
				return parent;
			} else {
				return root;
			}
		}
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(5);
		root.left.right= new TreeNode(7);
		root.left.right.left= new TreeNode(2);
		root.left.right.right= new TreeNode(5);
		root.left.right.left.left= new TreeNode(0);
		root.left.right.left.right= new TreeNode(8);
		root.left.right.right.left= new TreeNode(3);	}
}
