package google;

import java.util.HashMap;

/*题目： 给定一个String，可以shuffle或者delete其中任意characters, 输出最长的palindrome, 输出任意一个就够了。
 * Ex.input : accbbbad  output: acbbbca
 * Follow up： 输出所有最长的palindrome.
 */
public class LongestPalindrome {
	public static String getLongestPalindrome(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			} else
				map.put(str.charAt(i), 1);
		}
		StringBuilder sb = new StringBuilder();
		int maxfeq = 0;
		char middle = '0';
		for (Character ch : map.keySet()) {
			int feq = map.get(ch);
			int count = feq / 2;
			while (count > 0) {
				sb.append(ch);
				count--;
			}
			if (feq % 2 == 0) {
				continue;
			} else {
				if (maxfeq < feq) {
					middle = ch;
					maxfeq = feq;
				}
			}
		}
		if (middle != '0')
			sb.append(middle);
		String left = sb.toString();
		String right = sb.reverse().substring(1);
		return left + right;
	}

	public static void main(String[] args) {
		String str = "abbdddbcccd";
		System.out.println(getLongestPalindrome(str));
	}
}
