package epic;
/* Let the user enter a decimal number. Therange allowed is 0.0001 to 0.9999. 
 * Only four decimal places are allowed. Theoutput should be an irreducible fraction.
 * E.g.: If the user enters 0.35,the irreducible fraction will be 7/20.
 */
public class DecimalNumber {

	public static String decimalToFraction(double num){
		if(num<=0 || num>=1) return "Out of range.";
		int y = 100000;
		int x = (int) (num*y);
		int z = gcd(x, y);
		return x/z + "/" + y/z;
	}
	private static int gcd(int a, int b){
		if (a==0) return b;
		while(a!=b){
			if(a>b){
				a=a-b;
			}
			else if (b>a){
				b=b-a;
			}
			else return a;
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(decimalToFraction(0.35));
	}
}
