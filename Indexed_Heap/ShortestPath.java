/**
 * @author : pgr150030- Panchami Rudrakshi
 * reference : rbk lecture 16 notes - indexed heaps and priority queue
 * Dijkstra'a algorithm for shortest paths using indexed heaps,
 * @param connected graph , source vertex
 * @return shortest distance  
 */
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class ShortestPath {
	static final int Infinity = Integer.MAX_VALUE;

	static void DijkstraShortestPaths(Graph g, Vertex s) {

		for (Vertex vertex : g) {
			vertex.setSeen(false);
			vertex.setParent(null);
			vertex.setDist(Infinity);
		}

		IndexedHeap<Vertex> q = new IndexedHeap<Vertex>(g.v.toArray(new Vertex[g.v.size()]), new Vertex());

		s.setDist(0);

		while (!q.isEmpty()) {
			Vertex u = (Vertex) q.remove();
			u.setSeen(true);
			for (Edge edge : u.getAdj()) {
				Vertex v = edge.otherEnd(u);
				if (!v.isSeen() && (u.getDist() + edge.getWeight()) < v.getDist()) {
					v.setDist(u.getDist() + edge.getWeight());
					v.setParent(u);
					q.decreaseKey(v);
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in;

		if (args.length > 0) {
			File inputFile = new File(args[0]);
			in = new Scanner(inputFile);
		} else {
			in = new Scanner(System.in);
		}

		Graph g = Graph.readGraph(in);
		int src = in.nextInt();
		int target = in.nextInt();
		Vertex s = g.getVertex(src);
		Vertex t = g.getVertex(target);
		DijkstraShortestPaths(g, s);
		System.out.println(t.d);
	}
}
