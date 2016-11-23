/**
 * @author : Panchami Rudrakshi
 * reference : rbk lecture 15 notes - binary heaps and priority queue
 * Prim1 (priority queue of edges; using Java's priority queues)
 * @param connected graph , source vertex
 * @return wMST : weight of the MST  
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Prims1 {

	public static int Prim1MST(Graph g, Vertex s) {

		int wMST = 0;
		// set each vertex to unseen and parent to null
		for (Vertex vertex : g) {
			vertex.setSeen(false);
			vertex.setParent(null);
		}

		Queue<Edge> primqueue = new PriorityQueue<Edge>(new Comparator<Edge>() {

			public int compare(Edge o1, Edge o2) {
				return o1.getWeight() - o2.getWeight();
			}
		});

		// add all edges to the priority Queue.
		for (Edge edge : s.getAdj()) {
			primqueue.add(edge);
		}

		// set parent to seen
		s.setSeen(true);
		Vertex u = null;
		Vertex v = null;

		// find the minimum weight edge and go on removing them until the queue
		// is empty
		while (!primqueue.isEmpty()) {
			Edge e = primqueue.remove();
			if (!(e.getFrom().isSeen() && e.getTo().isSeen())) {

				if (e.getFrom().isSeen()) {
					u = e.getFrom();
					v = e.getTo();
				} else {
					v = e.getFrom();
					u = e.getTo();
				}

				v.setSeen(true);
				v.setParent(u);
				wMST += e.getWeight();

				for (Edge edge : v.getAdj()) {
					if (!edge.getFrom().isSeen() || !edge.getTo().isSeen()) {
						primqueue.add(edge);
					}
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
		Timer timer = new Timer();
		Graph g = Graph.readGraph(in);
		Vertex s = g.getVertex(1);
		timer.start();
		System.out.println(Prim1MST(g, s));
		timer.end();
		System.out.println(timer);
	}
}
