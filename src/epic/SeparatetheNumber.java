package epic;

/* Print the sequences from the input given bythe user separated by semicolon 
 * e.g.: 4678912356012356 
 * output: 4;6789;123;56;0123;56;
 */
public class SeparatetheNumber {
	public static void main(String[] args) {
		String str = "4678912356012356";
		System.out.println(getSequences(str));
	}

	static String getSequences(String str) {
		StringBuffer sb = new StringBuffer();
		int start = 0;
		for (int i = 1; i < str.length(); i++) {

			while (i < str.length() && str.charAt(i - 1) + 1 == str.charAt(i)) {
				i++;
			}
			sb.append(str.substring(start, i));
			sb.append(';');
			start = i;
		}
		//sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
