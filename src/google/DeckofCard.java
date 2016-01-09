package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* Assume you have a deck of cards. Each card has a number on it with no suit. 
 * We define “X of a kind” as X cards with same number on it (X >= 2). 
 * Determine if the deck can be fully divided into sets of “X of a kind”.
 * Example: 3, 5, 3, 5, 3 -> True
 *          3, 3, 5, 3, 3 -> False
 */
/* Define “Straight” as 5 cards with consecutive numbers. Determine if the deck can be fully divided into sets of “Straight”.
 * Example: 1, 2, 3, 4, 4, 5, 5, 6, 7, 8 -> True
 */
/* Define “X-Straight” as X cards with consecutive numbers (X >= 3). Determine if the deck can be fully divided into sets of “X-Straight”.
 * Example: 1, 2, 3, 4, 4, 5, 6 -> True
 */
public class DeckofCard {

	public static boolean isSetofKind(int[] num) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < num.length; i++) {
			if (!map.containsKey(num[i]))
				map.put(num[i], 1);
			else {
				map.put(num[i], map.get(num[i]) + 1);
			}
		}

		for (Integer number : map.keySet()) {
			if (map.get(number) == 1)
				return false;
		}
		return true;
	}

	public static boolean isSetofStraight(int[] num) {
		int[] card = new int[14];
		for (int i = 0; i < num.length; i++) {
			card[num[i]]++;
		}
		HashSet<Integer> set = new HashSet<>();
		int index = 1;
		while (index < 14) {
			if (set.isEmpty() && card[index] == 0) {
				index++;
				continue;
			}
			if (!set.isEmpty() && card[index] == 0)
				return false;

			card[index]--;
			set.add(index);
			index++;
			if (set.size() == 5) {
				set.clear();
				index = 0;
			}
		}
		return set.isEmpty();
	}

	public static boolean isSetofXStraight(int[] num) {
		int[] card = new int[14];
		for (int i = 0; i < num.length; i++) {
			card[num[i]]++;
		}
		ArrayList<Integer> list = new ArrayList<>();
		HashSet<ArrayList<Integer>> set = new HashSet<>();
		int index = 1;
		while (index < 14) {
			if (list.isEmpty() && card[index] == 0) {
				index++;
				continue;
			}
			if (!list.isEmpty() && card[index] == 0) {
				for (Integer n : list) {
					card[n]++;
				}
				list.clear();
				index++;
				continue;
			}

			card[index]--;
			list.add(index);
			index++;
			if (list.size() == 3) {
				ArrayList<Integer> temp = new ArrayList<>(list);
				set.add(temp);
				list.clear();
				index = 0;
			}
		}
		for (int i = 0; i < card.length;) {
			if (card[i] != 0) {
				boolean flag = false;
				for (ArrayList<Integer> l : set) {
					if (l.get(l.size() - 1) == i - 1) {
						l.add(i);
						flag = true;
						card[i]--;
					}
				}
				if (!flag) {
					return false;
				}
			}
			if (card[i] == 0)
				i++;
		}
		return true;
	}


	public static void main(String[] args) {
		int[] num = { 3, 3, 5, 3, 3 };
		System.out.println(isSetofKind(num));
		int[] num2 = { 1, 2, 3, 4, 4, 5, 5, 6, 7, 8 };
		System.out.println(isSetofStraight(num2));
		int[] num3 = { 1, 2,2,3,3,4};
		System.out.println(isSetofXStraight(num3));
	}
}
