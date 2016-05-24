package google;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

abstract class SortedStream {

	public abstract boolean hasNext();

	public abstract Integer peek();

	public abstract int next();
}

public class MergeSortedStream {

	public List<SortedStream> list;
	public boolean isCache;
	public int index = 0;
	public int cache;
	// PriorityQueue<Integer> pq = new PriorityQueue<>();

	public boolean hasNext() {
		int count = 0;
		while (count < list.size()) {
			if (list.get(count).hasNext())
				return true;
			count++;
		}
		return false;
	}

	public int next() {
		int count = 0;
		int val = Integer.MIN_VALUE;
		while (count < list.size()) {
			if (list.get(index).hasNext()) {
				if (list.get(count).peek() < val) {
					val = list.get(count).peek();
					index = count;
				}
			}
			count++;
		}
		return list.get(index).next();
	}
}
