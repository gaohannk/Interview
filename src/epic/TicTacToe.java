package epic;

/* N*N matrix is given with input red or black. You can move horizontally, vertically or diagonally. 
 * If 3 consecutive same color found, that color will get 1 point. 
 * So if 4 consecutive same color found then pointis 2. 
 * Find the winner.
 */
public class TicTacToe {
	public static void main(String[] args) {

		char[][] matrix = { { 'r', 'r', 'r', 'b' }, { 'b', 'r', 'b', 'r' }, { 'b', 'r', 'r', 'b' },
				{ 'b', 'r', 'b', 'b' } };
		int red_count = findCount(matrix, 4, 4, 'r');
		int blue_count = findCount(matrix, 4, 4, 'b');
		System.out.println("Count of red triplets: " + red_count);
		System.out.println("Count of blue triplets: " + blue_count);
	}

	private static int findCount(char[][] matrix, int row, int col, char c) {
		int count = 0;
		// For all horizontal triplets.
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col - 3; j++) {
				if (matrix[i][j] == c && matrix[i][j + 1] == c && matrix[i][j + 2] == c && matrix[i][j + 3] == c) {
					count += 2;
					j = j + 3;
				}
				if (matrix[i][j] == c && matrix[i][j + 1] == c && matrix[i][j + 2] == c) {
					count++;
					j = j + 2;
				}
			}
		}

		// for all vertical triplet
		for (int j = 0; j < col; j++) {
			for (int i = 0; i < row - 3; i++) {
				if (matrix[i][j] == c && matrix[i + 1][j] == c && matrix[i + 2][j] == c && matrix[i + 3][j] == c) {
					count += 2;
					i = i + 3;
				}
				if (matrix[i][j] == c && matrix[i + 1][j] == c && matrix[i + 2][j] == c) {
					count++;
					i = i + 2;
				}
			}
		}
		// for all top down diagonal triplets
		for (int x = 0; x < row - 3; x++) {
			int k = x;
			for (int i = 0; i < row - 3; i++) {
				for (k = 0; k < col - 3; k++) {
					if (matrix[i][k] == c && matrix[i + 1][k + 1] == c && matrix[i + 2][k + 2] == c
							&& matrix[i + 3][k + 3] == c) {
						count += 2;
						k = k + 3;
						i = i + 3;
					}
					if (matrix[i][k] == c && matrix[i + 1][k + 1] == c && matrix[i + 2][k + 2] == c) {
						count++;
						k = k + 2;
						i = i + 2;
					}
				}
			}
		}
		for (int y = 0; y < col - 3; y++) {
			int i = y;
			for (i = y; i < row - 3; i++) {
				for (int k = 0; k < col - 3; k++) {
					if (matrix[i][k] == c && matrix[i + 1][k + 1] == c && matrix[i + 2][k + 2] == c
							&& matrix[i + 3][k + 3] == c) {
						count += 2;
						k = k + 3;
						i = i + 3;
					}
					if (matrix[i][k] == c && matrix[i + 1][k + 1] == c && matrix[i + 2][k + 2] == c) {
						count++;
						k = k + 2;
						i = i + 2;
					}
				}
			}
		}
		// for all bottom to top diagonal triples
		for (int i = row - 1; i > 1; i--) {
			for (int k = 0; k < col - 2; k++) {
				if (matrix[i][k] == c && matrix[i - 1][k + 1] == c && matrix[i - 2][k + 2] == c)
					count += 2;

			}
		}
		return count;
	}
}
