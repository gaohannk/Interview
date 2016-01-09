package amazon;
/* Given a BST, transform it into greater sum tree where each node contains sum of all nodes greater than that node.
 *         50
           /      \
         30        70
        /   \      /  \
      20    40    60   80 

* The above tree should be modified to following 

              260
           /      \
         330        150
        /   \       /  \
      350   300    210   80

 */
/* Method 2 (Using only one traversal)
 * By leveraging the fact that the tree is a BST, we can find an O(n) solution. 
 * The idea is to traverse BST in reverse inorder. 
 * Reverse inorder traversal of a BST gives us keys in decreasing order. 
 * Before visiting a node, we visit all greater nodes of that node. 
 * While traversing we keep track of sum of keys which is the sum of all the keys greater than the key of current node.
 */
public class GreaterSumTree {

	public static void addValue(TreeNode root){
		 if(root==null)
			 return;
		 helper(root,0);
	}

	private static void helper(TreeNode root,int sum) {
		if(root!=null){
			helper(root.right,sum);
			sum+=root.val;
			root.val=sum;
			helper(root.left,sum);
		}
	}
	public static void main(String[] args){
		TreeNode root= new TreeNode(20);
		root.left= new TreeNode(10);
		root.right=new TreeNode(30);
		root.right.left=new TreeNode(25);
		root.right.right= new TreeNode(35);
		System.out.println("  "+root.val);
		System.out.println(root.left.val);
		System.out.println("   "+root.right.val);
		System.out.println("  "+root.right.left.val);
		System.out.println("          "+root.right.right.val);
		
		addValue(root);
		System.out.println("  "+root.val);
		System.out.println(root.left.val);
		System.out.println("   "+root.right.val);
		System.out.println("  "+root.right.left.val);
		System.out.println("          "+root.right.right.val);

	}
}
