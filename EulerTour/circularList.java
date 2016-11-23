/**
 * @author :  Panchami Rudrakshi
 */
 package eulergraph;
import java.util.*;

public class circularList<T> implements Iterable<T> {

	/** Class Entry holds a single node of the list */
	public class Entry<T> {
		T element;
		Entry<T> next;

		Entry(T x, Entry<T> nxt) {
			element = x;
			next = nxt;
		}
	}

	// Dummy header is used. tail stores reference of tail element of list
	Entry<T> header, tail;
	private int size;

	circularList() {
		header = new Entry<>(null, null);
		tail = header;
		size = 0;
		tail.next = header;
	}

	public Iterator<T> iterator() {
		return new CLLIterator<>(header);
	}

	private class CLLIterator<E> implements Iterator<E> {
		Entry<E> cursor, prev;

		CLLIterator(Entry<E> head) {
			cursor = head;
			prev = null;
		}

		public boolean hasNext() {
			return cursor.next != null;
		}

		public E next() {
			prev = cursor;
			cursor = cursor.next;
			return cursor.element;
		}

		// To do: error checking
		public void remove() {
			if (cursor.next != null) {
				prev.next = cursor.next;
				cursor = cursor.next;
			} else
				System.out.println("Last element");
		}
	}

	public int getSize() {
		return size;
	}

	// Add new elements to the end of the list
	void add(T x) {
		tail.next = new Entry<>(x, null);
		tail = tail.next;
		tail.next = header.next;
		size++;
	}

    // method to merge the subtours obtained from breakGraphIntoTours
	public void Merge(circularList<T> c) {
		Entry<T> x = header.next;

		if (x != null) {
			do {
				if (x.next.element == c.header.next.element) {
					c.tail.next = x.next;
					x.next = c.header.next;
					break;
				}
				x = x.next;
			} while (x != header.next);
			this.size = this.size + c.size;
		}
	}
	
	//method to print the final euler tour
	void printList() {
		Entry<T> x = header.next;
		//System.out.println(this.size);
		if (x != null) {
			do {
				System.out.println(x.element);
				x = x.next;
			} while (x != header.next);
			//System.out.println(header.next.element);
		}
	}

}
