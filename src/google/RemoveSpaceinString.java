package google;

/* Given a string of words, find the number of misspelled words, 
 * suppose you are givien a function to check whether a word is valid or not.
 * 
 */
public class RemoveSpaceinString {

	public static int findMisspellWord(String str) {
		if (str == null || str == "")
			return 0;
		int head = 0;
		int count = 0;
		int len = 0;
		boolean flag = false;
		int i = 0;
		while (i < str.length() && str.charAt(i) == ' ') {
			i++;
		}
		head = i;
		for (; i < str.length(); i++) {
			while (i < str.length() && str.charAt(i) == ' ') {
				len++;
				i++;
				flag = true;
			}

			if (flag) {
				String word = str.substring(head, i - len);
				System.out.println(word);
				count = isMisspell(word) ? count + 1 : count;
				len = 0;
				head = i;
				flag = false;
			} else
				continue;
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
