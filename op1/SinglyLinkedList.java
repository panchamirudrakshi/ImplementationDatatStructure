/** @author : Panchami Rudrakshi
 * Single linked List class which has methods to 
 *    add elements to the list,
 *    print the elements of a list,
 *    perform multiunzip on a list of elements  
 */

import java.util.Iterator;
import java.util.Scanner;
public class SinglyLinkedList<T> implements Iterable<T>{
	//Each node in the list is a Entry type
	public class Entry<T>{
		T ele;
		Entry<T> next;
		Entry(T x,Entry<T> nxt){
			ele=x;
			next=nxt;
			}
		
		}
		Entry<T> header,tail;
		int size;
		SinglyLinkedList(){
			header=new Entry<>(null,null);
			tail=header;
			size=0;
		}
		public Iterator<T> iterator(){
			return new SLLIterator<>(header);
		}
		private class SLLIterator<E> implements Iterator<E>{
			Entry<E> cursor,prev;
			SLLIterator(Entry<E> head){
				cursor=head;
				prev=null;
			}
			public boolean hasNext(){
				return cursor.next!=null;
			}
			public E next(){
				prev=cursor;
				cursor=cursor.next;
				return cursor.ele;
			}
			public void remove(){
				if(cursor.next!=null){
					prev.next=cursor.next;
					cursor=cursor.next;
				}
				else
					System.out.println("This is the last element, cannot perform next()operstion");
			}
			
			
		}
		//add new elements to the list
		public void add(T x){
			tail.next=new Entry<>(x,null);
			tail=tail.next;
			size++;
		}
		//print the elements of a list
		public void printList(){
			Entry<T> x=header.next;
			while(x!=null){
				System.out.print(x.ele+" ");
				x=x.next;
			}
			System.out.println();
		}
		public void multiUnzip(int k){
			// Rearrange elements of a singly linked list by chaining
		   	// together elements that are k apart.
			// Invariant: 
			// tail[] is an array which holds k tails where each tail points to the list of elements in its chain
			// head[] holds k-1 heads which is used to connect different chains formed
			// curr is current element to be processed.
			// state is the loop variable which decides to which tail should the current element be added.
			Entry<T>[] tail = (Entry<T>[]) new Entry[k];
			Entry<T>[] head = (Entry<T>[]) new Entry[k-1];
			tail[0]=header.next;
			for(int i=1;i<k;i++){
				tail[i]=tail[i-1].next;
				head[i-1]=tail[i];
			}
			Entry<T> curr=tail[k-1].next;
			int state=0;
			while(curr!=null){
				tail[state].next=curr;
				tail[state]=curr;
				curr=curr.next;
				state=(state+1)%k;
				
			}
			//merge the different chains formed by connecting tail[0] to head[0],....tail[k-2] to head[k-2]
			for(int p=0;p<k-1;p++){
				tail[p].next=head[p];
			}
			//connect null to the last element
			tail[k-1].next=null;
			
			
			
			
		}
	    public static void main(String[] args){
			
			      SinglyLinkedList<Integer> ls=new SinglyLinkedList<>();
			      Scanner in = new Scanner(System.in);
			      System.out.println("Please enter a list of numbers: ");
			       
			      String [] values = in.nextLine().split("\\s");
			       
			      for (int i = 0; i < values.length; i++)
			         ls.add(Integer.parseInt(values[i]));
			      Scanner s1=new Scanner(System.in);
			      System.out.println("enter k value:");
			      int k=s1.nextInt();
			      System.out.println("List Initially");
				  ls.printList();
				  ls.multiUnzip(k);
				  System.out.println("List After Multiunzip with k="+k);
				  ls.printList();
				
		}
 }
/* Sample output:
List Initially
1 2 3 4 5 6 7 8 9 10 
List After Multiunzip with k=3
1 4 7 10 2 5 8 3 6 9 
 */



