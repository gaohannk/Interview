package microsoft;
// pair shoulb be adjcent
public class MaxPair {
	public static int[] findmaxPair(int[] num) {
		int max = 0;
		int[] res = new int[2];
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] + num[i + 1] > max) {
				max = num[i] + num[i + 1];
				res[0] = num[i];
				res[1] = num[i + 1];
			}
		}
		return res;
	}
}
