package eulergraph;

/**
* Class to represent a graph
* @author :  Panchami Rudrakshi
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Graph implements Iterable<Vertex> {
	List<Vertex> v; // vertices of graph
	int size; // number of vertices in the graph
	List<Edge> edges = new ArrayList<Edge>();

	/**
	 * Constructor for Graph
	 * 
	 * @param size
	 *            : int - number of vertices
	 */
	Graph(int size) {
		this.size = size;
		this.v = new ArrayList<>(size + 1);// arrayList starts from index 0, so
											// add one more index to store 6
											// vertex
		this.v.add(0, null); // Vertex at index 0 is not used
		// create an array of Vertex objects
		for (int i = 1; i <= size; i++)
			this.v.add(i, new Vertex(i));
	}

	/**
	 * Find vertex no. n
	 * 
	 * @param n
	 *            : int
	 */
	Vertex getVertex(int n) {
		return this.v.get(n); // go to the arrayList and return the element at
								// nth position
	}

	/**
	 * Method to add an edge to the graph
	 * 
	 * @param a
	 *            : int - one end of edge
	 * @param b
	 *            : int - other end of edge
	 * @param weight
	 *            : int - the weight of the edge
	 */
	void addEdge(Vertex from, Vertex to, int weight) {
		Edge e = new Edge(from, to, weight);
		from.adjacent.add(e); // doubt
		to.adjacent.add(e);// doubt
		edges.add(e);
	}

	/**
	 * Method to create iterator for vertices of graph
	 */
	public Iterator<Vertex> iterator() {
		Iterator<Vertex> it = this.v.iterator();
		it.next(); // Index 0 is not used. Skip it.
		return it;
	}

	public static Graph readGraph(Scanner in) {
		System.out.println("Please enter dimensions of the graph followed by edges in format (from, to, weight)");
		// read the graph related parameters
		int n = in.nextInt(); // number of vertices in the graph
		int m = in.nextInt(); // number of edges in the graph

		// create a graph instance
		Graph g = new Graph(n);

		for (int i = 1; i <= m; i++) {
			int u = in.nextInt();
			int v = in.nextInt();
			int w = in.nextInt();
			g.addEdge(g.getVertex(u), g.getVertex(v), w);
		}
		in.close();
		return g;
	}

	/**
	 * This method breaks the  input graph into various subtours	 
	 * @param graph
	 * @return list of sub tours
	 */
	public static List<circularList<Vertex>> breakGraphIntoTours(Graph g) {
		List<circularList<Vertex>> cll = new ArrayList<circularList<Vertex>>();
		for (Vertex vertex : g) {
			vertex.setVisited(false);
		}

		for (Vertex vertex : g) {
			/**
			 * Loop until there are vertices with enabled edges.
			 */
			if (vertex.haveUnvisitedEdges()) {
				vertex.setVisited(true);
				
				Vertex root = vertex;
				Vertex current = root;
				Vertex start = root;

				circularList<Vertex> eulerTour = new circularList<Vertex>();
				
				do {
					current.setVisited(true);

					start = current;
					int i = 0;
					for (int j=0; j< current.getAdjacentEdge().size();j++) {
						if (!current.getAdjacentEdge().get(j).isEdgeVisisted()) {							
							current.getAdjacentEdge().get(j).setEdgeVisited(true);
							start = current;
							current = current.getAdjacentEdge().get(j).otherEnd(current);
							eulerTour.add(start);
							i=j;
							break;
						}	
					}
					if (start == current) {
						current.getAdjacentEdge().get(i).setEdgeVisited(false);
						eulerTour=null;
						break;
					}	
				} while (current != root);
				
				if(eulerTour!=null){
				cll.add(eulerTour);
				//System.out.print("Eulergraph sub tours of size : ");				
				//eulerTour.printList();	
				}		
			}
		}
		return cll;
	}
	
	/**
	 * This method merges all cycles obtained from breakGraphIntoTours
	 * @param subTours
	 * @return primaryCycle- Euler tour
	 */
	
	public static circularList<Vertex> stitchTours(List<circularList<Vertex>> subTours) {
		circularList<Vertex> primaryCycle = null;
		if (subTours.size() != 0) {
			primaryCycle = subTours.get(0);
			for (int j = 1; j < subTours.size(); j++) {
				primaryCycle.Merge(subTours.get(j));
			}
		}
		return primaryCycle;
	}

	/**
	 * This method verifies the validity of the tour
	 * 
	 * */
	
	public static boolean verifyTour(Graph g, circularList<Vertex> tour) {
        Iterator<Vertex> r=	g.iterator();
        while (r.hasNext())
        {
        	Vertex a = r.next();
        	if(a.haveUnvisitedEdges())
        	{
        		//System.out.println("False");
        		return false;
        	}
        }
		return true;
	}
}
