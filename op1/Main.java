/** 
 * @author : Panchami Rudrakshi    
 * Implement a circular list class, where each node stores an integer in the range 1..k, where k <= n, the number of nodes in the list
 */
 
 package dataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Method to read two list items 
 * 
 * Input : Enter the values of each list in a single line with space in between
 *            
 * Output :Merged list - from the given two list
 */

public class Main {

	public static void main(String[] args) throws IOException {

		CircularList first = new CircularList();
		CircularList second = new CircularList();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the values of first circular list in a single line with space in between");
		String[] list = reader.readLine().split(" ");
		int[] firstValues = new int[list.length];

		for (int i = 0; i < firstValues.length; i++)
			firstValues[i] = Integer.parseInt(list[i]);

		System.out.println("Enter the values of second circular list in a single line with space in between");
		String[] list2 = reader.readLine().split(" ");
		int[] secondValues = new int[list2.length];

		for (int i = 0; i < secondValues.length; i++)
			secondValues[i] = Integer.parseInt(list2[i]);

		first.createList(firstValues);
		second.createList(secondValues);
		first.Merge(second);

		System.out.println("Merged List is");
		first.display();

	}

}
