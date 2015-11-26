package pocketgems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class FindkFrequencyNumber {
	public static  ArrayList<Integer> findkfrequencynumber(int[] num, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			if (!map.containsKey(num[i]))
				map.put(num[i], 1);
			else
				map.put(num[i], map.get(num[i]) + 1);
		}
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(map.size(),comparator);
		Iterator<Integer> it = (Iterator<Integer>) map.keySet().iterator();
		while (it.hasNext()) {
			Integer integer = (Integer) it.next();
			Pair pair = new Pair(integer,map.get(integer));
			pq.add(pair);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < k; i++) {
			list.add(pq.poll().num);
		}
		return list;
	}

	public static Comparator<Pair> comparator = new Comparator<Pair>() {

		@Override
		public int compare(Pair o1, Pair o2) {
			if (o1.freq > o2.freq)
				return -1;
			else if (o1.freq < o2.freq) {
				return 1;
			}
			return 0;
		}
	};

	static class Pair {
		int num;
		int freq;

		Pair(int num, int freq) {
			this.num = num;
			this.freq = freq;
		}
	}

	public static void main(String[] args) {
		int[] num={1,1,1,8,4,8,8,5,5,5,8,1,1,8,4,1,1,3};
		ArrayList<Integer> list= findkfrequencynumber(num, 3);
		for (int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
