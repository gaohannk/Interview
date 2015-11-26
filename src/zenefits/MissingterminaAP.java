package zenefits;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MissingterminaAP {

	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String[] strs = str.split(" ");
		boolean negflag = false;
		int[] num = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			num[i] = Integer.parseInt(strs[i]);
		}

		if (num[1] - num[0] < 0)
			negflag = true;

		int diff = Math.abs(num[length - 1]) - num[length - 2];
		if (Math.abs(num[1] - num[0]) < diff)
			diff = num[1] - num[0];

		for (int i = 1; i < strs.length; i++) {
			if (Math.abs(num[i]) - num[i - 1] != diff) {
				if (negflag)
					System.out.println(num[i - 1] - diff);
				else {
					System.out.println(num[i - 1] + diff);
				}
				return;
			}
		}
	}
}
