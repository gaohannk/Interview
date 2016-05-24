package google;

/* Given a list which can can contain elements as well as lists, write an iterator to flatten a nested list. 
 * Please make this code better and suggest any improvements.
 * 
 */
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class FlattenIterator implements Iterator {

	private final Stack<Iterator> iteratorStack;

	private Object next;

	public FlattenIterator(List list) {
		if (list == null) {
			throw new NullPointerException();
		}

		iteratorStack = new Stack<Iterator>();
		iteratorStack.push(list.iterator());
	}

	private void moveToNext() {
		if ((next == null) && !iteratorStack.empty()) {
			if (iteratorStack.peek().hasNext()) {
				final Object next = iteratorStack.peek().next();
				if (next instanceof Iterator) {
					iteratorStack.push((Iterator) next);
					moveToNext();
				} else if (next instanceof Iterable) {
					iteratorStack.push(((Iterable) next).iterator());
					moveToNext();
				} else if (next instanceof Array) {
					iteratorStack.push(Arrays.asList((Array) next).iterator());
					moveToNext();
				} else {
					this.next = next;
				}
			} else {
				iteratorStack.pop();
				moveToNext();
			}
		}
	}

	public boolean hasNext() {
		moveToNext();
		return next != null;
	}

	public Object next() {
		moveToNext();
		if (next == null) {
			throw new NoSuchElementException();
		} else {
			Object objectToReturn = next;
			next = null;
			return objectToReturn;
		}
	}
}