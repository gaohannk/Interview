package google;

import java.util.PriorityQueue;

/* Given a string S, find the length of the longest substring T that contains at most two distinct characters.
 * For example,
 * Given S = “eceba”,
 * T is "ece" which its length is 3.
 */
/* aaacccbbcccbb
 * 当前字符k与前一个字符不同时,curr始终记录当前字符k之前的不同字符，也就是k之前不同字符的最后一个。
 * head记录候选字符串的头部
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		int head = 0, curr = -1, maxLen = 0;
		for (int k = 1; k < s.length(); k++) {
			if (s.charAt(k) == s.charAt(k - 1))
				continue;
			if (curr >= 0 && s.charAt(curr) != s.charAt(k)) { // k is at the third
														// distinct character
				maxLen = Math.max(k - head, maxLen);
				head = curr + 1; // the head of potential string with two distinct
								// character
			}
			curr = k - 1; // the tail of the distinct character before current
		}
		return Math.max(s.length() - head, maxLen);
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct("ecebbbba"));
	}
}
