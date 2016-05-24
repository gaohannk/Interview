package google;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class RotateIterator implements Iterator<Integer> {
	public List<Iterator<Integer>> list;
	public int index = 0;

	public RotateIterator(List<Iterator<Integer>> list) {
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		int count = 0;
		while (true) {
			if (list.get(index).hasNext())
				return true;
			index++;
			count++;
			if (count == list.size())
				return false;
			index %= list.size();
		}
	}

	@Override
	public Integer next() {
		int count = 0;
		while (true) {
			if (list.get(index).hasNext()) {
				int val = list.get(index).next();
				index++;
				index %= list.size();
				return val;
			}
			index++;
			index %= list.size();
			count++;
			if (count == list.size())
				throw new NoSuchElementException();
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(4);
		list.add(7);
		list.add(9);
		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(2);
		list2.add(5);
		LinkedList<Integer> list3 = new LinkedList<>();
		list3.add(3);
		list3.add(6);
		list3.add(8);
		LinkedList<Iterator<Integer>> itlist = new LinkedList<>();
		itlist.add(list.iterator());
		itlist.add(list2.iterator());
		itlist.add(list3.iterator());

		RotateIterator it = new RotateIterator(itlist);

		System.out.println(it.hasNext());
		for (int i = 0; i < 9; i++) {
			System.out.println(it.next());
		}
		System.out.println(it.hasNext());
	}
}
