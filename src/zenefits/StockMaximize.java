package zenefits;
import java.io.*;
/* Stock 的最大化，一个人可以一天买入一支股票或者卖出它手上的多支股票或者啥都不做。问最多能赚多少
 * 
 */
public class StockMaximize {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testNum = Integer.parseInt(br.readLine());
			while (testNum-- > 0) {
				int len = Integer.parseInt(br.readLine());
				String str = br.readLine();
				String[] strs = str.split(" ");
				int[] num = new int[len];
				for (int i = 0; i < strs.length; i++) {
					num[i] = Integer.parseInt(strs[i]);
				}
				int start = 0;
				long profit = 0;
				System.out.println(MaxProfit(num, profit, start));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static long MaxProfit(int[] num, long profit, int start) {
		if (start >= num.length)
			return profit;
		int max = 0;
		int index = 0;
		for (int i = start; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
				index = i;
			}
		}
		for (int i = start; i <= index; i++) {
			profit += max - num[i];
		}
		return MaxProfit(num, profit, index + 1);
	}
}
