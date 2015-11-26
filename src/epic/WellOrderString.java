package epic;

import java.util.ArrayList;
import java.util.List;

/* You know password is well-ordered string. 
 * Well-ordered string means that the order of the characters is in an alphabetical increasing order.
 * Like “abEm” is a well-ordered number. However, “abmE” is not a well-order number. 
 * Given an input# that tells you how many digits are in the password, print all possible passwords.
 * 
 */
public class WellOrderString {
	public static List<String> WellOrderedString(int n) {
		if (n <= 0)
			return null;
		List<String> res = new ArrayList<String>();
		res.add("");
		while (n-- > 0) {
			List<String> list = new ArrayList<String>();
			for (String curStr : res) {
				if (curStr.length() == 0) {
					for (int i = 0; i < 26 - n; i++) {
						list.add(curStr + (char) (i + 'a'));
						list.add(curStr + (char) (i + 'A'));
					}
				} else {
					char last = curStr.charAt(curStr.length() - 1);
					int start = last - 'A';
					if (last >= 'a') {
						start = last - 'a';
					}
					for (int i = start + 1; i < 26; i++) {
						list.add(curStr + (char) (i + 'a'));
						list.add(curStr + (char) (i + 'A'));
					}

				}
			}
			res = list;
		}
		return res;
	}

	public static void main(String[] args) {
		List<String> list = WellOrderedString(4);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
