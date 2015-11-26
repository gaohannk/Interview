package amazon;

public class Greycode {
	public static boolean isgreycode(byte a, byte b) {
		byte c = (byte) (a ^ b);
		int count = 0;
		while (c != 0) {
			if ((c & 1) == 1)
				count++;
			c = (byte) (c >> 1);
		}
		if (count == 1)
			return true;
		else
			return false;
	}

	public static boolean isgreycode2(byte a, byte b) {
		if (a == b)
			return false;
		byte c = (byte) (a ^ b);
		return (c & (c - 1)) == 0 ? true : false;
	}

	public static void main(String[] args) {
		byte a = 10;
		byte b = 10;
		boolean res = isgreycode2(a, b);
		System.out.println(res);
	}
}
