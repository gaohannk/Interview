package twitter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* 1<= A<= M;
   1<= B<= N;
   (A^1/3 + B^1/3)^3 is an integer;
*/
public class SpecialCube {
	public int cube(int M, int N) {
		int a = 1;
		int b = 1;
		int count = 0;
		List<int[]> res = new LinkedList<int[]>();
		List<Integer> lista = new LinkedList<>();
		List<Integer> listb = new LinkedList<>();
		while (Math.pow(a, 3) < M) {
			lista.add(a);
			a++;
		}
		while (Math.pow(b, 3) < M) {
			lista.add(b);
			b++;
		}
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		b = 1;
		while (b++ <= N) {
			for (int numA : lista) {
				a = b * numA;
				if (a <= M) {
					count++;
					if (!map.containsKey(a))
						map.put(a, new HashSet<Integer>());
					map.get(a).add(b);
					res.add(new int[] { a, b });
				} else
					break;
			}
		}
		a = 1;
		while (a++ < M) {
			for (int numB : listb) {
				b = a * numB;
				if (b <= N) {
					count++;
					if (!map.containsKey(b))
						map.put(b, new HashSet<Integer>());
					map.get(b).add(a);
					res.add(new int[] { b, a });
				} else
					break;
			}
		}
		return count;
	}
}
