package epic;

/* Two-dimensional array representation of an image can also be represented by a one-dimensional array of W*H size,
 * where W represent row and H represent column size and each cell represent pixel value of that image. 
 * You are also given a threshold X. For edge detection, you have to compute difference of a pixel value 
 * with each of it's adjacent pixel and find maximum of all differences.
 * And finally compare if that maximum differenceis greater than threshold X. 
 * if so, then that pixel is a edge pixel and have to display it.
 */
public class EdgeDetection {
	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 9, 5, 6, 7, 8 };
		isEdge(A, 3, 3, 5);
	}

	static void isEdge(int[] A, int w, int h, int threshold) {
		if (A == null || w == 1)
			return;
		for (int i = 0; i < w; ++i) {
			for (int j = 0; j < h; ++j) {
				int index = i * w + j;
				int diff = 0;
				// left
				if (j - 1 >= 0) {
					diff = Math.max(diff, Math.abs(A[index] - A[i * w + j - 1]));
				}
				// right
				if (j + 1 < h) {
					diff = Math.max(diff, Math.abs(A[index] - A[i * w + j + 1]));
				}
				// up
				if (i - 1 >= 0) {
					diff = Math.max(diff, Math.abs(A[index] - A[(i - 1) * w + j]));

				}
				// down
				if (i + 1 < w) {
					diff = Math.max(diff, Math.abs(A[index] - A[(i + 1) * w + j]));
				}
				if (diff >= threshold) {
					System.out.print("index is:" + index + " max diff is:" + diff + " the number is:" + A[index]);
					System.out.println();
				}
			}
		}
	}
}
