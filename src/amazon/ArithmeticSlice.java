package amazon;

/* A sequence of numbers is called arithmetic if it consists of at least three elements
 * 
 */
public class ArithmeticSlice {
	public int Solution(int[] array) {
		if (array == null || array.length < 3)
			return 0;
		int count = 0 ;
		int diff = array[1] - array[0];
		int length = 2;
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i + 1] - array[i] == diff)
				length++;
			else {
				diff = array[i + 1] - array[i];
				if (length >= 3)
					count += (length - 1) * (length - 2) / 2;
				if (count > 1000000000)
					return -1;
				length = 2;
			}
		}
		if (length >= 3)
			count += (length - 1) * (length - 2) / 2;
		return count > 1000000000 ? -1 : count;
	}
}
