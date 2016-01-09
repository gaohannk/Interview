package google;

/* 假定row number 从0开始，给定一个row number, 返回这个row. 比如, pascalRow(0) => [1], pascalRow(3) => [1,3,3,1]
 * 
 */
public class YanghuiTriangle2 {
	public static int[] pascalRow(int n) {
		int[] res = new int[n + 1];
		if (n == 0) {
			res[0] = 1;
			return res;
		}
		int[] row = pascalRow(n - 1);
		res[0] = 1;
		res[res.length - 1] = 1;
		for (int i = 0; i < row.length - 1; i++)
			res[i + 1] = row[i] + row[i + 1];
		return res;
	}

	public static void main(String[] args) {
		int res[] = pascalRow(3);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
}
