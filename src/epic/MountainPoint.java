package epic;

/* Given a M * N matrix, if the element in thematrix is larger than other 8 elements who stay around it, 
 * then named thatelement be mountain point. Print all the mountain points.
 * Don't need to consider edge and corner, there must be 8 elements around it.
 */
public class MountainPoint {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 2, 6, 8 }, { -9, 7, 11, 12, 2 }, { 1, 5, 10, 1, 9 } };
		isMountain(matrix);
	}

	static void isMountain(int[][] matrix) {
		for (int i = 1; i < matrix.length - 1; i++) {
			for (int j = 1; j < matrix[0].length - 1; j++) {
				if (matrix[i][j] > matrix[i - 1][j - 1] && matrix[i][j] > matrix[i - 1][j]
						&& matrix[i][j] > matrix[i - 1][j + 1] && matrix[i][j] > matrix[i][j - 1]
						&& matrix[i][j] > matrix[i][j + 1] && matrix[i][j] > matrix[i + 1][j - 1]
						&& matrix[i][j] > matrix[i + 1][j] && matrix[i][j] > matrix[i + 1][j + 1]) {
					System.out.println(matrix[i][j]);
				}
			}
		}
	}
}
