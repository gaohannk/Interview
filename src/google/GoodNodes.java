package google;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GoodNodes {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[] num = new int[len];
		int k = 0;
		while (len-- > 0) {
			String str = br.readLine();
			num[k] = Integer.parseInt(str) - 1;
			k++;
		}
		System.out.println(FindChanges(num));
	}

	public static int FindChanges(int[] num) {
		int[] visit = new int[num.length];
		for (int i = 0; i < visit.length; i++)
			visit[i] = -1;
		int ncomponents = 1, npass = 1;
		visit[0] = 0;
		for (int i = 1; i < num.length; i++) {
			if (isNewComponent(num, visit, i, npass++))
				ncomponents++;
		}
		return ncomponents-1;
	}

	public static Boolean isNewComponent(int[] num, int[] visit, int i, int cur_pass) {
		
		if (i == 0)
			return false;
		if (visit[i] > 0 && visit[i] != cur_pass)
			return false;
		if (visit[i] == cur_pass)
			return true;
		visit[i] = cur_pass;
		return isNewComponent(num, visit, num[i], cur_pass);
	}
}
