package google;

/* 1个4位数可以从中划分成2个2位数，将2位数相加和为100且不含重复数字有多少种情况？
 * 比如 87 + 13 =100 就是一种。
 * (1)写出程序，分析需要loop多少次。
 * (2)如果只有笔和纸，如何计算有多少种情况。
 */
/* number: abcd
a + c = 9; a = 1,2,3,4,5,6,7,8,9; c = 8,7,6,5,4,3,2,1,0;   9
b + d = 10; b = 1,2,3,4,6,7,8,9; c = 9,8,7,6,4,3,2,1;  8
a=1,2,3,6,7,8; b 取4种
a=4,5; b取6种
a=9 ;b取6种
Total: 6*4 + 2*6 + 1*6 = 24 + 12 + 6 = 42
*/
import java.util.HashSet;

public class Equal100 {
	public static int findAllpossible() {
		int count = 0;
		for (int i = 10; i <= 99; i++) {
			int j = 100 - i;
			if (!containSameNumber(i, j))
				count++;
		}
		return count;
	}

	private static boolean containSameNumber(int i, int j) {
		HashSet<Integer> set = new HashSet<>();
		while (i > 0) {
			int div = i / 10;
			int num = i - div * 10;
			i = i / 10;
			// System.out.println(num);
			if (set.contains(num))
				return true;
			set.add(num);
		}
		while (j > 0) {
			int div = j / 10;
			int num = j - div * 10;
			j = j / 10;
			if (set.contains(num))
				return true;
			set.add(num);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(findAllpossible());
	}
}
