package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* Find all numbers in a given array that occur odd number of times.
 * 
 */
public class FindNumberOddtimes2 {
	public static List<Integer> findnumberappearoddtimes(int[] nums) {

		List<Integer> res = new LinkedList<>();
		Arrays.sort(nums);
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1])
				count++;
			else {
				if (count % 2 == 1)
					res.add(nums[i - 1]);
				count = 1;
			}
		}
		if (count % 2 == 1) {
			res.add(nums[nums.length - 1]);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 3, 2, 1, 1, 6, 6, 6, 6, 6 };
		List<Integer> res = findnumberappearoddtimes(nums);
		for (int n : res)
			System.out.print(n + " ");
	}
}
