package google;

import java.util.HashSet;

public class RotationalSymmetryNumber {

	public static boolean isRotationalSymmetryNumber(String number) {
		if (number == null)
			return true;
		HashSet<Character> set = new HashSet<Character>();
		set.add('1');
		set.add('8');
		set.add('0');
		int len = number.length();
		if (len % 2 == 1 && !set.contains(number.charAt(len / 2)))
			return false;

		for (int i = 0; i < len; i++) {
			char c=number.charAt(i);
			if (!set.contains(c) && c != '9' && c != '6')
				return false;
			else if (c == '6' && number.charAt(len - 1 - i) == '9')
				continue;
			else if (c == '9' && number.charAt(len - 1 - i) == '6')
				continue;
			else if (set.contains(c) && c != number.charAt(len - 1 - i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isRotationalSymmetryNumber("1691"));
	}
}
