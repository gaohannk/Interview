package liveramp;

import java.util.LinkedList;
import java.util.Queue;

public class Cities {
	public static int[] solution(int[] T) {
		if (T == null || T.length == 0)
			return new int[0];
		int capitalNum = 0;
		for (int i = 0; i < T.length; i++) {
			if (T[i] == i) {
				capitalNum = i;
				break;
			}
		}
		int res[] = new int[T.length-1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(capitalNum);
		queue.add(-1);
		int depth = 1;
		int count = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			//System.out.println(cur);
			if (cur == -1) {
				//System.out.println(depth);
				res[depth-1] = count;
				count = 0;
				queue.add(-1);
				depth++;
				if (depth > T.length - 1)
					break;
				continue;
			}
			for (int i = 0; i < T.length; i++) {
				if (T[i] == cur && i != cur) {
					queue.add(i);
					count++;
				}
			}
		}
		//res = Arrays.copyOfRange(res, 0, res.length);
		return res;
	}

	public static void main(String[] args) {
		//int T[] = { 9, 1, 4, 8, 0, 4, 8, 9, 0, 1 };
		int T[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 9 };
		int res[] = solution(T);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
