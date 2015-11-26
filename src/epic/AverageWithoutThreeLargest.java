package epic;

/*	Write a program to display the advised average for the list of 
 *	numbers omitting the largest three number in the series.
 *	e.g. 3,6,12,55,289, 600, 534, 900, 172, 
 *	avg = (3+6+12+55+289+172)/6 and eliminating 534, 900, 600;
 */
public class AverageWithoutThreeLargest {

	public static void main(String[] args) {
		int[] num = { 3, 7, 12, 2, 25, 8, 9, 13, 10, 0 };
		System.out.println("Average Without Three Larges is " + average(num));
	}

	public static double average(int[] num) {
		int large = Integer.MIN_VALUE, medium = Integer.MIN_VALUE, small = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < num.length; ++i) {
				sum += num[i];
				if (num[i] > large) {
					small = medium;
					medium = large;
					large = num[i];
				} else if (num[i] > medium && num[i] < large) {
					small = medium;
					medium = num[i];
				} else if (num[i] > small && num[i] < medium) {
					small = num[i];
				}
		}
		sum = sum - large - medium - small;
		double av = (double) sum /( num.length - 3);
		return av;
	}
}
