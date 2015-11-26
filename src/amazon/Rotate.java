package amazon;

/*
 * 矩阵右转或左转90°
 */
public class Rotate {
	public static int[][] Solution(int[][] matrix, int flag) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return matrix;
		int m = matrix.length, n = matrix[0].length;
		int[][] res = new int[n][m];
		if (flag == 1) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					res[j][m - 1 - i] = matrix[i][j];
				}
			}
		} else {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					res[n - 1 - j][i] = matrix[i][j];
				}
			}
		}
		return res;
	}

	public static void print(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3, 4 }, { 4, 5, 6,6 }, { 7, 8, 9,7 } };
		print(matrix);
		int[][] res = Solution(matrix, 2);
		print(res);
	}
}
