package amazon;
/* Given a list of integer and a window size ,return a new list of integers where each integer is the sum of all integers in the 
 * kth window of the input list. The kth window of input list is the Integers from index k to index k+window size-1(inclusive).
 * For example, [4, 2, 73, 11, -5] and window size is 2, return [6, 75, 84, 6].
 * [4, 2, 73, 11, -5] and window size is 3, return [79,86,79].
 */
public class WindowsSum2 {
	public static int[] windowsSum(int[] arg, int k) {
		if (arg == null || arg.length < k || k <= 0)
			return null;
		int[] res = new int[arg.length - k + 1];
		for (int i = 0; i < k; i++) {
			res[0] += arg[i];
		}
		for (int i = 1; i <= arg.length - k; i++) {
			res[i] = res[i - 1] - arg[i - 1] + arg[i - 1 + k];
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
