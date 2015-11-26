package microsoft;

public class RemoveOccurrenceString {
	public static String removeOccurrenceString(String a, String b) {
		String res = "";
		if (a.length() < b.length())
			return res;
		int start = a.indexOf(b);
		if (start == -1)
			return res;
		StringBuilder sb = new StringBuilder(a);
		res += sb.substring(0, start).toString() + sb.substring(start + b.length(), a.length()).toString();
		return res;
	}



	public static void main(String[] args) {
		System.out.println(removeOccurrenceString("abcd", "bc"));
	}
}
