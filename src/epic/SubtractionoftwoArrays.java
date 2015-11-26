package epic;

/* Suppose you want to do the subtraction of two numbers. Each digit of the numbers is divided and put in an array. 
 * Like A = [1,2,3,4,5], B = [4,5,3,5]. You should output an array C = [7,8,1,0]. 
 * Remember that your machine can't hand numbers larger than 20;
 */
public class SubtractionoftwoArrays {
	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		int[] B = { 4, 5, 3, 5 };
		subtract(A, B);
	}

	public static int[] subtract(int[] A, int[] B) {
		StringBuffer str = new StringBuffer();
		boolean flag = false;
		int j = B.length - 1;
		for (int i = A.length - 1; i >= 0; i--) {
			if (j >= 0) {
				if (A[i] >= B[j])
					str.setCharAt(0, (char) (A[i] - B[j]));
				else {
					str.setCharAt(0, (char) (A[i] + 10 - B[j]));
					if (i - 1 >= 0)
						A[i - 1]--;
					else {
						flag = true;
					}
				}
				j--;
			} else {
				str.setCharAt(0, (char) (A[i] - 0));
			}
		}
		if (flag) {
			if (j >= 0)
				str.setCharAt(0, (char) (9- B[j--]));
			else {
				str.setCharAt(0, (char) (9 - 0));
			}
		}
		while (j != 0) {
			str.setCharAt(0, (char) (9 - B[j]));
			j--;
		}
		return B;
	}
}
