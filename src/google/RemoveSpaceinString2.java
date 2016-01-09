package google;

/* Given a string of words, find the number of misspelled words, 
 * suppose you are givien a function to check whether a word is valid or not.
 * 
 */
public class RemoveSpaceinString2 {

	public static int findMisspellWord(String str) {
		if (str == null || str == "")
			return 0;
		int count = 0;
	
		int p = 0, q = 0;
		while (p < str.length()) {
			while (q < str.length() && str.charAt(q) == ' ')
				q++;
			p = q;
			while (q < str.length() && str.charAt(q) != ' ') {
				q++;
			}
			String word = str.substring(p, q);
			System.out.println(word);
			count = isMisspell(word) ? count + 1 : count;
			p = q;

		}
		return count;
	}

	private static boolean isMisspell(String word) {
		return false;
	}

	public static void main(String[] args) {
		findMisspellWord("  string is   some words  ");
	}

}
