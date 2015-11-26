package zenefits;

/* The input is the column number of queen in the order of each row.
 * The output is the highest number of Threat to others in each queen. 
 * Note that the queen can other threat the adjacent queen close to itself.
 */
public class NQueens {
	public static int highestNumberofThreat(int[] queen) {
		if (queen == null || queen.length == 0)
			return 0;
		int max = 0;
		for (int i = 0; i < queen.length; i++) {
			int[] temp = new int[6];
			for (int j = 0; j < i; j++) {
				if (queen[j] == queen[i])
					temp[0] = 1;
				if (queen[j] - queen[i] == i - j)
					temp[1] = 1;
				if (queen[j] - queen[i] == j - i)
					temp[2] = 1;
			}
			for (int j = i + 1; j < queen.length; j++) {
				if (queen[j] == queen[i])
					temp[3] = 1;
				if (queen[j] - queen[i] == i - j)
					temp[4] = 1;
				if (queen[j] - queen[i] == j - i)
					temp[5] = 1;
			}
			int res = 0;
			for (int j = 0; j < temp.length; j++) 
				res += temp[j];
			max = Math.max(max, res);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] queen = { 2, 3, 1 };
		System.out.println(highestNumberofThreat(queen));
	}
}
