package groupon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PalindromeCard {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		String front[] = str.split(",");
		str = in.readLine();
		String back[] = str.split(",");
		int values[] = new int[back.length];
		int sum = 0;
		for (int i = 0; i < back.length; i++) {
			values[i] = Integer.parseInt(back[i]);
		}
		// Sort all the cards first
		for (int i = 0; i < values.length; i++) {
			for (int j = values.length - 1; j > i; j--) {
				if (values[j - 1] < values[j]) {
					int temp = values[j - 1];
					values[j - 1] = values[j];
					values[j] = temp;
					String tmp = front[j - 1];
					front[j - 1] = front[j];
					front[j] = tmp;
				}
			}
		}
		boolean flag[] = new boolean[front.length];
		for (int i = 0; i < values.length; i++) {
			if (!flag[i]) {
				for (int j = i + 1; j < values.length; j++) {
					if (!flag[j] && isReverse(front[i], front[j])) {
						sum += values[i] + values[j];
						flag[i] = true;
						flag[j] = true;
						break;
					}
				}
			}
		}

		// Find the last possible middle one
		for (int i = 0; i < values.length; i++) {
			if (!flag[i] && isReverse(front[i], front[i])) {
				sum += values[i];
				// System.out.println(values[i]);
				break;
			}
		}
		System.out.println(sum);
	}

	private static boolean isReverse(String s1, String s2) {
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(s2.length() - 1 - i))
				return false;
		}
		return true;
	}
}
