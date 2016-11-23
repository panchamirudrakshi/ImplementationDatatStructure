package eulergraph;
import java.util.*;

/**
* Class to represent a vertex
* @author :Panchami Rudrakshi
*/

public class Vertex {
	int name;// name of the vertex
	List<Edge> adjacent;// flag to check if the vertex has already been visited
	boolean visited;// adjacency list; use LinkedList or ArrayList

	/**
	 * Constructor for the vertex
	 * 
	 * @param n
	 *            : int - name of the vertex
	 */
	public Vertex(int n) {
		name = n;
		visited = false;
		adjacent = new ArrayList<Edge>();
	}

	//Gives adjacent edge of a vertex
	public List<Edge> getAdjacentEdge() {
		return adjacent;
	}

	public void setAdjacentEdge(List<Edge> adj) {
		adjacent = adj;
	}

	//checks if an edge is visited or not
	public boolean haveUnvisitedEdges() {
		for (Edge edge : adjacent) {
			if (!edge.isEdgeVisisted()) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return Integer.toString(name);
	}

	public void setVisited(boolean b) {
		visited = b;
	}
}