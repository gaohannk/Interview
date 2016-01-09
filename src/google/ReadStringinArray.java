package google;

/* 2个array string，由words构成，一次一边读取一个char并输出，直到一边读完，求最终输出, 比如 
 * array1={"ab","cd"}
 * array2={ "123", "45"}
 * 输出：a1b2c3d4
*/
public class ReadStringinArray {
	public static String readString(String[] arr1, String[] arr2) {
		int p = 0, q = 0;
		int i = 0, j = 0;
		StringBuilder sb = new StringBuilder();
		while (true) {
			if (p == arr1[i].length()) {
				p = 0;
				do {
					i++;
				} while (i < arr1.length && arr1[i].length() == 0);
			}
			if (q == arr2[j].length()) {
				q = 0;
				do {
					j++;
				} while (j < arr2.length && arr2[j].length() == 0);
			}
			if (i == arr1.length || j == arr2.length)
				break;
			sb.append(arr1[i].charAt(p));
			p++;
			sb.append(arr2[j].charAt(q));
			q++;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] arr1 = { "ab", "" };
		String[] arr2 = { "123", "45", "67" };
		System.out.println(readString(arr1, arr2));
	}
}
