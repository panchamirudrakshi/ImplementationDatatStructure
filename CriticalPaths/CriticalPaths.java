/**
* @author : pgr150030- Panchami Rudrakshi
* reference : pert_scc_shortestpaths.pdf (lecture 25 rbk notes)
* Code for finding critical paths and printing them 
*/
import java.util.LinkedList;
import java.util.List;

public class CriticalPaths {
	Graph g;

	CriticalPaths(Graph g) {
		this.g = g;

	}

	void findCriticalPaths() {
		List<Vertex> lst;
		List<Vertex> lst2;
		for (Vertex u : g) {
			u.n = 0;
		}
		int num = g.size;
		int s = num - 1;
		g.calcIndegree(g);
		for (int i = 1; i < num - 1; i++) {
			Vertex u = g.getVertex(i);
			if (u.indegree == 0)
				g.addEdge(g.getVertex(s), g.getVertex(i), 1);
		}
		Vertex s1 = g.getVertex(s);
		s1.n = 1;
		int t = num;
		Vertex t1 = g.getVertex(t);
		g.calcOutdegree(g);
		for (int i = 1; i < num - 1; i++) {
			Vertex u = g.getVertex(i);
			if (u.outdegree == 0)
				g.addEdge(g.getVertex(i), g.getVertex(t), 1);
		}

		lst = TopologicalOrder.topologicalOrder1(g);
		lst2 = TopologicalOrder.topologicalOrder2(g);

		List<Vertex> cPath = new LinkedList<>();
		List<Edge> edges = new LinkedList<>();
		g.CalcEc(lst, g);
		g.CalcLc(lst2, g);
		for (Vertex u : lst) {
			for (Edge e : u.adj) {
				Vertex v = e.otherEnd(u);
				if (v.lc == v.ec && u.lc == u.ec) {
					if (u.lc + v.d == v.lc) {
						if (u != s1) {
							cPath.add(u);
							for (Edge e1 : u.adj) {
								if (e1.otherEnd(u) == v) {
									edges.add(e1);
								}
							}
						}
					}
				}
			}
		}

		int sum = 0;
		for (Vertex v : cPath) {
			sum += v.d;
		}
		System.out.println(sum);
		for (Vertex v : cPath) {
			System.out.print(v + " ");
		}
		System.out.println("\n");
		System.out.println("Task" + "\t" + "EC" + "\t" + "LC" + "\t" + "Slack");
		for (Vertex v : g) {
			if (v != s1 && v != t1)
				System.out.println(v + "\t" + v.ec + "\t" + v.lc + "\t" + v.slack);
		}
		System.out.println("\n");
		System.out.println(cPath.size());
		t1.n = s1.n;
		for (Vertex u : cPath) {
			for (Edge e : u.adj) {
				Vertex v = e.otherEnd(u);
				v.n += u.n;
			}
		}
		System.out.println(t1.n);
		for (Vertex v : cPath) {
			System.out.print(v + " ");
		}
		System.out.println();
		System.out.println();
	}
}
