package microsoft;

public class RemoveOccurrenceString2 {
	public static String removeOccurrenceString(String a, String b) {
		if (a.length() < b.length())
			return "";
		StringBuilder sb = new StringBuilder(a);
		for (int i = 0; i < a.length(); i++) {
			int count = 0;
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i + j) != b.charAt(j))
					break;
				else
					count++;

			}
			if (count == b.length())
				sb.delete(i, i + count);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(removeOccurrenceString("abcd", "bc"));
	}
}
