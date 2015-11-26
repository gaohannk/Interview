package pocketgems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Solution {
	public static void main(String[] args) {
		int[] num = { 3, 5, 8, 1, 3, 2, 7, 9, 2, 3, 1, 2, 3 };
		ArrayList<Integer> list = findKfrequency(num, 4);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	static class Pair {
		int val;
		int feq;

		Pair(int val, int feq) {
			this.val = val;
			this.feq = feq;
		}
	}

	public static Comparator<Pair> comp = new Comparator<Pair>() {
		public int compare(Pair p1, Pair p2) {
			if (p1.feq > p2.feq)
				return -1;
			else if (p1.feq < p2.feq)
				return 1;
			else
				return 0;
		}
	};

	public static ArrayList<Integer> findKfrequency(int[] num, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			if (map.containsKey(num[i])) {
				map.put(num[i], map.get(num[i] + 1));
			} else {
				map.put(num[i], 1);
			}
		}
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(map.size(), comp);
		Iterator<Integer> it = (Iterator<Integer>) map.keySet().iterator();

		while (it.hasNext()) {
			Integer integer = (Integer) it.next();
			Pair pair = new Pair(integer, map.get(integer));
			pq.add(pair);
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < k; i++) 
			list.add(pq.poll().val);
		return list;
	}
}
