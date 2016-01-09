package qumulo;

import java.util.Scanner;

/* To goal is to move a knight from one square of a chess board to another. 
 * The size of the board is provided, along with the starting position, the goal position, and a list of "blocked" squares 
 * where the knight cannot land. Th« program needs to print the minimum number of moves required for the knight to get to the 
 * goal square from the starting square, without falling off of the board or landing on a blocked square. 
 * The knight will always start on a square different than the goal, and it will always be possible for the knight to get to the goal square.
 * The input file consists of four or more lines of text. 
 * The first line is the length and width of the chess board, printed in ASCII, separated by a space. 
 * The next two lines consists of the starting and goal coordinates for the knight, with a zero-based numbering scheme. 
 * That is. if the board is 5x6, the four comers of the board are squares (0,0), (0,5), (4,5), and (4,0). 
 * These input lines have the format of the two coordinates, printed in ASCII, separated 1^ a space. 
 * The fourth line is a single, natural number that indicates how many squares are blocked. 
 * After that, there is one line per blocked square, using the same two-coordinate notation.
 * For example, this input fil« describes a 4x8 board, with the knight starting in one comer, 
 * the goal being the opposite coner, and with no blocked squares:
 * 4 8
 * 0 0
 * 3 7
 * 0
 */
public class KnightAdventure {

	public static int getMinStepinKnightAdventure() {
		Scanner in = new Scanner(System.in);
		try {
			String str = in.nextLine();
			String[] strs = str.split(" ");
			int row = Integer.parseInt(strs[0]);
			int col = Integer.parseInt(strs[1]);
			int[][] board = new int[row][col];
			str = in.nextLine();
			strs = str.split(" ");
			int startx = Integer.parseInt(strs[0]);
			int starty = Integer.parseInt(strs[1]);
			str = in.nextLine();
			strs = str.split(" ");
			int endx = Integer.parseInt(strs[0]);
			int endy = Integer.parseInt(strs[1]);
			str = in.nextLine();
			int num = Integer.parseInt(str);
			board[endx][endy] = 1;
			while (num > 0) {
				str = in.nextLine();
				strs = str.split(" ");
				int x = Integer.parseInt(strs[0]);
				int y = Integer.parseInt(strs[1]);
				board[x][y] = -1;
				num--;
			}
			int isvisited[][] = new int[row][col];
			int step = 0;
			int max[] = { Integer.MAX_VALUE };
			dfs(board, startx, starty, isvisited, step, max);
			return max[0];
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		return 0;
	}

	private static void dfs(int[][] board, int i, int j, int[][] isvisited, int step, int[] max) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return;
		if (isvisited[i][j] == 1 || board[i][j] == -1)
			return;

		if (board[i][j] == 1) {
			max[0] = max[0] < step ? max[0] : step;
			return;
		}

		int dx[] = { 1, 1, 2, 2, -1, -1, -2, -2 };
		int dy[] = { 2, -2, 1, -1, 2, -2, 1, -2 };
		for (int k = 0; k < 8; k++) {
			isvisited[i][j] = 1;
			// System.out.println(step);
			dfs(board, i + dx[k], j + dy[k], isvisited, step + 1, max);
			isvisited[i][j] = 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(getMinStepinKnightAdventure());
	}

}
