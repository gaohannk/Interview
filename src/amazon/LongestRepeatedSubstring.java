package amazon;

public class LongestRepeatedSubstring {
	public static String findLRS(String str) {
		String res = "";
		int len = 0;
		for (int l = 1; l < str.length(); l++) {
			for (int i = 0; i < str.length() - l; i++) {
				String s = str.substring(i, i + l);
				int k = i + l;
				// System.out.println(k);
				// Note that k+l can be str.length();
				while (k + l <= str.length()) {
					if (str.substring(k, k + l).equals(s)) {
						k += l;
						continue;
					} else
						break;
				}
				//System.out.println(s+" "+k);
				if (k != i + l && len < k - i + 1) {
					len = k - i + 1;
					res = s;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(findLRS("banannan"));
	}
}
