package google;

/* 给定一堆城市，boolean array表示两个城市是否可以在一个周末直飞，然后给你每周在每个城市的holiday days，求一年最多能歇几天.并求出城市方案。
 * dp, dp[i][j] 表示在 第i week停留在j 城市能获得的最大放假天数，dp[i][j] = max(dp[i][j], dp[i - 1][k] ) if k j直达 + holidays[i][j]; 
 */
public class Holidays {

	public int maxHolidays(boolean[][] directfly, int[][] holidays) {
		int[][] dp = new int[holidays.length][holidays[0].length];
		int res = 0;
		for (int j = 0; j < holidays[0].length; j++) {
			dp[0][j] = holidays[0][j];
		}
		for (int i = 1; i < holidays.length; i++) {
			for (int j = 0; j < holidays[0].length; j++) {
				for (int k = 0; k < holidays.length; k++) {
					if (directfly[k][j] == true)
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][k]) + holidays[i][j];
					else
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][k]);
				}
			}
		}
		for (int j = 0; j < holidays[0].length; j++) {
			if (dp[holidays.length - 1][j] > res)
				res = dp[holidays.length - 1][j];
		}
		return res;
	}
}
