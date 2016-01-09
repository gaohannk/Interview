package google;

import java.util.ArrayList;

public class MaximumIncreasingSubsequenceinArray {

	public int[] findMaximumIncreasingSubsequenceinArray(int[] array) {
		int len = 1;
		int max = 0;
		int index = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] < array[i + 1])
				len++;
			else {
				if (max < len) {
					max = len;
					index = i;
				}
			}
		}
		int[] res = new int[max];
		for (int i = 0; i < max; i++) {
			res[i] = array[index - i];
		}
		return res;
	}
}
