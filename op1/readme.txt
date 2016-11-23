Project 1:
1. Implement Merge Sort (say, from Cormen's book) in Java using generics.
2. Given two linked lists implementing sorted sets, write functions for union, intersection, and set difference of the sets.
3. Suppose large numbers are stored in a list of integers.  Write functions for adding and subtracting large numbers.
4. Extend the "unzip" algorithm discussed in class to "multiUnzip" on the SinglyLinkedList.
5. Write recursive and nonrecursive functions for the following tasks:
   (i) reverse the order of elements of the SinglyLinkedList class
   (ii) print the elements of the SinglyLinkedList class, in reverse order.
6. Implement a circular list class, where each node stores an integer in the range 1..k, where k <= n, the number of nodes in the list.  Note that k is not a constant and it can grow as the lists grow in size. Implement an index as part of the circular lists, such that the following merge operation runs in O(1)



Question 1:
Filename: MergeSort.java
Input: randomly generated array of million numbers
Output: Time taken to sort the randomly generated array of numbers numbers
& the time taken to sort numbers added through priority queue 


Question 2: 
Filename: SetOpsOnLists.java
Input: 2 Integer lists
Output: Union, intersection and difference of the lists


Question 3:
Filename: Add_List.java 
The code adds two numbers of a particular base and prints the output to another list.
It takes the user input for 2 numbers of 3 digits and also the base. Depending on the base value, 2 numbers are added column wise with bits into consideration.
EX :
Input:
321 123 10
Output:
444


Question 4:
Filename: SinglyLinkedList.java
Input: list elements, k value
Output:Multi Unzip operation on a given list of elements with given k value.


Question 5:
Filename: ReverseLinkedList.java
Input: Linked list with integer elements
Output: Recursively and iteratively reversing the list


Question 6:
Filename: Main.java (To accept the values for the lists), CircularList.java (to create a doubly linked circular list, find the matching node and merge the two lists) and Node.java (to create a node, get and set data)
Input: Enter the values of each of the list in a single line with space in between.
Output : Merged list with values separated by comma
EX: 
Enter the values of first circular list in a single line with space in between
1 2 4 5 6 7 8 2 3 4 5
Enter the values of second circular list in a single line with space in between
2 3 4 5 6
Merged List is
1 , 2 , 3 , 4 , 5 , 6 , 2 , 4 , 5 , 6 , 7 , 8 , 2 , 3 , 4 , 5