/** 
 * @author : Panchami Rudrakshi      
 * Implement a circular list class, where each node stores an integer in the range 1..k, where k <= n, the number of nodes in the list
 */
 
 package dataStructures;
/**
 * Method to create a doubly linked circular list 
 * @param start
 * 				 : starting node of the circular list 
 *            
 * @param end
 * 				 : ending node of the circular list
 * 
 * @param size
 * 				 : size of the circular list
 * 
 */
public class CircularList {
	protected Node start;
	protected Node end;
	public int size;
	
    //constructor to initialize start , end and size of the list
	public CircularList() {
		start = null;
		end = null;
		size = 0;
	}
    //Method to check if the list is empty
	public boolean isEmpty() {
		return start == null;
	}
    // Method to get the size of the list
	public int getSize() {
		return size;
	}
	
    /**
    * Method to insert a new node into a doubly linked list
	* if the list is empty inserts a new node and points start and end to it 
	* else appends the new node to the existing list and sets the links 
	* increments the size of the list as every new node is added
	*/
	public void insertAtEnd(int val) {
		Node node = new Node(val, null, null);
		if (start == null) {
			node.setNextNode(node);
			node.setPreviousNode(node);
			start = node;
			end = start;
		} else {
			node.setPreviousNode(end);
			end.setNextNode(node);
			start.setPreviousNode(node);
			node.setNextNode(start);
			end = node;
		}
		size++;
	}
public void insertAtStart(int val) {
    Node node = new Node(val,null,null);
    if(start ==null) {
        node.setNextNode(node);
        node.setPreviousNode(node);
        start = node;
        end = start;
    } else {
        node.setNextNode(start);
        start.setPreviousNode(node);
        node.setPreviousNode(end);
        end.setNextNode(node);
        start = node;
    }
    size++;
}

	public void createList(int[] values) {
		for (int i = 0; i < values.length; i++) {
			insertAtEnd(values[i]);
		}
	}

	/**
	 * Method to find which node from the second list matches the node in the first list
	 * and returns the matching node
	 */
	public Node findNode(int value) {
		Node current = start;
		while (current.data != value) {
			current = current.getNextNode();
		}
		return current;
	}

	/**
	 * Method to merge both the given lists finding the appropriate position
	 * Finds the matching node and prepends the second list at that position
	 * finds the size of the merged list
	 */
	public void Merge(CircularList c) {
		Node matchingNode = findNode(c.start.getData());
		Node connectorNode = matchingNode.getPreviousNode();
		connectorNode.setNextNode(c.start);
		c.start.setPreviousNode(connectorNode);
		c.end.setNextNode(matchingNode);
		matchingNode.setPreviousNode(c.end);
		size = size + c.getSize();
		
		if (matchingNode == start) {
			end = c.end;
		}
	}
	
	//Method to display the merged list 
	public void display() {
		Node current = start;
		System.out.print(start.getData());
		current = start.getNextNode();
		while (current.getNextNode() != start) {
			System.out.print(" , " + current.getData());
			current = current.getNextNode();
		}
		System.out.print(" , " + current.getData());
 
	}
}
