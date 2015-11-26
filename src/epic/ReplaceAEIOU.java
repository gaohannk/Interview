package epic;

/* Replace a,e,i,o,u with A,E,I,O,U.
 * At most four eligible letters from the rear of the string are replaced.
 * The first three eligible letters in the string are always exempted from replacement.
 */
public class ReplaceAEIOU {
	public static void main(String[] args) {
		String str = "an apple a mor";
		System.out.println(replaceVovel(str));
	}

	public static String replaceVovel(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (isVovel(c)) {
				count++;
			}
		}
		int len = 0;
		if (count <= 7)
			len = count - 3;
		else
			len = 4;
		StringBuilder res = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			char c = str.charAt(i);
			if (len > 0) {
				if (isVovel(c)) {
					res.insert(0, (char) (c - 'a' + 'A'));
					len--;
				} else {
					res.insert(0, c);
				}
			} else {
				res.insert(0, c);
			}
		}
		return res.toString();
	}

	private static boolean isVovel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;
		return false;
	}
}
