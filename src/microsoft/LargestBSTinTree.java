package microsoft;

public class LargestBSTinTree {
	public static TreeNode findLargestBST(TreeNode root) {
		TreeNode largestBST = null;
		TreeNode child = null;
		int maxnode = 0;
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		maxnode=findLargestBST(root, min, max, maxnode, largestBST, child);
		return largestBST;
	}

	private static int findLargestBST(TreeNode root, int min, int max, int maxnode, TreeNode largestBST, TreeNode child) {
		if (root == null)
			return 0;
		if (min < root.val && root.val < max) {
			int left = findLargestBST(root.left, min, root.val, maxnode, largestBST, child);
			TreeNode leftChild = (left == 0) ? null : child;
			int right = findLargestBST(root.right, root.val, max, maxnode, largestBST, child);
			TreeNode rightChild = (right == 0) ? null : child;
			TreeNode parent = new TreeNode(root.val);
			parent.left = leftChild;
			parent.right = rightChild;
			child = parent;
			int total = left + right + 1;
			if (total > maxnode) {
				maxnode = total;
				largestBST = parent;
			}
			return total;
		} else {
			maxnode=findLargestBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, maxnode, largestBST, child);
			return 0;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(5);
		root.left.right= new TreeNode(7);
		root.left.right.left= new TreeNode(2);
		root.left.right.right= new TreeNode(5);
		root.left.right.left.left= new TreeNode(0);
		root.left.right.left.right= new TreeNode(8);
		root.left.right.right.left= new TreeNode(3);
        System.out.println(findLargestBST(root));
	}
}
