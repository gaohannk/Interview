import java.util.HashSet;

/*给出一个nxn大小的2d数组，请问如何高效(O(mn))得找出x such that 有一行和一列的所有数字都是x? 如果找不到返回-1.
例子：
0 1 3 2
1 1 1 1
4 1 9 8
4 1 2 1
这个数组里面，第二行和第二列所有数字都是1，返回1.
如果把第一行第二个数字改成非1的数字，那么我们就找不到这样的数字了，返回-1.
*/
public class FindSameNuminMatrix {
	public int findRowColumn(int[][] arr) {
		int i, j, res = 0;
		for (i = 0; i < arr.length; i++) {
			int target = arr[i][0];
			boolean rowFlag = true;
			for (j = 1; j < arr[i].length; j++) {
				if (arr[i][j] != target) {
					rowFlag = false;
					break;
				}
			}
			if (rowFlag)
				res = target;
		}

		for (i = 0; i < arr.length; i++) {
			boolean colFlag = true;
			for (j = 0; j < arr[i].length; j++) {
				if (arr[j][i] != res) {
					colFlag = false;
					break;
				}
			}
			if (colFlag)
				return res;
		}
		return -1;
	}
}
