package bloomberg;

public class PalindromeNumber {
	public static int countPalindromNumber() {
		int count = 0;
		for (int i = 100000; i <= 999999; i++) {
			if (isPalindromNumber(i)) {
				count++;
			}
		}
		return count;
	}

	private static boolean isPalindromNumber(int num) {
		int reverse = 0;
		int origin = num;
		while (num != 0) {
			reverse = reverse * 10 + num % 10;
			num /= 10;
		}
		return reverse == origin;
	}
}
