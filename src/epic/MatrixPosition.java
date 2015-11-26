package epic;

/* Given an NxN matrix with unique integers: Find and print positions of all numbers 
 * such that it is the biggest in its row and also the smallest in its column. 
 * e.g. : In 3 x 3 with elements 
 * 1 2 3 
 * 4 5 6 
 * 7 8 9 
 * the number is 3 and position (1,3)
 */
public class MatrixPosition {
	public static void findPosition(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			int yindex = 0;
			boolean flag = true;
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] > max) {
					max = matrix[i][j];
					yindex = j;
				}
			}
			for (int x = 0; x < matrix.length; x++) {
				if (max > matrix[x][yindex]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("(" + (i + 1) + "," + (yindex + 1) + ")");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[3][3];
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		findPosition(matrix);
	}
}
