package epic;

/* Print all valid phone numbers of length n subject to following constraints:
 * If a number contains a 4, it should start with 4
 * No two consecutive digits can be same
 * Three digits (e.g. 7,2,9) will be entirely disallowed, take as input
 */
public class TelephoneNumber {
	public static void validTelNumber(int n) {
		if (n <= 0)
			return;
		String digit = "0134568";
		String prefix = "";
		helper(n, prefix, digit);
	}

	private static void helper(int len, String prefix, String digit) {
		if (prefix.length() == len) {
			System.out.println(prefix);
			return;
		}
		if (prefix.length() == 0) {
			for (int i = 0; i < digit.length(); i++) {
				helper(len, prefix + digit.charAt(i), digit);
			}
		} else {
			for (int i = 0; i < digit.length(); i++) {
				if (digit.charAt(i) == prefix.charAt(prefix.length() - 1))
					continue;
				if (prefix.charAt(0) != '4' && digit.charAt(i) == '4')
					continue;
				helper(len, prefix + digit.charAt(i), digit);
			}
		}
	}

	public static void main(String[] args) {
		validTelNumber(3);
	}

}
