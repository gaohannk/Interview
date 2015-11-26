package amazon;

public class WindowsSum {
	public static int[] windowsSum(int[] arg, int k) {
		int[] res = new int[arg.length - k + 1];
		for (int i = 0; i <= arg.length - k; i++) {
			for (int j = 0; j < k; j++) {
				res[i] += arg[i + j];
			}
		}
		return res;
	}

	public static void main(String[] arg) {
		int[] input = { 1, 2, 3, 4, 5 };
		int[] res = windowsSum(input, 2);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
