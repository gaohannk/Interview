package facebook;

// return if the distance between a and b is at most 1.
// Distance: minimum number of modifications to make a=b
// Modification:
// 1. change an int in a
// 2. insert an int to a
// 3. remove an int from a
public class OneEditDistance {

	abstract class IntFileIterator {
		abstract boolean hasNext();

		abstract int next();
	}

	class FileCompare {
		public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b) {
			while (a.hasNext() && b.hasNext()) {
				int numa=a.next();
				int numb=b.next();
				if(a!=b){
					
				}
			}
		}
	}
}
