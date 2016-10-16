package twitter;

/**
 * 左上角，终点：右下角
 * 规则：每次向右，向下 或者 右下移动一次
 * 问：你抵达终点有多少种走法.
 */
public class MoveWays {
    public int numOfWaysToMove(int m, int n) {
        int dp[][] = new int[m][n];
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
