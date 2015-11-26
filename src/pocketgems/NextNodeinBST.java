package pocketgems;

public class NextNodeinBST {
	public static TreeNode findNextNodeinBST(TreeNode node) {
		if(node ==null)
			return null;
		TreeNode cur;
		if (node.right != null) {
			cur = node.right;
			if (cur.left == null)
				return cur;
			else {
				while (cur.left != null) {
					cur = cur.left;
				}
				return cur;
			}
		} else {
			cur = node;
			TreeNode p= node.parent;
			while (p != null && cur != p.left) {
				cur=p;
				p=p.parent;
			}
			return p;
		}
	}
	
	public static void main(String[] args) {
          TreeNode root = new TreeNode(20);
          root.left=new TreeNode(15);
          root.left.parent=root;
          root.right=new TreeNode(30);
          root.right.parent=root;
          root.left.left=new TreeNode(10);
          root.left.left.parent=root.left;
          root.right.left=new TreeNode(25);
          root.right.left.parent=root.right;
          root.left.right=new TreeNode(18);
          root.left.right.parent=root.left;
          root.right.right=new TreeNode(40);
          root.right.right.parent=root.right;
          System.out.println(findNextNodeinBST(root.left.right).val);

	}
}
