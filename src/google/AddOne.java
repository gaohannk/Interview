package google;

public class AddOne {

	public static int[] increment(int[] input) {
		int carry = 1;
		boolean flag = true;
		for (int i = 0; i < input.length; i++) {
			if (input[i] != 9) {
				flag = false;
				break;
			}
		}
		int len = flag ? input.length + 1 : input.length;
		int[] res = new int[len];
		if (flag) {
			res[0] = 1;
			return res;
		}
		for (int i = input.length - 1; i >= 0; i--) {
			int num = input[i] + carry;
			if (num <= 9) {
				res[i] = num;
				break;
			} else {
				res[i] = 0;
			}
		}
		return input;
	}

	public static void main(String[] args) {
		int[] input = { 9, 9, 9, 9, 9 };
		int[] res = increment(input);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
}
