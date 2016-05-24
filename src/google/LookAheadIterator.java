package google;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LookAheadIterator {
	public Iterator<Integer> it;
	public int cache;
	public boolean isCache;

	public LookAheadIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		it = iterator;
		isCache = false;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer ahead() {
		if (isCache)
			return cache;
		throw new NoSuchElementException();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
		if (!isCache)
			isCache = true;
		cache = it.next();
		return cache;
	}

	public boolean hasNext() {
		return it.hasNext();
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		LookAheadIterator it = new LookAheadIterator(list.iterator());

		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.ahead());
		System.out.println(it.ahead());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.ahead());
		System.out.println(it.hasNext());
	}
}
