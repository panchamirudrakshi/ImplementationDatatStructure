/**
 * Class to represent a vertex of a graph
 * @author : pgr150030- Panchami Rudrakshi
 * reference : rbk code
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vertex implements Iterable<Edge> {	
    int name; // name of the vertex
    boolean seen; // flag to check if the vertex has already been visited
    int d;  // duration of task corresponding to vertex
    List<Edge> adj, revAdj; // adjacency list; use LinkedList or ArrayList
    public Vertex parent; //parent of the vertex
    
    public int indegree;	
	public int cno;	
	public int outdegree;
	public int slack;
	int ec;
	int lc;
	int n;

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
	adj = new ArrayList<Edge>();
	revAdj = new ArrayList<Edge>();   /* only for directed graphs */
	cno = 0;	
	parent = null;	
    }

    public Iterator<Edge> iterator() { return adj.iterator(); }

    /**
     * Method to represent a vertex by its name
     */
    public String toString() {
	return Integer.toString(name);
    }
}
