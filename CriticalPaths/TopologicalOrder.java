/**
* @author : pgr150030- Panchami Rudrakshi
* reference : dfs.pdf (lecture 23 rbk notes)
* Code for finding topological order for a given graph using a queue and DFS
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalOrder {

	/**
	 * Method for Topological order using Queue	 
	 * @param g:
	 *            Graph
	 * @return: ArrayList - containing the vertices in topological order
	 */
	static List<Vertex> topologicalOrder1(Graph g) {
		List<Vertex> topOrder = new ArrayList<>();
		Queue<Vertex> queue = new LinkedList<>();
		int count = 0;
		g.calcIndegree(g);
		for (Vertex u : g) {
			if (u.indegree == 0)
				queue.add(u);
		}
		Vertex u, v;
		while (!queue.isEmpty()) {
			u = queue.remove();
			topOrder.add(u);
			++count;

			for (Edge e : u.adj) {
				v = e.otherEnd(u);
				v.indegree--;
				if (v.indegree == 0)
					queue.add(v);
			}
		}
		return topOrder;
	}

	/**
	 * Method for Topological order using DFS
	 * @param g:
	 *            Graph
	 * @return:ArrayDeque - vertices in topological order
	 */
	static List<Vertex> topologicalOrder2(Graph g) {
		return Graph.DFSTop(g);
	}
}