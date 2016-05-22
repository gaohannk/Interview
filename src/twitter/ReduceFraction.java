package twitter;

public class ReduceFraction {
	public static int[] reduceFraction(int frac[]) {
		int d = gcd(frac[0], frac[1]);
		int res[] = new int[2];
		res[0] = frac[0] / d;
		res[1] = frac[1] / d;
		return res;
	}

	public static int gcd(int a, int b) {
		if (a == 0 || b == 0)
			return a + b;
		return gcd(b, a % b);
	}

	public static void main(String args[]) {
		int frac[] = { 20, 40 };
		int res[] = reduceFraction(frac);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
}
