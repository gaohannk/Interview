package google;

import java.util.ArrayList;
import java.util.List;

/* Add two integer in array
 * 
 */
public class AddIntegerinArray {
	public static int[] increment(int[] input1, int[] input2) {
		int p1 = input1.length - 1;
		int p2 = input2.length - 1;
		int carry = 0;
		List<Integer> res = new ArrayList<>();
		while (p1 >= 0 && p2 >= 0) {
			int num = input1[p1] + input2[p2] + carry;
			carry = num >= 10 ? 1 : 0;
			res.add(num % 10);
			p1--;
			p2--;
		}
		if (p1 >= 0) {
			while (p1 >= 0) {
				int num = input1[p1--] + carry;
				carry = num >= 10 ? 1 : 0;
				res.add(num % 10);
			}
		} else {
			while (p2 >= 0) {
				int num = input2[p2--] + carry;
				carry = num >= 10 ? 1 : 0;

				res.add(num % 10);
			}
		}
		int num[] = new int[res.size()];
		for (int i = res.size() - 1; i >= 0; i--) {
			num[res.size() - i - 1] = res.get(i);
		}
		return num;
	}

	public static void main(String[] args) {
		int[] input1 = { 2, 3, 4, 5 };
		int[] input2 = { 1, 3, 4, 5, 7 };
		int num[] = increment(input1, input2);
		for (int i = 0; i < num.length; i++)
			System.out.print(num[i]);
	}

}
