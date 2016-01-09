package google;

/* You are give an array of n elements [1,2...n] for example{3,2,1,6,7,4,5} 
 * the signmature would be "DDIIDI"
 * Given a signature, compute the lexicographically smallest permutation of [1,2..n]
 */
/* If the nodes of the graph are a1, a2... an, ai -> ai+i (edge from i to i+1) 
 * if signature(i) = I and ai <- ai+1 (edge from i+1 to i) if signature(i)=D 
 * Run the topological sort on all the nodes starting from the last node since you wish to have the last one be assigned the biggest value 
  */
public class FindPermuteGivenSignature2 {

	public static String findPermutation(String signature) {
		if (signature == null)
			return null;
		int[] result = new int[signature.length() + 1];
		int graph[][] = new int[signature.length() + 1][signature.length() + 1];
		for (int i = 0; i < graph.length; i++)
			for (int j = 0; j < graph[i].length; j++)
				graph[i][j] = 0;
		for (int i = 0; i < signature.length(); i++) {
			if (signature.charAt(i) == 'D') {
				graph[i + 1][i] = 1; // i+1 => i
			} else {
				graph[i][i + 1] = 1; // i => i+1
			}
		}
		boolean visited[] = new boolean[signature.length() + 1];
		int topValue = result.length;
		for (int i = result.length - 1; i >= 0; i--) {
			topValue = topSort(graph, visited, result, i, topValue);
		}
		String res = "";
		for (int i = 0; i < result.length; i++) {
			res += result[i] + " ";
		}
		return res;
	}

	public static int topSort(int[][] graph, boolean[] visited, int[] result, int n, int topValue) {
		if (visited[n])
			return topValue;
		visited[n] = true;
		for (int i = 0; i < graph.length; i++) {
			if (graph[n][i] != 0) {
				topValue = topSort(graph, visited, result, i, topValue);
			}
		}
		result[n] = topValue;
		return topValue - 1;
	}

	public static void main(String[] args) {
		System.out.println(findPermutation("DDIIDDI"));

	}

}
