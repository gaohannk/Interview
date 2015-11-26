package amazon;

/* 一个数的两边一样，此数为0，否则为1
 * cells: [1, 0, 0, 0, 0, 1, 0, 0]
days: 1
[0, 1, 0, 0, 1, 0, 1, 0]
days: 2
[1, 0, 1, 0, 0, 0, 0, 1]
*/

public class DaysChange {
	public int[] Solution(int[] days, int n) {
		if (days == null || n <= 0)
			return days;
		int length = days.length;
		int res[] = new int[length];
		for (int i = 0; i < n; i++) {
			res[0] = 0 ^ days[1];
			for (int j = 1; j < length - 1; j++) {
				res[j] = days[j - 1] ^ days[j + 1];
			}
			res[length - 1] = days[length - 2] ^ 0;
		}
		return res;
	}
}
