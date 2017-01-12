/**
 * Class to represent a graph
 * Methods to find EC, LC, indegree and outdegree
 * @author : pgr150030- Panchami Rudrakshi
 reference : critical_shortest_paths_in _DAG (lecture 24 rbk notes)
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Graph implements Iterable<Vertex> {
	List<Vertex> v; // vertices of graph
	int size; // number of vertices in the graph
	boolean directed; // true if graph is directed, false otherwise

	/**
	 * Constructor for Graph
	 * 
	 * @param size
	 *            : int - number of vertices
	 */
	Graph(int size) {
		this.size = size;
		this.v = new ArrayList<>(size + 1);
		this.v.add(0, null); // Vertex at index 0 is not used
		this.directed = true; // default is undirected graph
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
		return this.v.get(n);
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
		if (this.directed) {
			from.adj.add(e);
			to.revAdj.add(e);
		} else {
			from.adj.add(e);
			to.adj.add(e);
		}
	}

	/**
	 * Method to create iterator for vertices of graph
	 */
	public Iterator<Vertex> iterator() {
		Iterator<Vertex> it = this.v.iterator();
		it.next(); // Index 0 is not used. Skip it.
		return it;
	}

	// Run BFS from a given source node
	// Precondition: nodes have already been marked unseen
	public void bfs(Vertex src) {
		src.seen = true;
		src.d = 0;
		Queue<Vertex> q = new LinkedList<>();
		q.add(src);
		System.out.println(src);
		while (!q.isEmpty()) {
			Vertex u = q.remove();
			for (Edge e : u.adj) {
				Vertex v = e.otherEnd(u);
				if (!v.seen) {
					v.seen = true;
					v.d = u.d + 1;
					q.add(v);
					System.out.print(v);
				}
				// System.out.println(v);
			}
		}
	}

	// Check if graph is bipartite, using BFS
	public boolean isBipartite() {
		for (Vertex u : this) {
			u.seen = false;
		}
		for (Vertex u : this) {
			if (!u.seen) {
				bfs(u);
			}
		}
		for (Vertex u : this) {
			for (Edge e : u.adj) {
				Vertex v = e.otherEnd(u);
				if (u.d == v.d) {
					return false;
				}
			}
		}
		return true;
	}

	// read a directed graph using the Scanner interface
	public static Graph readDirectedGraph(Scanner in) {
		return readGraph(in, true);
	}

	// read an undirected graph using the Scanner interface
	public static Graph readGraph(Scanner in) {
		return readGraph(in, false);
	}

	public static Graph readGraph(Scanner in, boolean directed) {
		// read the graph related parameters
		int n = in.nextInt(); // number of vertices in the graph
		int m = in.nextInt(); // number of edges in the graph
		// create a graph instance
		Graph g = new Graph(n);
		g.directed = directed;
		for (int i = 0; i < m; i++) {
			int u = in.nextInt();
			int v = in.nextInt();
			int w = in.nextInt();
			g.addEdge(g.getVertex(u), g.getVertex(v), w);
		}
		return g;
	}

	void calcIndegree(Graph g) {
		for (Vertex u : g) {
			u.indegree = 0;
		}

		for (Vertex u : g) {
			for (Edge e : u.adj) {
				Vertex v = e.otherEnd(u);
				v.indegree = v.indegree + 1;
			}
		}
	}

	void calcOutdegree(Graph g) {
		for (Vertex u : g) {
			u.outdegree = 0;
		}
		for (Vertex u : g) {
			for (Edge e : u.revAdj) {
				Vertex v = e.otherEnd(u);
				v.outdegree = v.outdegree + 1;
			}
		}
	}

	void CalcEc(List<Vertex> lst, Graph g) {
		int num = g.size;
		int s = num - 1;
		Vertex s1 = this.getVertex(s);
		s1.ec = 0;
		for (Vertex u : g) {
			u.ec = 0;
		}
		for (Vertex u : lst) {
			for (Edge e : u.adj) {
				Vertex v = e.otherEnd(u);
				v.ec = Math.max(v.ec, (u.ec + v.d));
			}
		}

	}

	void CalcLc(List<Vertex> lst, Graph g) {
		int num = g.size;
		int t = num;
		Vertex t1 = g.getVertex(t);
		t1.lc = t1.ec;
		for (Vertex u : g) {
			u.lc = t1.lc;
		}
		
		for (Vertex u : lst) {
			for (Edge e : u.revAdj) {
				Vertex p = e.otherEnd(u);
				p.lc = Math.min(p.lc, (u.lc - u.d));
				p.slack = p.lc - p.ec;
			}
		}
	}

	static List<Vertex> DFSTop(Graph g) {
		List<Vertex> stack = new LinkedList<>();

		for (Vertex v : g) {
			v.parent = null;
			v.seen = false;
			v.cno = 0;
		}
		int cno = 0;

		for (Vertex v : g) {
			if (!v.seen) {
				v.cno = ++cno;
				DFSVisit(v, stack);
			}
		}
		if (stack.size() == g.size)
			return stack;
		else
			return null;
	}

	/**
	 * Private method for DFS
	 * 
	 * @param u:
	 *            Vertex - DFS on this vertex
	 * @param stack:
	 *            ArrayDeque<Vertex> - to store the topological order of
	 *            vertices
	 * @throws CyclicGraphException
	 *             exception to be thrown when cycle is encountered in the graph
	 */
	public static void DFSVisit(Vertex u, List<Vertex> stack) {
		u.seen = true;
		for (Edge e : u.adj) {
			Vertex v = e.otherEnd(u);
			if (!v.seen) {
				v.parent = u;
				v.cno = u.cno;
				DFSVisit(v, stack);
			}
		}

		stack.add(u);
	}

	/**
	 * Method for BFS - calls another method that implements BFS from first
	 * vertex
	 * 
	 * @param g:
	 *            Graph
	 */
	public static void BFS(Graph g) {
		for (Vertex v : g)
			v.seen = false;
		for (Vertex v : g)
			if (!v.seen)
				BFS(g, v);
	}

	/**
	 * Method to implement the BFS
	 * 
	 * @param g:
	 *            Graph
	 * @param v:
	 *            vertex - start of BFS
	 */
	public static void BFS(Graph g, Vertex v) {
		Queue<Vertex> vertexVisited = new LinkedList<>();// visited vertices
		v.seen = true;
		v.d = 0;
		vertexVisited.add(v);

		/*
		 * Remove vertex from the queue and check its adjacent vertices. Mark
		 * the adjacent vertices and add it to the queue. Repeat till the queue
		 * is empty i.e all the vertices are visited.
		 * 
		 * Distance of the vertices is the distance starting vertex v
		 */
		while (!vertexVisited.isEmpty()) {
			Vertex u = vertexVisited.remove();
			for (Edge e : u.adj) {
				Vertex w = e.otherEnd(u);
				if (!w.seen) {
					w.seen = true;
					w.parent = u;
					w.d = u.d + 1;
					vertexVisited.add(w);
				}
			}
		}
	}

}
