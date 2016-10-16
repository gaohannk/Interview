package google;
//Figure 5
public class FindLargestNumberAfterRemoveOneRepeatDigit {
	public static int solution(int x) {
		String s = String.valueOf(x);
		int res = Integer.MIN_VALUE;
		for (int i = 1; i < s.length(); i++) {
			StringBuilder sb = new StringBuilder(s);
			int value = s.charAt(i) - '0';
			int lastValue = s.charAt(i - 1) - '0';
			if (value == lastValue) {
				sb.deleteCharAt(i);
				res = res > Integer.parseInt(sb.toString()) ? res : Integer.parseInt(sb.toString());
			}
			lastValue = value;
		}
		return res;
	}

	public static void main(String[] args) {
		int x = 223336226;
		System.out.println(solution(x));
	}
}
