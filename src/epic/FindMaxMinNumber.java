package epic;

/* Take a series of integers as input till a zero is entered. 
 * Among these given integers, find the maximum of the odd numbers and the minimum of the even integers 
 * (not including zero) and print them.
 */
public class FindMaxMinNumber {

	public static void MaxOddMinEven(int[] num) {
		int oddmax = Integer.MIN_VALUE;
		int evenmin = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			if (num[i] != 0) {
				if (num[i] % 2 == 0 && num[i] < evenmin)
					evenmin = num[i];
				else if (num[i] % 2 == 1 && num[i] > oddmax)
					oddmax = num[i];
			} else {
				System.out.println(oddmax + " " + evenmin);
			}
		}
	}

	public static void main(String[] args) {
		int[] num = { 1, 3, 5, 2, 56, 34, 556, 32, -435, -3, 0 };
		MaxOddMinEven(num);

	}
}
