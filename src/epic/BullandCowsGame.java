package epic;

import java.util.HashMap;

/* There’s a word guessing game. One person think a word, and the other one guess a word, 
 * both words have the same length.
 * The person should return the number of bulls and cows for the guessing. 
 * Bulls represent the number of same characters in the same spots, 
 * where as cows represent the number of characters guessed right but in the wrong spots. 
 * Write a program with two input strings, return the number of bulls and cows.
 */
public class BullandCowsGame {
	public static void bullsAndCows(String s, String t) {
		if (s == null || t == null)
			return;
		s = s.toLowerCase();
		t = t.toLowerCase();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		int bAndC = 0;
		int bulls = 0;
		for (int j = 0; j < t.length(); j++) { // count number of bulls and cows
			if (s.charAt(j) == t.charAt(j))
				bulls++; // same char same position a bull
			Character c = t.charAt(j);
			if (map.containsKey(c)) { // is a bull or a cow
				bAndC++; 
				if (map.get(c) == 1) {
					// once we found a match, decrease number of char from map
					map.remove(c);
				} else
					map.put(c, map.get(c) - 1);
			}
		}
		int cows = bAndC - bulls;
		System.out.println("bulls: " + bulls + " " + "cows: " + cows);
	}

	public static void main(String[] args) {
		bullsAndCows("Picture", "Epic");
		bullsAndCows("forum", "four");
	}
}
