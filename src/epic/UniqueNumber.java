package epic;

/*	Write efficient code for extracting unique elements
 *	from a sorted list of array. 
 *	Example: (1,1,3,3,3,5,5,5,9,9,9,9)->(1,3,5,9);
 */
public class UniqueNumber {
	public static void unique(int[] num) {
		int point = 1;
		for (int i = 1; i < num.length; i++) {
			while (i < num.length && num[i - 1] == num[i])
				i++;
			if (i < num.length)
				num[point++] = num[i];
		}
		num[point] = num[num.length - 1];
		for (int i = 0; i < point; i++) {
			System.out.print(num[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] num = { 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9 };
		unique(num);
	}
}
