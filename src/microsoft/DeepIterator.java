package microsoft;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class DeepIterator implements Iterator<Integer> {
	private Stack<Iterator<Integer>> iteratorStack = new Stack<Iterator<Integer>>();
	private Integer top = null;

	public DeepIterator(Iterable<Integer> iterable) {
		this.iteratorStack.push(iterable.iterator());
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean hasNext() {
		if (this.top != null)
			return true;

		while (!this.iteratorStack.isEmpty()) {
			Iterator<Integer> tmpIterator = this.iteratorStack.peek();
			if (tmpIterator.hasNext()) {
				Object tmp = tmpIterator.next();
				if (tmp instanceof Integer) {
					this.top = (Integer) tmp;
					return true;
				} else if (tmp instanceof Iterable) {
					this.iteratorStack.push(((Iterable<Integer>) tmp).iterator());
				} else {
					throw new RuntimeException("Unsupported data type. ");
				}
			} else {
				this.iteratorStack.pop();
			}
		}
		return false;
	}

	@Override
	public Integer next() throws NoSuchElementException {
		if (hasNext()) {
			Integer tmp = this.top;
			this.top = null;
			return tmp;
		}

		throw new NoSuchElementException();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("This is not supported right now.");
	}
}
