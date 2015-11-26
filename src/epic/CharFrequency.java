package epic;

/*	given a string, count the occurance of each letter and output
 *	them by alphabeta order.
 */

public class CharFrequency {

	public static void main(String[] args) {
		frequency("This is an apple!");
	}

	public static void frequency(String str) {
		str = str.toLowerCase();
		int[] count = new int[26];
		for (int i = 0; i < 26; ++i) {
			count[i] = 0;
		}
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if ((c - 'a') >= 0) {
				count[c - 'a']++;
			}
		}
		for (int i = 0; i < 26; ++i) {
			if (count[i] != 0)
				System.out.println((char) (i + 'a') + " has " + count[i]);
		}
	}
}
