package epic;

import java.util.HashMap;

/* There is a security keypad at the entrance of a building. It has 9 numbers 1 - 9 in a 3x3 matrix format. 
 * 1 2 3 
 * 4 5 6 
 * 7 8 9 
 * The security has decided to allow one digit error for a person but that digit should be horizontal or vertical.
 * Example: for 5 the user is allowed to enter 2, 4, 6, 8 or for 4 the user is allowed to enter 1, 5, 7.
 * If the security code to enter is 1478 and if the user enters 1178 he should be allowed.
 * Write a function to take security code from the user and print out if he should be allowed or not.
 */
public class SecurityKeypad {

	public static boolean checkPassword(String input, String target) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "24");
		map.put(2, "135");
		map.put(3, "26");
		map.put(4, "157");
		map.put(5, "2468");
		map.put(6, "359");
		map.put(7, "48");
		map.put(8, "579");
		map.put(9, "68");
		if (input.length() != target.length())
			return false;
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == target.charAt(i))
				continue;
			else {
				String str = map.get(Integer.parseInt(""+target.charAt(i)));
				if (str.indexOf(input.charAt(i)) != -1)
					count++;
				else {
					return false;
				}
			}
		}
		return count < 2 ? true : false;
	}

	public static void main(String[] args) {
		System.out.println(checkPassword("1478", "1178"));
	}
}
