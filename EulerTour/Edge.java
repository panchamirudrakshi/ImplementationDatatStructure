package eulergraph;

/**
* @author : Panchami Rudrakshi
* Class to represent an edge
*/

public class Edge {
	Vertex from;// head vertex
	Vertex to;// tail vertex
	int weight;// weight of edge
	boolean disabled;
	
	/**
  * Constructor for Edge
  * 
  * @param u
  *            : Vertex - Vertex from which edge starts
  * @param v
  *            : Vertex - Vertex on which edge lands
  * @param w
  *            : int - Weight of edge
  */
	public Edge(Vertex u, Vertex v, int w) {
		from = u;
		to = v;
		weight = w;
	}
	
	/**
  * Method to find the other end end of an edge, given a vertex reference
  * This method is used for undirected graphs
  * 
  * @param u
  *            : Vertex
  * @return
		  : Vertex - other end of edge
  */
	public Vertex otherEnd(Vertex u) {
		if (from == u) {
			return to;
		}
		else {
			return from;
		}
	}
	
	public Vertex getFrom() {
		return from;
	}
		
	public Vertex getTo() {
		return to;
	}
	 
	public void setFrom(Vertex from) {
		this.from = from;		
	}
	
	public void setTo(Vertex to) {
		this.to = to;
	}
	
	public boolean isEdgeVisisted() {
		return disabled;
	}

	public void setEdgeVisited(boolean disabled) {
		this.disabled = disabled;
	}
	}