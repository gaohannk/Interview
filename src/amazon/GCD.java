package amazon;

public class GCD {
	public int Solution(int[] array) {
		if (array == null || array.length == 1)
			return 0;
		int gcd = array[0];
		for (int i = 1; i < array.length; i++) {
			gcd = getgcd(gcd, array[i]);
		}
		return gcd;
	}

	private static int getgcd(int num1, int num2) {
		if (num1 == 0 || num2 == 0)
			return 0;
		while (num1 != 0 && num2 != 0) {
			if (num2 > num1) {
				int temp = num2;
				num2 = num1;
				num1 = temp;
			}
			int temp = num1 % num2;
			num1 = num2;
			num2 = temp;
		}
		return num1 ;
	}
	public static void main(String[] arg) {
		System.out.println(getgcd(27, 9));
	}
}
