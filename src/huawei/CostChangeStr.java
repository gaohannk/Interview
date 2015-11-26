package huawei;

import java.util.Scanner;

public class CostChangeStr {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		int index = 0;
		int res[] = new int[num];
		while (num != 0) {
			String stra = scan.nextLine();
			String strb = scan.nextLine();
			int dp[][] = new int[stra.length() + 1][strb.length() + 1];
			dp[0][0] = 0;
			for (int i = 0; i <= stra.length(); i++) {
				dp[i][0] = 2;
			}
			for (int i = 0; i <= strb.length(); i++) {
				dp[0][i] = i + 2;
			}
			for (int i = 1; i <= stra.length(); i++) {
				for (int j = 1; j <= strb.length(); j++) {
					if (stra.charAt(i - 1) == strb.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1];
						continue;
					}
					int optimal = Integer.MAX_VALUE;
					for (int k = 0; k < i; k++) {
						if (optimal > dp[k][j]) {
							optimal = dp[k][j];
						}
					}
					for (int k = 0; k < j; k++) {
						if (optimal > dp[i][k] + j - k) {
							optimal = dp[i][k] + j - k;
						}
					}
					dp[i][j] = optimal + 2;
				}
			}
			res[index] = dp[stra.length()][strb.length()];
			index++;
			num--;
		}
		for (int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
	}
}
