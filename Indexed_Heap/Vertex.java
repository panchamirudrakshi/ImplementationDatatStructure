/**
 * Class to represent a vertex of a graph
 * @author :Panchami Rudrakshi
 * reference : rbk code
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Vertex implements Index, Comparator<Vertex>, Iterable<Edge> {
	int name; // name of the vertex
	boolean seen; // flag to check if the vertex has already been visited
	int d; // fields used in algorithms of Prim and Dijkstra
	Vertex p; // fields used in algorithms of Prim and Dijkstra
	List<Edge> adj, revAdj; // adjacency list; use LinkedList or ArrayList
	public int index;

	public int getIndex() {
		return this.index;
	}

	public void putIndex(int i) {
		this.index = i;
	}

	public int compare(Vertex u, Vertex v) {
		if (u.d > v.d)
			return 1;
		else if (u.d == v.d)
			return 0;
		else
			return -1;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public List<Edge> getAdj() {
		return adj;
	}

	Vertex() {
	}

	public void setAdj(List<Edge> adj) {
		adj = adj;
	}

	public void setParent(Vertex parent) {
		this.p = parent;
	}

	public void setDist(int distance) {
		this.d = distance;
	}

	public int getDist() {
		return d;
	}

	/**
	 * Constructor for the vertex
	 * 
	 * @param n
	 *            : int - name of the vertex
	 */
	Vertex(int n) {
		name = n;
		seen = false;
		d = Integer.MAX_VALUE;
		p = null;
		adj = new ArrayList<Edge>();
		revAdj = new ArrayList<Edge>(); /* only for directed graphs */
	}

	public Iterator<Edge> iterator() {
		return adj.iterator();
	}

	/**
	 * Method to represent a vertex by its name
	 */
	public String toString() {
		return Integer.toString(name);
	}
}
