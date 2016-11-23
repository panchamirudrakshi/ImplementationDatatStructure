# ImplementationDatatStructure

Implementation of Indexed heaps

Files:
BinaryHeap.java - Binary heap implementation of priority queues
Driver.java - Driver code for MST and Shortest paths 
Edge.java - Class that represents an edge of a Graph
Graph.java - Class to represent a graph
Index.java - Interface for Index
IndexedHeap.java - Implementation of Indexed heap
MST.java - Prim2 (priority queue of vertices, using indexed heaps)
PQ.java - Interface for Priority Queue
Prims1.java - Prim1 (priority queue of edges; using Java's priority queues)
ShortestPath.java - Dijkstra'a algorithm for shortest paths using indexed heaps
Timer.java - Timer class for roughly calculating running time of programs
Vertex.java - Class to represent a vertex of a graph

Input format: 
An undirected graph is given as input, in the format expected by readGraph method.  
After the graph, two vertices, s and t are specified. Prim's algorithm is run with source as s.
Dijkstra's algorithm is run with s as source and distance to t is printed.

Output format:
Count based on the type of operation performed and the time taken.
