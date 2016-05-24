package google;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class JumpIterator {
	public Iterator<Integer> it;
	public int cache;
	public boolean isCache;

	public JumpIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		it = iterator;
		isCache = false;
	}

	public boolean hasNext() {
		if (!isCache) {
			while (it.hasNext()) {
				it.next();
				if (it.hasNext()) {
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
			return it.next();
		}
		it.next();
		return it.next();
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		JumpIterator it = new JumpIterator(list.iterator());

		System.out.println(it.hasNext());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
	}
}
