package epic;

/* Given a NXN matrix,starting from the upper right corner of the matrix start printing values 
 * in a counter-clockwise fashion. 
 * E.g.: Consider N = 4 
 * Matrix= {a, b, c, d, 
 *          e, f, g, h, 
 *          i, j, k, l, 
 *          m, n, o, p} 
 * Your function should output: dcbaeimnoplhgfjk
 */
public class SpiralMatrix {
	public static String printSpiralOrder(char[][] matrix) {
		StringBuilder res = new StringBuilder("");
		if (matrix == null || matrix.length == 0)
			return res.toString();
		int startx = 0, endx = matrix.length - 1;
		int starty = 0, endy = matrix[0].length - 1;
		while (startx <= endx && starty <= endy) {
			for (int i = endy; i >= starty; i--)
				res.append(matrix[startx][i]);
			for (int i = startx + 1; i <= endx; i++)
				res.append(matrix[i][starty]);
			if (startx != endx) {
				for (int i = starty + 1; i <= endy; i++)
					res.append(matrix[endx][i]);

			}
			if (starty != endy) {
				for (int i = endx - 1; i > startx; i--)
					res.append(matrix[i][endy]);
			}
			startx++;
			endx--;
			starty++;
			endy--;
		}
		return res.toString();
	}

	public static void main(String[] args) {
		char[][] matrix = { { 'a', 'b', 'c', 'd' }, { 'e', 'f', 'g', 'h' }, { 'i', 'g', 'k', 'l' },
				{ 'm', 'n', 'o', 'p' } };

		System.out.println(printSpiralOrder(matrix));
	}

}
