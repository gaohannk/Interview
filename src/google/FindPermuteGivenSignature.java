package google;
/* You are give an array of n elements [1,2...n] for example{3,2,1,6,7,4,5} 
 * the signmature would be "DDIIDI"
 * Given a signature, compute the lexicographically smallest permutation of [1,2..n]
 */
public class FindPermuteGivenSignature {

	private static String reverse(int begin, int end) {
		StringBuffer sb = new StringBuffer();
		for (int i = end; i >= begin; i--) {
			sb.append(i + " ");
		}
		return sb.toString();
	}

	public static String findPermutation(String signature) {
		StringBuffer sb = new StringBuffer();
		int lasti = 1;
		for (int i = 0; i < signature.length(); i++) {
			if ('I' == signature.charAt(i)) {
				sb.append(reverse(lasti, i + 1));
				lasti = i + 2;
			}
		}
		sb.append(reverse(lasti, signature.length() + 1));
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println("0 1 2 3 4 5 6 7 8");
		System.out.println(findPermutation("DDIIIDDI"));
	}

}
