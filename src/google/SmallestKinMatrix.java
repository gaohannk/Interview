package google;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestKinMatrix {
	public static List<Integer> findSmallestKelement(int[][] matrix, int k) {
		LinkedList<Integer> res = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < Math.sqrt(k); i++) {
			for (int j = 0; j < Math.sqrt(k); j++) {
				pq.add(matrix[i][j]);
			}
		}
		for (int i = 0; i < k; i++) {
			res.add(pq.poll());
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 10 }, { 2, 4, 12 }, { 11, 12, 16 } };
		int k = 7;
		List<Integer> res = findSmallestKelement(matrix, k);
		for (int i = 0; i < res.size(); i++)
			System.out.print(res.get(i)+" ");
	}
}
