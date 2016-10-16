package google;

/*Input: 一个int数组
Output: 找到任意一个数，它的【左边所有数之和】和【右边所有数之和】相等。
比如 [1, 2, 3, 5, 1, 2, 3]，符合要求的是5，返回5的角标3。
*/
public class BalanceNumber {
	public static int solution(int[] x) {
		int left = 0, right = 0;
		for (int i = 1; i < x.length; i++) {
			right += x[i];
		}
		if (right == 0)
			return 0;
		for (int i = 1; i < x.length; i++) {
			right -= x[i];
			left += x[i - 1];
			if (right == left)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		int x[] = { 1, 2, 3, 5, 1, 2, 3 };
		int xx[] = { 1, 0, 0, 0, 0, 0, 0 };
		System.out.println(solution(x));
	}
}
