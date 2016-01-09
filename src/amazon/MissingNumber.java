package amazon;

public class MissingNumber {
	public int missingNumber(int[] nums,int x) {
		int sum = (x +x+nums.length) * (nums.length+1) / 2;
		for (int i = 0; i < nums.length; i++) {
			sum -= nums[i];
		}
		return sum;
	}

}
