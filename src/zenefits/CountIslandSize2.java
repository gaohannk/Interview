package zenefits;

import java.util.ArrayList;

public class CountIslandSize2 {
	public static ArrayList<Integer> countIslandSize(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;

		int[][] checker = new int[row][col];
		ArrayList<Integer> res = new ArrayList<Integer>();
		int num = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] != 0 && checker[i][j] == 0) {
					num = helper(matrix, checker, i, j);
					if (num != 0)
						res.add(num);
				}
			}
		}
		return res;

	}

	private static int helper(int[][] matrix, int[][] checker, int i, int j) {
		int count = 0;
		int row = matrix.length;
		int col = matrix[0].length;
		if (checker[i][j] == 1 || matrix[i][j] == 0)
			return count;
		checker[i][j] = 1;
		count++;
		if (j + 1 < col && matrix[i][j + 1] == 1)
			count += helper(matrix, checker, i, j + 1);
		if (j - 1 >= 0 && matrix[i][j - 1] == 1)
			count += helper(matrix, checker, i, j - 1);
		if (i + 1 < row && matrix[i + 1][j] == 1)
			count += helper(matrix, checker, i + 1, j);
		if (i - 1 >= 0 && matrix[i - 1][j] == 1)
			count += helper(matrix, checker, i - 1, j);
		return count;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 1, 1, 0, 0 } };
		// int[][] matrix = { { 1, 1, 1, 0 }, { 1, 0, 1, 0 }, { 1, 1, 1, 0 } };
		ArrayList<Integer> res = countIslandSize(matrix);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
