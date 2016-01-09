package qumulo;

import java.util.Scanner;

/* Print the Mth permutation, ordered lexicographically, of the first N natural numbers. 
 * The indexing is 0-based. The first few natural numbers are: 0,1, 2, 3, etc. 
 * For example, the six permutations, ordered lexicographically, with N = 3 are:
 * M=0 0 1 2
 * M=1 0 2 1
 * M=2 1 0 2
 * M=3 1 2 0
 * M=4 2 0 1
 * M=5 2 1 0
 * The input consist of one line with M and N in ASCII, separated by a space. 
 * Limits for M and N are: 0 <= N <= 20, 0 <= M < N!. 20! will fit in a 64-bit signed integer. 
 * The output must consist of a single line, with the N numbers separated by spaces.
 */
public class SpecificPermutation {

	public static String getSpecificPermutation() {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String[] strs = s.split(" ");
		int M = Integer.parseInt(strs[0]);
		int N = Integer.parseInt(strs[1]);
		StringBuffer num = new StringBuffer("123456789");
		StringBuffer str = new StringBuffer();
		int total = 1;
		for (int i = 2; i <= N; i++) {
			total *= i;
		}
		for (int i = 0; i < N; i++) {
			total /= (N - i);
			int index = (M - 1) / total;
			str.append(num.charAt(index) + " ");
			num.deleteCharAt(index);
			// System.out.println(num.toString());
			M -= index * total;
		}
		return str.toString();
	}
	public static void main(String[] args){
		System.out.println(getSpecificPermutation());
	}
}
