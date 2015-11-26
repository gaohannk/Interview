package epic;

import java.util.Arrays;

/* Given two strings, you need to transpose the first string to the second string by means of only swaps 
 * between 2 consecutivecharacters in the first string. 
 * This must be performed by doing a series of these swaps in order to get the second string.
 */
public class SwappingString {
	public static void main(String[] args) {

		//char[] s1 = "eoksb".toCharArray();
		//char[] s2 = "sboek".toCharArray();
		char[] s1 = "TEHUNOOL".toCharArray();
		char[] s2 = "ONLEHTUO".toCharArray();
		
		transpose(s1, s2);
	}

	public static void transpose(char[] s1, char[] s2) {

		int i = 0;
		while (i < s2.length) {
			if (s2[i] == s1[i]) {
				i++;
				continue;
			} else {
				for (int j = i; j < s1.length - 1; j++) {
					char temp = s1[j];
					s1[j] = s1[j + 1];
					s1[j + 1] = temp;
					System.out.println(Arrays.toString(s1));
				}
			}

		}
		System.out.println(Arrays.toString(s2));
	}
}
