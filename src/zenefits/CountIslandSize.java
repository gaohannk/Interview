package zenefits;
/* 1 stand for island
 * 0 stand for sea
 * count each island size(number of connected 1)
 * Example:
 * Input:
 * [["1", "0", "0", "1"],
 *  ["1", "0", "0", "1"],
 *  ["1", "1", "0", "0"]]
 * Output:
 * [4, 2]
 * Input:
 * [["1", "1", "1", "0"],
 *  ["1", "0", "1", "0"],
 *  ["1", "1", "1", "0"]]
 * Output:
 * [8]
 */
import java.util.ArrayList;

public class CountIslandSize {

	public static ArrayList<Integer> countIslandSize(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;

		int[][] checker = new int[row][col];
		ArrayList<Integer> res = new ArrayList<Integer>();
		int[] count = new int[1];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] != 0)
					helper(matrix, checker, i, j, res, count);
			}
		}
		return res;

	}

	private static void helper(int[][] matrix, int[][] checker, int i, int j, ArrayList<Integer> res, int[] count) {
		int row = matrix.length;
		int col = matrix[0].length;
		if (checker[i][j] == 1 || matrix[i][j] == 0)
			return;
		checker[i][j] = 1;
		count[0]++;
		if (j + 1 < col && matrix[i][j + 1] == 1)
			helper(matrix, checker, i, j + 1, res, count);
		if (j - 1 >= 0 && matrix[i][j - 1] == 1)
			helper(matrix, checker, i, j - 1, res, count);
		if (i + 1 < row && matrix[i + 1][j] == 1)
			helper(matrix, checker, i + 1, j, res, count);
		if (i - 1 >= 0 && matrix[i - 1][j] == 1)
			helper(matrix, checker, i - 1, j, res, count);
		if (count[0] != 0) {
			res.add(count[0]);
			count[0] = 0;
		}
		return;
	}

	public static void main(String[] args) {
		 int[][] matrix = { { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 1, 1, 0, 0 } };
		//int[][] matrix = { { 1, 1, 1, 0 }, { 1, 0, 1, 0 }, { 1, 1, 1, 0 } };
		ArrayList<Integer> res = countIslandSize(matrix);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
