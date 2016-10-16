package google;

/*You are given an integer X. You must choose two adjacent digits and replace them with the larger of these two digits.
For example, from the integer X = 233614, you can obtain:
33614 (by replacing 23 with 3);
23614 (by replacing 33 with 3 or 36 with 6);
23364 (by replacing 61 with 6 or 14 with 4);
You want to find the smallest number that can be obtained from X by replacing two adjacent digits with the larger of the two. In the above example, the smallest such number is 23364.
Write a function:
class Solution {public int solution (int X);}
that, given a positive integer X, returns the smallest number that can be obtained from X by replacing two adjacent digits with the larger of the two.
For example, given X = 233614, the function should return 23364, as explained above.
Assume that:
X is an integer within the range [10..1,000,000,000].In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
*/
public class InsteadTwoDigitWithLargerOne {
	public static int solution(int x) {
		String s = String.valueOf(x);
		int lastValue = s.charAt(0) - '0';
		String res = "" + lastValue;
		for (int i = 1; i < s.length(); i++) {
			int value = s.charAt(i) - '0';
			if (value < lastValue) {
				res += s.substring(i + 1);
				return Integer.parseInt(res);
			} else {
				res += value;
				lastValue = value;
			}
		}
		res = res.substring(0, res.length() - 2) + lastValue;
		return Integer.parseInt(res);
	}

	public static int solution2(int x) {
		String s = String.valueOf(x);
		int res = Integer.MAX_VALUE;
		for (int i = 1; i < s.length(); i++) {
			int value = 0;
			if (s.charAt(i) - '0' > s.charAt(i - 1) - '0')
				value = Integer.valueOf(s.substring(0, i - 1) + s.substring(i));
			else
				value = Integer.valueOf(s.substring(0, i) + s.substring(i + 1));
			res = value > res ? res : value;
		}
		return res;
	}

	public static void main(String[] args) {
		int x = 2335431;
		System.out.println(solution(x));
		System.out.println(solution2(x));
	}
}
