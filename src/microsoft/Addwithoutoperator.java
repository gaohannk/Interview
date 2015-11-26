package microsoft;

public class Addwithoutoperator {
	public static int add(int x, int y) {
		while (y != 0) {
			// carry now contains common set bits of x and y
			int carry = x & y;
			// Sum of bits of x and y where at least one of the bits is not set
			x = x ^ y;
			// Carry is shifted by one so that adding it to x gives the required sum
			y = carry << 1;
		}
		return x;
	}

	public static void main(String[] args) {
		int result = add(13, 45);
		System.out.print(result);
	}
}
