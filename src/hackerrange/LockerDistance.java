package hackerrange;

/**
 * 2. Locker distance A city is represented as a 2D grid. Amazon could put
 * lockers on cross points of the grid. You're given the city scale: int
 * cityLength, int cityWidth. Also given locker locations (x, y). For each cross
 * point, find the distance to the nearest locker.
 **/
public class LockerDistance {
	int cityLength;
	int cityWidth;
	int[][] grid = new int[cityLength][cityWidth];

	public int nearestLocker(int x, int y) {
		int minDist[] = new int[1];
		minDist[0] = Integer.MAX_VALUE;
		dfs(x, y, minDist, 0, new int[cityLength][cityWidth]);
		return minDist[0];
	}

	private void dfs(int x, int y, int[] minDist, int curr, int[][] visit) {
		if (grid[x][y] == 1) {
			minDist[0] = Math.min(minDist[0], curr);
			return;
		}
		if (x >= 0 && y + 1 < cityWidth && visit[x][y + 1] != 1) {
			visit[x][y + 1] = 1;
			dfs(x, y + 1, minDist, curr + 1, visit);
			visit[x][y + 1] = 0;
		}
		if (x - 1 >= 0 && y >= 0 && visit[x - 1][y] != 1) {
			visit[x - 1][y] = 1;
			dfs(x - 1, y, minDist, curr + 1, visit);
			visit[x - 1][y] = 0;
		}
		if (x >= 0 && y - 1 >= 0 && visit[x][y - 1] != 1) {
			visit[x][y - 1] = 1;
			dfs(x, y - 1, minDist, curr + 1, visit);
			visit[x][y - 1] = 0;
		}
		if (x + 1 < cityLength && y < cityWidth && visit[x + 1][y] != 1) {
			visit[x + 1][y] = 1;
			dfs(x + 1, y, minDist, curr + 1, visit);
			visit[x + 1][y] = 0;
		}
	}
}
