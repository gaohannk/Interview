package zenefits;

import java.util.Arrays;

public class RotateArray {

	public static void rotate(int[] nums, int k) {
		int len = nums.length;
		Reverse(nums, 0, len - k - 1);
		Reverse(nums, len - k, len - 1);
		Reverse(nums, 0, len - 1);
	}

	// we first define the basic swap function
	public static void swap(int[] num, int a, int b) {
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}

	public static void Reverse(int[] num, int start, int end) {
		for (int i = start; i <= (start + end) / 2; i++) {
			swap(num, i, end + start - i);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}

}
