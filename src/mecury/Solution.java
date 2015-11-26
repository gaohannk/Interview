package mecury;

import java.util.HashMap;

public class Solution {

	public static String findCharacter(String str) {
		if (str == null || str.length() == 0)
			return null;
		if (str.length() == 1)
			return str;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int len = str.length();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (map.containsKey(c)) {
				if (map.get(c) + 1 > len / 2){
					String res=""+c;
					return res;
				}
				else
					map.put(c, map.get(c) + 1);
			} else
				map.put(str.charAt(i), 1);
		}
		return null;
	}

	public static void main(String[] args) {
		String str = "abadacababaaaa";
		System.out.println(findCharacter(str));
		String str2 = "abcdeabbad";
		System.out.println(findCharacter(str2));
	}
}
