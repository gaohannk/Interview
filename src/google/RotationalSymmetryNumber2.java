package google;

import java.util.ArrayList;
import java.util.HashSet;

public class RotationalSymmetryNumber2 {

	public static ArrayList<String> getAllRotationalSymmetryNumber(int m) {
		if (m == 0)
			return null;
		ArrayList<String> res = new ArrayList<>();
		String str = "";
		helper(m, res, str);
		return res;
	}

	private static void helper(int m, ArrayList<String> res, String str) {
		if (m == 0) {
			res.add(str.toString());
			return;
		}
		if (m == 1) {
			String temp = str.toString();
			res.add(temp.substring(0, temp.length() / 2) + '0' + temp.substring(temp.length() / 2));
			res.add(temp.substring(0, temp.length() / 2) + '8' + temp.substring(temp.length() / 2));
			res.add(temp.substring(0, temp.length() / 2) + '1' + temp.substring(temp.length() / 2));
			return;
		}
		String[] strs = { "00", "11", "88" };
		String strnew = "";
		for (int i = 0; i < 3; i++) {
			if (str.length() == 0 && i == 0)
				continue;
			strnew = str.substring(0, str.length() / 2) + strs[i] + str.substring(str.length() / 2);
			helper(m - 2, res, strnew);
		}
		strnew = str.substring(0, str.length() / 2) + "69" + str.substring(str.length() / 2);
		helper(m - 2, res, strnew);
		strnew = str.substring(0, str.length() / 2) + "96" + str.substring(str.length() / 2);
		helper(m - 2, res, strnew);

	}

	public static void main(String[] args) {
		System.out.println(getAllRotationalSymmetryNumber(3));
	}
}
