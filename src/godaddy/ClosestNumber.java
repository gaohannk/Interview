package godaddy;

import java.util.Arrays;
import java.util.LinkedList;

public class ClosestNumber {
	public static void findClosetPair(int[] array) {
		Arrays.sort(array);
		LinkedList<Integer> list = new LinkedList<Integer>();
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < array.length-1; i++) {
			int curdiff = array[i + 1] - array[i];
			if (curdiff < diff) {
				diff=curdiff;
				list.clear();
				list.add(i);
			} else if (curdiff == diff) {
				list.add(i);
			} else {
				continue;
			}
		}
		for (int i = 0; i < list.size(); i++)
			System.out.print(array[list.get(i)]+" "+array[list.get(i)+1]+ " ");
	}

	public static void main(String[] args) {
		//int array[]= {-44,1,5,8,-10};
		int array[]= {1,2,4,5,6};
		findClosetPair(array);
	}
}
