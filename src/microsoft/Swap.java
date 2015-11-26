package microsoft;

public class Swap {

	public static void main(String[] args) {
		int a = 5, b = 6;
		a = a ^ b;
		b = a ^ b;
		a = b ^ a;
		System.out.print(a + " " + b);
	}
}
