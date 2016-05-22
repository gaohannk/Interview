package snapchat;

import java.util.HashSet;

/* array里只有一个数字出现超过50%，其他数字都只有一次 return超过50%次的数字。
 * 譬如： ［1，2，3，4，1，1，5，1，1］ 除了 1别的数字都只出现了一次，而且1出现概率超过了50%， return 1
 * followup:  array里只有一个数字出现超过一次，其他数字都只有一次。return这个数字的出现概率。
 * 譬如： ［1，2，3，4，1，1，5］ 在这个数组里 1就不一定是出现概率超过50%的数了，求1的出现概率。
 */
public class NumAppearOnce {
	public int findAppearOnce(int nums[]) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return nums[i];
			else {
				set.add(nums[i]);
			}
		}
		return nums[nums.length - 1];
	}

	public double findAppearOnce2(int nums[]) {
		HashSet<Integer> set = new HashSet<>();
		int target = 0;
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				target = nums[i];
				break;
			} else
				set.add(nums[i]);
		}
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				count++;
			}
		}
		return (double) count / nums.length;
	}

}
