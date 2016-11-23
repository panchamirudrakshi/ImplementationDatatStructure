/** 
 * @author : Panchami Rudrakshi
 * Implement a circular list class, where each node stores an integer in the range 1..k, where k <= n, the number of nodes in the list
 */
 
 package dataStructures;
/**
 * Method to create a new node
 * 
 * @param data
 * 			: value of the node
 * 
 * @param next
 * 			: next node
 * @param prev
 * 			: previous node
 */
class Node {
	protected int data;
	protected Node next, prev;

	public Node() {
		next = null;
		prev = null;
		data = 0;
	}

	public Node(int d, Node n, Node p) {
		data = d;
		next = n;
		prev = p;
	}

	public void setNextNode(Node n) {
		next = n;
	}

	public void setPreviousNode(Node p) {
		prev = p;
	}

	public Node getNextNode() {
		return next;
	}

	public Node getPreviousNode() {
		return prev;
	}

	public void setData(int d) {
		data = d;
	}

	public int getData() {
		return data;
	}
}