/**
 * @author : Panchami Rudrakshi
 * reference : rbk lecture 16 notes - indexed heaps and priority queue
 * Prim2 (priority queue of vertices, using indexed heaps),
 * @param connected graph , source vertex
 * @return wMST : weight of the MST  
 */
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class MST {
	static final int Infinity = Integer.MAX_VALUE;

	static int PrimMST(Graph g, Vertex s) {
		int wMST = 0;

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
			wMST += u.getDist();
			for (Edge edge : u.getAdj()) {
				Vertex v = edge.otherEnd(u);
				if (!v.isSeen() && (edge.getWeight() < v.getDist())) {
					v.setDist(edge.getWeight());
					v.setParent(u);
					q.decreaseKey(v);
				}
			}
		}
		return wMST;
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
		Vertex s = g.getVertex(1);
		System.out.println(PrimMST(g, s));
	}
}
