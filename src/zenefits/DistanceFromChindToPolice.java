package zenefits;

/* 2是一面墙，表示此路不通。
 * 0表示小孩儿。
 * 1表示警察叔叔。
 * 求小孩儿到离他最近的那个警察叔叔的距离。 如果最终小孩儿碰不到警察叔叔，则距离为-1。
 * 注：墙到警察叔叔的距离无论如何都是-1，警察叔叔到自己的距离是0。
 Running case 1:
 [[0, 1, 0]]
 [[0, 2, 0]]
 [[0, 1, 0]]
 Result:
 [[1, 0, 1]]
 [[2, -1, 2]]
 [[1, 0, 1]]

 Running case 2:
 [[0, 2, 0]]
 [[0, 2, 0]]
 [[0, 2, 1]]
 Result:
 [[-1, -1, 2]]
 [[-1, -1, 1]]
 [[-1, -1, 0]]

 Running case 3:
 [[1, 0, 0]]
 [[0, 0, 0]]
 [[0, 0, 1]]
 Result:
 [[0, 1, 2]]
 [[1, 2, 1]]
 [[2, 1, 0]]
 */
import java.util.LinkedList;
import java.util.Queue;

public class DistanceFromChindToPolice {
	public static int[][] findDistance(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] res = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] != 2)
					res[i][j] = Integer.MAX_VALUE;
				else {
					res[i][j] = -1;
				}
			}
		}
		Queue<Position> queue = new LinkedList<Position>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
				int[][] checker = new int[row][col];
				queue.add(new Position(i, j, 0));
				helper(matrix, checker, res, queue);
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
			      if (res[i][j] == Integer.MAX_VALUE)
					res[i][j] = -1;
			}
		}
		return res;

	}

	private static void helper(int[][] matrix, int[][] checker, int[][] res, Queue<Position> queue) {
		int row = matrix.length;
		int col = matrix[0].length;
		while (!queue.isEmpty()) {
			Position p = queue.poll();
			if (checker[p.x][p.y] == 1)
				continue;
		
			checker[p.x][p.y] = 1;
			if (p.dis < res[p.x][p.y])
				res[p.x][p.y] = p.dis;	
			if (p.x - 1 >= 0 && matrix[p.x - 1][p.y] == 0 && checker[p.x - 1][p.y] == 0) {
				Position position = new Position(p.x - 1, p.y, p.dis + 1);
				queue.add(position);
			}
			if (p.x + 1 < row && matrix[p.x + 1][p.y] == 0 && checker[p.x + 1][p.y] == 0) {
				Position position = new Position(p.x + 1, p.y, p.dis + 1);
				queue.add(position);
			}
			if (p.y - 1 >= 0 && matrix[p.x][p.y - 1] == 0 && checker[p.x][p.y - 1] == 0) {
				Position position = new Position(p.x, p.y - 1, p.dis + 1);
				queue.add(position);
			}
			if (p.y + 1 < col && matrix[p.x][p.y + 1] == 0 && checker[p.x][p.y + 1] == 0) {
				Position position = new Position(p.x, p.y + 1, p.dis + 1);
				queue.add(position);
			}
		}
		return;
	}

	static class Position {
		int x;
		int y;
		int dis;

		public Position(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 0 }, { 0, 2, 0 }, { 0, 1, 0 } };
		//int[][] matrix = { { 0, 2, 0 }, { 0, 2, 0 }, { 0, 2, 1 } };
		//int[][] matrix = { { 1, 0 , 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
		int[][] res = findDistance(matrix);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++)
				System.out.print(res[i][j] + " ");
			System.out.println();
		}
	}
}
