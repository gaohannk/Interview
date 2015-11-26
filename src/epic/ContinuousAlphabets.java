package epic;

/* Printcontinuous alphabets from a sequence of arbitrary alphabets . 
 * For example: 
 * Input: abcdefljdflsjflmnopflsjflasjftuvwxyz 
 * Output: abcdef; lmnop; tuvwxyz
 * Input: AbcDefljdflsjflmnopflsjflasjftuvWxYz 
 * Output: abcdef; lmnop; tuvwxyz
 */
public class ContinuousAlphabets {

	public static void printContiAlpha(String str) {
		str = str.toLowerCase();
		int i = 0;
		boolean con = false;
		if (str.length() == 1)
			System.out.println(str);
		while (i < str.length() - 1) {
			char current = str.charAt(i);
			char next = str.charAt(i + 1);
			if (current + 1 == next) {
				System.out.print(current);
				con = true;
			} else {
				if (con) {
					System.out.print(current);
					System.out.println();
					con = false;
				}
			}
			i++;
		}
		if (con)
			System.out.print(str.charAt(str.length() - 1));
	}

	public static void main(String[] args) {
		String str = "AbcDefljdflsjflmnopflsjflasjftuvWxYz";
		printContiAlpha(str);
	}
}
