package google;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class EvenIterator {
	public Iterator<Integer> it;
	public int cache;
	public boolean isCache;

	public EvenIterator(Iterator<Integer> iterator) {
		this.it = iterator;
		this.isCache = false;
	}

	public boolean hasNext() {
		if (!isCache) {
			while (it.hasNext()) {
				int val = it.next();
				if (val % 2 == 0) {
					cache = val;
					isCache = true;
					return true;
				}
			}
			return false;
		}
		return true;
	}

	public Integer next() {
		if (isCache) {
			isCache = false;
			return cache;
		}
		while (it.hasNext()) {
			int val = it.next();
			if (val % 2 == 0)
				return val;
		}
		throw new NoSuchElementException();
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(10);
		list.add(21);
		list.add(31);
		list.add(40);
		list.add(2);
		list.add(9);
		list.add(4);
		EvenIterator it = new EvenIterator(list.iterator());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());

	}
}
