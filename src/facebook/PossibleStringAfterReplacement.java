package facebook;

/* Input: 一个字符串， 每个字符都有几个对应的replacement. 
 * Output: Generate all the possible Strings after replacement. 
 * ex. Input: ABC, A-->@,$, B-->&, C--> *
 * Output: @&*, $&*
 */
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class PossibleStringAfterReplacement {
	public List<String> letterCombinations(String str, Hashtable<Character, String> table) {
		ArrayList<String> list = new ArrayList<String>();
		String build = "";
		helper(str, build, list, table, 0);
		return list;
	}

	public static void helper(String str, String build, ArrayList<String> list, Hashtable<Character, String> table,
			int index) {
		int len = str.length();
		if (build.length() == len) {
			list.add(str);
		}

		String string = table.get(str.charAt(index));
		for (int i = 0; i < string.length(); i++) {
			String build_new = build + string.charAt(i);
			helper(str, build_new, list, table, index + 1);
		}
	}
}
