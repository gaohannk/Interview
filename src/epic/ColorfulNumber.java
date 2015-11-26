package epic;
/* Colorful Number:
 * A number can be broken into different sub-sequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 * And this number is a colorful number, since product of every digit of a 
 * sub-sequence are different.
 * That is, 3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20 (3*2*4)= 24 (2*4*5)= 40
 * But 326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12.
 */
import java.util.HashSet;

public class ColorfulNumber {
	public static boolean isColorful(int number) {
		String str = String.valueOf(number);
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 1; i < str.length(); i++) {
			for (int j = 0; j + i < str.length(); j++) {
				String sub = str.substring(j, j + i);
				int product = getProduct(Integer.parseInt(sub));
				if (set.contains(product)) {
					return false;
				} else {
					set.add(product);
				}
			}
		}
		return true;
	}

	private static int getProduct(int digits) {
		if (digits < 10)
			return digits;
		int num = digits;
		int product = 1;
		while (num > 0) {
			product *= (num % 10);
			num = num / 10;
		}
		return product;
	}

	public static void main(String[] args) {
		System.out.println(isColorful(326));
		System.out.println(isColorful(3245));
	}
}
