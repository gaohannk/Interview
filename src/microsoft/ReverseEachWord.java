package microsoft;

public class ReverseEachWord {
	public static String reverseEachWord(String str) {
		StringBuilder strBuilder = new StringBuilder();
		String[] strings = new String[10];
		int index = 0;
		int[] flag = new int[10];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ' || str.charAt(i) == ',') {
				strings[index] = strBuilder.toString();
				strBuilder.delete(0, strBuilder.length());
				if (str.charAt(i) == ' ')
					flag[index] = 1;
				else if (str.charAt(i) == ',')
					flag[index] = 2;
				index++;
			} else {
				strBuilder.append(str.charAt(i));
			}
		}
		strings[index] = strBuilder.toString();
		String res = "";
		for (int i = 0; i <= index; i++) {
			StringBuilder temp = new StringBuilder(strings[i]);
			res += temp.reverse().toString();
			if (flag[i] == 1)
				res += ' ';
			else if (flag[i] == 2)
				res += ',';
		}
		return res;
	}

	public static void main(String[] args) {
		String str = "hello world, you are a smart guy!";
		System.out.println(reverseEachWord(str));
	}
}
