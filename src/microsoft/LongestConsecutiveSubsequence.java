package microsoft;

/* find length of longest consecutive subsequence S in an unsorted array where min * 2 > max
 */
public class LongestConsecutiveSubsequence {
	public static int longestsubsequence(int[] seq) {
		if (seq.length < 2)
			return seq.length;
		int maxlength = 0;
		for (int i = 0; i < seq.length; i++) {
			int max = seq[i];
			int min = seq[i];
			for (int j = i + 1; j < seq.length; j++) {
				if (seq[j] > max)
					max = seq[j];
				if (seq[j] < min)
					min = seq[j];
				if (min * 2 <= max) {
					maxlength = j - i;
					break;
				}
			}
		}
		return maxlength;
	}

	public static void main(String[] args) {
		int[] seq = { 3, 4, 7, 2, 5, 6, 9, 10 };
		System.out.print(longestsubsequence(seq));
	}
}
