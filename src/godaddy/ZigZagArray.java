package godaddy;

import java.util.Arrays;

public class ZigZagArray {

	public static int[] zigzagArray(int[] array) {
		Arrays.sort(array);
		int[] result = new int[array.length];
		int p1 = 0;
		int p2 = array.length - 1;
		for (int i = 0; i < array.length; i++) {
			if (i % 2 == 0) {
				result[i] = array[p2];
				p2--;
			} else {
				result[i] = array[p1];
				p1++;
			}

		}
		return result;
	}
	public static void main(String[] args){
		int[] a = {1,2,3,4,5};
		int result[] =zigzagArray(a);
		for (int i=0;i <result.length;i++)
		System.out.println(result[i]);
	}

}
