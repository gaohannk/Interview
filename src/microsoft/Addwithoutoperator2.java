package microsoft;

public class Addwithoutoperator2 {
	public static int add(int x, int y) {
		if (y != 0)
			return add(x ^ y, (x & y) << 1);
		else
			return x;
	}

	public static void main(String[] args) {
		int result = add(13, 44);
		System.out.print(result);
	}
}
