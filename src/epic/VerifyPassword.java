package epic;

import java.util.HashMap;

/* Verify if a given password is valid or not.
 * 1. must be 5-12 characters long.
 * 2. must contain at least one number and one lowercase character
 * 3. a sequence must not be followed by the same sequence. (123123qs is invalid, but 123qs123 is valid);
 */
public class VerifyPassword {
	public static void main(String[] args) {
		String str = "123123d";
		System.out.println(verifyPassword(str));
	}

	private static boolean verifyPassword(String str) {
		return isseqValid(str) && ischarValid(str) && islenValid(str);
	}

	private static boolean islenValid(String string) {
		if (string.length() >= 5 && string.length() <= 12)
			return true;
		return false;
	}

	private static boolean ischarValid(String str) {
		boolean num_flag = false;
		boolean char_flag = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				num_flag = true;
			}
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				char_flag = true;
			}
		}
		return num_flag && char_flag;
	}

	/**
	 * HashMap store the substring as a key and its ending index as a value.
	 * Before putting value into the hashmap, it checks if the substring already
	 * exists. If yes, retrieve the value and compare value + 1 with the
	 * starting index of the new substring. If they are equal, it means there
	 * are consecutive substrings.
	 */
	public static boolean isseqValid(String str) {
		HashMap<String, Integer> stringindexMap = null;
		int len = str.length();
		for (int i = 1; i < len / 2; i++) {
			stringindexMap = new HashMap<String, Integer>();
			for (int j = 0; j + i <= len; j++) {
				String sub = str.substring(j, j + i);
				if (stringindexMap.get(sub) == null) {
					stringindexMap.put(sub, j + i - 1);
				} else {
					int prevlastIndex = stringindexMap.get(sub);
					if (prevlastIndex == j - 1)
						return false;
				}
			}
		}
		return true;
	}
}
