package bloomberg;

// 有1,3,5面值硬币，target为20，最少需要多少硬币
public class ChangeCoin {
	public static int minChangeCoin(int target, int[] coins) {
		int[] minimum = new int[target + 1];
		// 从最小可找币值开始遍历
		for (int i = coins[0]; i <= target; i++) {
			int minCoin = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					int temp = minimum[i - coins[j]] + 1;
					if (temp < minCoin)
						minCoin = temp;
				}
			}
			minimum[i] = minCoin;
		}
		return minimum[target];
	}

	public static void main(String[] args) {
		int[] coins = { 2, 3, 5 };
		int target = 9;
		int result = minChangeCoin(target, coins);
		System.out.println("最少需要硬币"+result);
	}
}
