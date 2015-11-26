package epic;

/* Write a program for a word search. 
 * If thereis an NxN grid with one letter in each cell.
 * Let the user enter a word and the letters of the word are said to be found in the grid 
 * either the letters match vertically, horizontally or diagonally in the grid. 
 * If the word is found, print the coordinates of the letters as output.
 */
public class WordSearch {
	public static boolean SearchWord(String word, char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return false;
		if (word.length() == 0)
			return true;
		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				boolean res_ver = true, res_hor = true, res_diag = true;
				for (int k = 0; k < word.length(); k++) {
					if (i + k < row && board[i + k][j] != word.charAt(k)) {
						res_ver = false;
						break;
					}
				}
				for (int k = 0; k < word.length(); k++) {
					if (j + k < col && board[i][j + k] != word.charAt(k)) {
						res_hor = false;
						break;
					}
				}
				for (int k = 0; k < word.length(); k++) {
					if (i + k < row && j + k < col && board[i + k][j + k] != word.charAt(k)) {
						res_diag = false;
						break;
					}
				}
				if (res_ver || res_hor || res_diag) {
					int index = 0;
					if (res_ver)
						index = 1;
					if (res_hor)
						index = 2;
					if (res_diag)
						index = 3;
					PrintCoordinate(index, i, j, word.length());
					return true;
				}

			}
		}
		return false;
	}

	private static void PrintCoordinate(int index, int i, int j, int length) {
		if (index == 1)
			for (int k = 0; k < length; i++) {
				int x=i+k;
				int y=j;
				System.out.print('('+x + "," + y+')');
			}
		else if(index ==2){
			for (int k = 0; k < length; i++) {
				int x=i;
				int y=j+k;
				System.out.print('('+x + "," + y+')');
			}
		}else if(index==3){
			for (int k = 0; k < length; i++) {
				int x=i+k;
				int y=j+k;
				System.out.print('('+ x + "," + y+')');
			}
		}
	}
}
