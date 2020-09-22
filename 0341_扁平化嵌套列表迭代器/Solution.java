import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
	// =====================================================================
	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	// =======================================================================

	Deque<NestedInteger> deque = new ArrayDeque<NestedInteger>();

	public NestedIterator(List<NestedInteger> nestedList) {
		for (int i = nestedList.size() - 1; i >= 0; --i) {
			deque.offerFirst(nestedList.get(i));
		}
	}

	@Override
	public boolean hasNext() {
		if (deque.isEmpty()) {
			return false;
		} else {
			if (deque.peekFirst().isInteger()) {
				return true;
			} else {
				List<NestedInteger> ni = deque.pollFirst().getList();
				for (int i = ni.size() - 1; i >= 0; --i) {
					deque.offerFirst(ni.get(i));
				}

				return hasNext();
			}
		}

	}

	@Override
	public Integer next() {
		return deque.pollFirst().getInteger();
	}

}
