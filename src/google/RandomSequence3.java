package google;

import java.util.Random;

public class RandomSequence3 {
	private int[] BuildRandomSequence(int length) {
		int[] array = new int[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		int x = 0, tmp = 0;
		for (int i = array.length - 1; i > 0; i--) {
			Random rand = new Random();
			x = rand.nextInt(i + 1);
			tmp = array[i];
			array[i] = array[x];
			array[x] = tmp;
		}
		return array;
	}

}
