package google;

import java.util.HashSet;
import java.util.Random;

public class RandomSequence2 {

	private static HashSet<Integer> BuildRandomSequence(int length) {
		HashSet<Integer> set = new HashSet<Integer>(length);
	    int num = 0;
	    for (int i = 0; i < length; i++) {
	        do {
				Random rand = new Random();
	            num = rand.nextInt(length);
	        } while (set.contains(num));
	        set.add(num);
	    }
	    return set;
	}

}
