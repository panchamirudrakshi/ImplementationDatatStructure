/**
 * Implementation of Indexed heap
 * @author : Panchami Rudrakshi 
 * reference : rbk code 
 */
import java.util.Comparator;

public class IndexedHeap<T extends Index> extends BinaryHeap<T> {
	/** Build a priority queue with a given array q */
	IndexedHeap(T[] q, Comparator<T> comp) {
		super(q, comp);
		for (int i = 0; i < super.pq.length; i++) {
			((T) super.pq[i]).putIndex(i);
		}
	}

	/** Create an empty priority queue of given maximum size */
	IndexedHeap(int n, Comparator<T> comp) {
		super(n, comp);
	}

	/** restore heap order property after the priority of x has decreased */
	void decreaseKey(T x) {
		percolateUp(x.getIndex());
	}

	public void setIndex(int i, int j) {
		super.setIndex(i, j);
		((T) pq[i]).putIndex(j);
	}
}
