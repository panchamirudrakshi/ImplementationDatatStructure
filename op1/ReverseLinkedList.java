/**
 * @author : Panchami Rudrakshi 
 * Reverse a linked list iteratively and recursively. Also, print the linked list elements in reverse order
 * Date: 9/11/2016
 */

public class ReverseLinkedList<T> {
	
	ReverseLinkedList() {
        header = new Entry<>(null, null);
        tail = null;
        size = 0;
    }
	
	 /** Class to represent a single node of the list */
    public class Entry<T> {
        T element;
        Entry<T> next;
        Entry(T x, Entry<T> nxt) {
            element = x;
            next = nxt;
        }
    }

    Entry<T> header=null, tail=null;
       int size;

    // Add new elements to the end of the list
    void add(T x) {
    	//list is empty
        if(tail == null) {
            header.next = new Entry<>(x, header.next);
            tail = header.next;
        } else {
            tail.next = new Entry<>(x, null);
            tail = tail.next;
        }
        size++;
    }
    
        
    //Reverse the list using Recursion
         
    void revWithRecursion(Entry<T> x){
    	if(x.next==null){
    		header=x;
    		return;
    	}
    	revWithRecursion(x.next);
    	Entry<T> y=x.next;
    	y.next=x;
    	x.next=null;
    	
    }
        
    
    //Print list in reverse order without using additional space
    //Uses Recursion
    void printRev(Entry<T> x){
    	if(x==null){
    		return;
    	}
    	else{
    		printRev(x.next);
    		if(x.element!=null)
    		System.out.print(x.element+" ");
    	}
    }
    
 
    //Iterative reversal of linked list
    //Loop invariants cursor- points to current node
    //nxt - address  of next node
    //prev- address of previous node
    void revlist(){
    	Entry<T> nxt,prev,cursor;
    	prev=null;
    	cursor=header;
    	if(header==null){
    		System.out.println("Empty list");
    	}
    	while(cursor!=null){
    		nxt=cursor.next;
    		cursor.next=prev;
    		prev=cursor;
    		cursor=nxt;
    	}
    	//Re assign the header 
    	header=prev;    	
    }

    
    void printList() {		
    	if(header==null){
    		System.out.println("Empty list");
    		return;
    	}
    	else{			
    		Entry<T> x = header;    		
	        while(x != null) {
	            if(x.element!=null)System.out.print(x.element + " ");
	            x = x.next;
	        }		
			System.out.println();
    	}
    }
           
 
    public static void main(String[] args) {
    		 	        
	        ReverseLinkedList<Integer> lst2 = new ReverseLinkedList<>();
	        ReverseLinkedList<Integer> lst3 = new ReverseLinkedList<>();
	        
	        lst2.add(50);
            lst2.add(55);
            lst2.add(60);
            lst2.add(100);
                       
            //To reverse print the contents of list without using extra space
	        //Reverse print and reverse again
            System.out.println("List Contents");
            lst2.printList();
            
            System.out.println("Reverse->Print->Reverse");
            lst2.revlist();
            lst2.printList();
            lst2.revlist();
            
            //Print in reverse order without reversing the list
            System.out.println("Print in reverse order without reversing the list");
            lst2.printRev(lst2.header);
            
            System.out.println();
            System.out.println("List Contents");
            lst2.printList();
            
            //Reverse recursively
            lst2.revWithRecursion(lst2.header);
            
            //Reverse iteratively
            lst2.revlist();

            
            
        
    }

}
