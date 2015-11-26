package epic;

import java.util.Arrays;

/* Something cost $10.25 and the customer pays with a $20 bill, 
 * the program will print outthe most efficient "change-breakdown" which is 1 five, 4 ones, and 3 quarters. 
 * Find the minimum number of coins required to make change for a given sum 
 * (given unlimited cumber of N different denominations coin)
 */
public class CoinChange {
	public static void main(String[] args) {
		casher(10.25, 20.0);
	}

	public static void casher(double Worth, double Paid) {
		double units[] = { 0.01, 0.05, 0.10, 0.25, 1.00, 5.00, 10.00, 20.00, 50.00 };
		int counter[] = new int[units.length];

		double left = Paid - Worth;
		int index = 8;

		while (left > 0) {
			counter[index] = (int) (left / units[index]);
			left = left % units[index];
			index--;
		}

		System.out.println(Arrays.toString(units));
		System.out.println(Arrays.toString(counter));
	}

}
