package amazon;
/* 输入数组的数不重复
 * 
 */
import java.util.HashSet;
import java.util.Set;

public class TwoSumCount {
	public static int getTwoSumCount(int[] nums, int target) {
		if (nums == null || nums.length < 2)
			return 0;
		Set<Integer> set = new HashSet<Integer>();
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(target - nums[i]))
				count++;
			else
				set.add(nums[i]);
		}
		return count;
	}
}
