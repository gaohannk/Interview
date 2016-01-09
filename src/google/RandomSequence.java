package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSequence {

	private static List<Integer> BuildRandomSequence(int length) {
		List<Integer> list = new ArrayList<Integer>();
		int num = 0;
		for (int i = 0; i < length; i++) {
			do {
				Random rand = new Random();
				num = rand.nextInt(length);
			} while (list.contains(num));
			list.add(num);
		}
		return list;
	}

}
