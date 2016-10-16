package google;

public class InsteadTwoDigitWithAverage {
	public static int solution(int x) {
		String s = String.valueOf(x);
		int min = Integer.MIN_VALUE;
		for (int i = 1; i < s.length(); i++) {
			int value = 0;
			if ((s.charAt(i) - '0' + s.charAt(i - 1) - '0') % 2 == 0)
				value = (s.charAt(i) - '0' + s.charAt(i - 1) - '0') / 2;
			else
				value =(s.charAt(i) - '0' + s.charAt(i - 1) - '0') / 2+1;

			String num = s.substring(0, i - 1) + value + s.substring(i + 1);
			int res = Integer.parseInt(num);
			min = min > res ? min : res;
		}
		return min;
	}

	public static void main(String[] args) {
		int x = 2335431;
		System.out.println(solution(x));
	}
}
