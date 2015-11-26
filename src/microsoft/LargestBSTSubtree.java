package microsoft;

/* A naive approach is to reuse the solution from Determine if a Binary Tree is a Binary Search Tree.
 * Starting from the root, we process in the order of current node, left child, then right child. 
 * For each node, you would call isBST() to check if the current subtree is a BST. 
 * If it is, then we have found the largest BST subtree. 
 * If it is not, then we have to continue examining its left and right child. 
 * If only one of the subtrees is BST, then we can return that subtree.
 * However, if both left and right subtrees are BSTs, then we have to compare 
 * which subtree is larger (has more descendant nodes), then return the larger one.
 */
public class LargestBSTSubtree {
	public static TreeNode findLargestBST(TreeNode root) {
		if (isBST(root))
			return root;
		else {
			if (isBST(root.left) && isBST(root.right))
				if (getSize(root.left) < getSize(root.right))
					return root.left;
				else
					return root.right;
			else if (isBST(root.left) && !isBST(root.right))
				return root.left;
			else if (!isBST(root.left) && isBST(root.right))
				return root.right;
		}
		return null;
	}

	private static int getSize(TreeNode root) {
		if(root==null)
			return 0;
		return getSize(root.left)+getSize(root.right)+1;
	}

	private static boolean isBST(TreeNode root) {
		int min=Integer.MIN_VALUE;
		int max=Integer.MAX_VALUE;
		return helper(root,min,max);
	}

	private static boolean helper(TreeNode root, int min, int max) {
		if(root==null)
			return true;
		if(root.val>min&&root.val<max)
			return helper(root.left, min, root.val)&&helper(root.right, root.val, max);
		return false;
	}
}
