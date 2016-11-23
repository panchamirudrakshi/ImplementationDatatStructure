/** 
 * Skip List Implementation 
 * @author : Panchami Rudrakshi 
 */
import java.util.Iterator;
import java.util.Random;

public class SkipListImpl<T extends Comparable<? super T>> implements
		SkipList<T> {

	Node<T> head, tail;
	int size, maxLevel, currentLength;

	/**
	 * constructor for skip List class to initialize head and tail with value
	 * and max level Size :maximum number of nodes in skip list. maxLevel
	 * :maximum number of pointers that a node can have
	 */

	SkipListImpl() {
		size = 100000000;
		maxLevel = (int) Math.log(100000000);
		int N = maxLevel;
		head = new Node<T>((T) new Long(0), N);
		tail = new Node<T>((T) new Long(Long.MAX_VALUE), N);
		for (int i = maxLevel - 1; i >= 0; i--) {
			head.next[i] = tail;
		}
	}

	/**
	 * constructor for node class Each skip list entry has an array of next
	 * pointers of size between 1 and maxLevel
	 */
	class Node<E> {
		E element;
		Node<E>[] next;
		Node<E> previous;

		Node(E value, int level) {
			this.element = value;
			next = (Node<E>[]) new Node[level];
		}
	}

	/**
	 * Find the previous node to the matching node
	 * 
	 * @param x
	 *            - element to be searched
	 * @return array of nodes(prev[0..maxLevel])
	 */
	Node<T>[] find(T x) {
		Node<T>[] prev = new Node[maxLevel];
		// System.out.println(maxLevel+" "+ prev.length);
		Node<T> p = head;
		for (int i = maxLevel - 1; i >= 0; i--) {
			while (p.next[i].element.compareTo(x) < 0) {
				p = p.next[i];
			}

			prev[i] = p;
		}
		return prev;
	}

	/**
	 * Generate random number between 1 and max level.
	 * 
	 * @param maxLevel
	 */
	public int choice(int maxLevel) {
		Random random = new Random();
		int i = 1;
		while (i < maxLevel) {
			boolean b = random.nextBoolean();
			if (b) {
				i++;
			} else
				break;
		}

		return i;
	}

	/**
	 * method to add element to the skip List using the previous node returned
	 * from find() case 1: If the element exists, it is replaced just replaced.
	 * case 2: To insert a new element, a new node is created at a random level
	 * 
	 * @param x
	 */
	@Override
	public boolean add(T x) {
		Node<T>[] prev = find(x);
		if (prev[0].next[0].element.compareTo(x) == 0) {
			prev[0].next[0].element = x;
			return false;
		} else {
			int lev = choice(maxLevel);
			Node<T> n = new Node<T>(x, lev);
			n.previous = prev[0];
			prev[0].next[0].previous = n;
			for (int i = 0; i < lev; i++) {
				n.next[i] = prev[i].next[i];
				prev[i].next[i] = n;
			}
		}
		currentLength++;
		if (currentLength >= size)
			rebuild();
		return true;
	}

	/**
	 * method to find if an element is present in the skip list
	 */
	@Override
	public boolean contains(T x) {
		Node<T>[] prev = find(x);
		return prev[0].next[0].element.compareTo(x) == 0;
	}

	/**
	 * method to find the element at the index position n
	 */
	@Override
	public T findIndex(int n) {
		Node<T> p = head.next[0];
		int i = 0;
		while (p.element.compareTo(tail.element) != 0) {
			if (i == n)
				return p.element;
			else {
				p = p.next[0];
				i++;
			}
		}
		return null;
	}

	@Override
	public T first() {
		if (head.next[0].element.compareTo(tail.element) != 0)
			return head.next[0].element;
		return null;
	}

	/**
	 * method to find the last element in the skiplist returns the value if
	 * found else returns null
	 */
	@Override
	public T last() {
		if (tail.previous.element.compareTo(head.element) != 0)
			return tail.previous.element;
		return null;
	}

	/**
	 * method to find the Greatest element that is <= x
	 */
	@Override
	public T floor(T x) {
		Node<T>[] prev = find(x);
		if (prev[0].next[0].element.compareTo(x) == 0) {
			// System.out.println("Found:"+x);
			return x;
		} else if (prev[0].element.compareTo(x) < 0) {
			// System.out.println("Floor:"+prev[0].next[0].element);
			return prev[0].element;
		}
		return null;
	}

	/**
	 * method to find least element that is >= x
	 */
	@Override
	public T ceiling(T x) {
		Node<T>[] prev = find(x);
		if (prev[0].next[0].element.compareTo(x) == 0) {
			// System.out.println("Found:" + x);
			return x;
		} else if (prev[0].next[0].element.compareTo(x) > 0) {
			// System.out.println("ceiling:" + prev[0].next[0].element);
			return prev[0].next[0].element;
		}
		return null;

	}

	/**
	 * method to find if the skiplist is empty
	 */
	@Override
	public boolean isEmpty() {
		if (head.next[0].element.compareTo(tail.element) != 0)
			return false;
		return true;

	}

	/**
	 * Removes an element from Skip List by setting previous pointers to the
	 * next pointers of the node to be deleted
	 * 
	 * @param x
	 */
	@Override
	public T remove(T x) {
		Node<T>[] prev = find(x);
		Node<T> n = prev[0].next[0];
		// if the element in not present then return null
		if (n.element.compareTo(x) != 0)
			return null;
		else {
			// copy the references
			prev[0].next[0].next[0].previous = prev[0];
			for (int i = 0; i < maxLevel; i++) {
				if (prev[i].next[i] == n)
					prev[i].next[i] = n.next[i];
				else
					break;
			}
		}
		currentLength--;
		// System.out.println(n.element);
		return n.element;
	}

	// method to return the size of the skiplist
	@Override
	public int size() {
		return currentLength;
	}

	/**
	 * method to rebuild the skiplist to set the levels at 2i nodes away copy
	 * all the current elements in the list initialize the head and tail with
	 * the new maxLevel add the elements back to the list after the rebuilding
	 */
	@Override
	public void rebuild() {
		size += size;
		maxLevel = (int) Math.round(Math.log(size) / Math.log(2));
		T[] input = (T[]) new Comparable[currentLength];
		Node<T> z = head.next[0];
		int i = 0;
		while (z.element.compareTo(tail.element) != 0) {
			input[i++] = z.element;
			z = z.next[0];
		}

		head.next = new Node[maxLevel];
		tail.next = new Node[maxLevel];
		for (int j = 0; j < maxLevel; j++)
			head.next[j] = tail;

		currentLength = 0;
		for (T p : input)
			add(p);
	}

	public Iterator<T> iterator() {
		return new SKipListIterator<>(head);
	}

	private class SKipListIterator<T> implements Iterator<T> {
		Node<T> cursor, previous;

		SKipListIterator(Node<T> head) {
			cursor = head;
			previous = null;
		}

		public boolean hasNext() {
			return cursor.next[0] != tail;
		}

		public T next() {

			previous = cursor;
			cursor = cursor.next[0];
			return (T) cursor.next[0].element;
		}

		public void remove() {
			if (cursor.next[0] != tail) {
				previous.next[0] = cursor.next[0];
				cursor = cursor.next[0];
			} else
				System.out.println("Last element");
		}
	}

}