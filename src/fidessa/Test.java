package fidessa;

public class Test {
	public static boolean foo() {
		System.out.println("CALL FOO");
		return true;
	}

	public static boolean bar() {
		System.out.println("CALL BAR");
		return false;
	}

	public static void main(String[] args) {
		/*
		 * for(int i=1;i<=10;i++){ System.out.println(i); }
		 */
		int a = 2;
		int b = 4;
		System.out.println(a | b);
		System.out.println(foo() | bar());
		System.out.println(foo() || bar());
	}
}
