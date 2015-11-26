package epic;

public class PascalTriangle {
	public static void PrintTriangle(int[] nums) {
		if (nums.length < 1 || nums == null)
			return;
		int[] uplevel = new int[nums.length - 1];
		for (int i = 0; i < nums.length - 1; i++) {
			uplevel[i] = nums[i] + nums[i + 1];
		}
		PrintTriangle(uplevel);
		System.out.print("{");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i < nums.length - 1)
				System.out.print(",");
		}
		System.out.println("}");
	}

	public static void main(String[] args) {
		int[] nums = { 4, 7, 3, 6, 7 };
		PrintTriangle(nums);
	}

}
