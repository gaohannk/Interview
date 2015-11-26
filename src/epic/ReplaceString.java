package epic;

/*	From a given string, replace all instances of 'a' with 'one' and 'A' with 'ONE'.
 *	Example input: "A boy is playing in a garden";
 *	Example output: "ONE boy is playing in one garden"
 *	Note that 'A' and 'a' are to be replaced only when they are single charactere, not as part of another word.
 */
public class ReplaceString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringReplace("a banana is on A chair"));
	}

	static String stringReplace(String str) {
		String regex = " ";
		String str1 = "a";
		String str2 = "A";
		StringBuilder builder = new StringBuilder();
		String[] parts = str.split(regex);
		for (int i = 0; i < parts.length; i++) {
			if (parts[i].equals(str1))
				builder.append("one ");
			else if (parts[i].equals(str2))
				builder.append("ONE");
			else
				builder.append(parts[i]);
			if (i < parts.length - 1)
				builder.append(" ");
		}
		return builder.toString();

	}
}
