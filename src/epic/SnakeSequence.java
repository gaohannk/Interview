package epic;

/* You are given a grid of numbers. 
 * A snakesequence is made up of adjacent numbers such that for each number, 
 * the number on the right or the number below it is +1 or -1 its value. For example, 
 *  1  3  2  6  8 
 * -9  7  1 -1  2 
 *  1  5  0  1  9 
 *  In this grid, (3, 2, 1, 0, 1) is a snake sequence. 
 *  Given a grid, find thelongest snake sequences and their lengths.
 *  There can be multiple snake sequences with the maximum length.
 */
/* dp[i][j]: ending with (i,j) snake sequence
 */
public class SnakeSequence {
	public static int findSnakeSequence(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 1;
		}
		int m = matrix.length;
		int n = matrix.length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = 1;
			}
		}
		int longest = 0;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i < m - 1 && Math.abs(matrix[i][j] - matrix[i + 1][j]) == 1) {
					dp[i][j] = Math.max(dp[i][j], dp[i + 1][j] + 1);
				}
				if (j < n - 1 && Math.abs(matrix[i][j] - matrix[i][j + 1]) == 1) {
					dp[i][j] = Math.max(dp[i][j], dp[i][j + 1] + 1);
				}
				longest = Math.max(longest, dp[i][j]);
			}
		}
		return longest;
	}
}
