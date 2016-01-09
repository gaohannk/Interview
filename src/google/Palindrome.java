package google;

import java.util.ArrayList;
import java.util.HashSet;

/* Part I
 * A list of words, find out any pairs that they are palindrome
 * [abc, cdc, cba]
 * abc, cba
 * cba, abc
 * Part II
 * Average length of a word L, we have N words. 
 * NNL
 * Any better solution?
 * Part II
 * A list of words, find out any two words that their concatenation is palindrome
 * [abc, cba, cdd, accaer, re]
 * abc, cba
 * cba, abc
 * re, accaer
 */
public class Palindrome {

	public ArrayList<String> findpalinedorme(ArrayList<String> list) {
		HashSet<String> set = new HashSet<String>();
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (!set.contains(list.get(i)))
				set.add(list.get(i));
			if (set.contains(reverse(list.get(i)))) {
				res.add(list.get(i) + ',' + reverse(list.get(i)));
			}
		}
		return res;
	}

	public ArrayList<String> findPalindrom2(ArrayList<String> list) {
		HashSet<String> set = new HashSet<String>();
		ArrayList<String> res = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {
			if (!set.contains(list.get(i)))
				set.add(list.get(i));
			for (String str : set) {
				if (list.get(i) != str) {
					if (str + list.get(i) == reverse(str + list.get(i)))
						res.add(str + ',' + list.get(i));
				}
			}
		}
		return res;
	}

	public ArrayList<String> findPalindrom3(ArrayList<String> list) {
		HashSet<String> set = new HashSet<String>();
		ArrayList<String> res = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {
			if (!set.contains(list.get(i)))
				set.add(list.get(i));
		}
		for (String str : set) {
			int head = 0;
			for (int i = 0; i < str.length(); i++) {
				if (isPanlindrom(str.substring(head, i))) {
					String reverse = reverse(str.substring(i, str.length()));
					if (set.contains(reverse))
						res.add(str + ',' + reverse);
				}
			}

		}
		return res;
	}

	private boolean isPanlindrom(String substring) {
		return false;
	}

	private String reverse(String string) {
		return null;
	}
}
