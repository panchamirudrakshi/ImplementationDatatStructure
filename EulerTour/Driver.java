package eulergraph;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.List;
import java.io.File;

/**
* @author : Panchami Rudrakshi
* Class to reads the input graph, finds a tour in it
* verifies that it is correct
* prints output
*/

public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in;
		if (args.length > 0) {
			File inputFile = new File(args[0]);
			in = new Scanner(inputFile);
		} else {
			in = new Scanner(System.in);
		}
		//Timer timer1 = new Timer();
		//Timer timer2 = new Timer();
		//Timer timer3 = new Timer();
		//Timer timer4 = new Timer();
		//timer1.start();
		
		Graph g = Graph.readGraph(in);
		//timer1.end();
		//System.out.println("for reading:"+timer1); 
		
		//System.setOut(new PrintStream(new FileOutputStream("outputbig.txt")));
		//timer2.start();
		
		List<circularList<Vertex>> subTours = Graph.breakGraphIntoTours(g);
		//timer2.end();
		//System.out.println("for breaking:"+timer2); 
		
		//timer3.start();
		circularList<Vertex> tour = Graph.stitchTours(subTours);
		//timer3.end();
		//System.out.println("for stitching:"+timer3); 
		//timer4.start();
		boolean eulergraph = Graph.verifyTour(g, tour);
		//timer4.end();
		//System.out.println("for verification:"+timer4); 
		if (eulergraph != true) {
			System.out.print("Graph is not Eulerian");
		} else {
			//System.out.println("Graph is Eulerian");
			//System.out.print("Size : ");
			tour.printList();
		}
		
	}
}
