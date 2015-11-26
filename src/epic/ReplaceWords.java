package epic;

/* Given a string. Replace the words whose length >=4 and is even, 
 * with a space between the two equal halves of the word. 
 * Consideronly alphabets for finding the evenness of the word 
 * I/P "A person can't walk in this street"
 * O/P "A per son ca n't wa lk in th is str eet"
 */
public class ReplaceWords {
	public static String BreakWords(String str) {
		StringBuffer res = new StringBuffer();
		int count = 0;
		int i = 0;
		while (i < str.length()) {
			count = 0;
			int wordstart = i;
			while (i < str.length() && str.charAt(i) != ' ') {
				if (str.charAt(i) >= 'A' && str.charAt(i) <= 'z')
					count++;
				i++;
			}
			if (count >= 4 && count % 2 == 0) {
				int mid = wordstart + (i - wordstart) / 2;
				res.append( str.substring(wordstart, mid) + ' ' + str.substring(mid, i));
			} else {
				res.append( str.subSequence(wordstart, i));
			}
			res.append(' ');
			i++;
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String str = "A person can't walk in this street";
		System.out.print(BreakWords(str));
	}
}
