/**
 * @author : pgr150030- Panchami Rudrakshi
 * reference : pq-operations.txt (rbk notes)
 * Binary heap implementation of priority queues
 * pq[] : array of elements.  
 * size : stores how many elements are currently in the heap, stored in pq[1..size].  
 * pq[0] is not used.
 */

import java.util.Comparator;

public class BinaryHeap<T> implements PQ<T> {

	Object[] pq;
	Comparator<T> c;
	private int size;

	// Build a priority queue with a given array
	BinaryHeap(T[] q, Comparator<T> comp) {
		pq = q;
		size = q.length - 1;
		c = comp;
		buildHeap();
	}

	// create an empty priority queue of given maximum size
	public BinaryHeap(int n, Comparator<T> comp) {
		c = comp;
		pq = (T[]) new Object[n + 1];
		size = 0;
	}

	// Insert new element into the heap
	public void insert(T x) {
		add(x);
	}

	// delete the root element in the heap
	public T deleteMin() {
		if (size == 0)
			return null;
		return remove();
	}

	// Return the root element in the heap which would be the maximum or minimum
	// element depending upon the comparator

	public T min() {
		return peek();
	}

	// add an element into the heap

	public void add(T x) {
		if (pq.length - 1 == size)
			resize();
		size++;
		pq[size] = x;
		percolateUp(size);
	}

	// utility function to resize array when it is full
	public void resize() {
		Object[] newPriorityQueue = pq;
		pq = (Object[]) new Object[2 * size];
		for (int i = 0; i <= size; i++)
			pq[i] = newPriorityQueue[i];
	}

	void percolateUp(int m) {
		int i = m;
		T y = (T) pq[m];
		pq[0] = y;
		while (c.compare((T) pq[0], (T) pq[i / 2]) < 0) {
			setIndex(i, i / 2);
			i /= 2;
		}
		setIndex(i, 0);
	}

	// Remove the minimum or maximum element based on the comparator type
	public T remove() {
		T value = peek();
		pq[1] = pq[size--];
		percolateDown(1);
		return value;
	}

	// Remove the minimum or maximum element based on the comparator type
	public T peek() {
		if (size == 0) {
			return null;
		}
		return (T) pq[1];
	}

	void percolateDown(int m) {
		pq[0] = pq[m];
		int child;
		// if i*2 >size, it will break
		while (2 * m <= size) {
			// if(2*i = size-> 1 child)
			child = 2 * m;
			// System.out.println("****"+child);

			// get the minimum of the left child and right child
			if (child < size && c.compare((T) pq[child], (T) pq[child + 1]) > 0)
				child++;

			if ((c.compare((T) pq[child], (T) pq[0])) < 0) {
				setIndex(m, child);
			} else {
				break;
			}
			m = child;
		}
		setIndex(m, 0);
	}

	// build a heap
	void buildHeap() {
		for (int i = size / 2; i > 0; i--) {
			percolateDown(i);
		}
	}

	// check if the heap is empty or not
	public boolean isEmpty() {
		return size == 0;
	}

	// assign the index
	public void setIndex(int m, int n) {
		pq[m] = pq[n];
	}
}

class IntegerComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return (o1 - o2);
	}
}
