package google;

/* 给出一个array A，比如[4, 1, 5, 3, 2],  求出A[i] 之后比A[i] 更小的个数，得到新的Array C, 返回C的最大值！
 * 
 */
public class MaxLessThanCurrentinArray {
	class TreeNode {
		public TreeNode(int val) {
			this.value = val;
		}

		TreeNode left;
		TreeNode right;
		int count;
		int value;
	}

	public int getMax(int[] nums) {
		TreeNode root = new TreeNode(nums[nums.length - 1]);
		root.count = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < root.value) {
				root.left = new TreeNode(nums[i]);
				root.left.count = 0;
			} else {
				root.right = new TreeNode(nums[i]);
				root.right.count += root.count;
			}

		}
	}
}
