/**  
 * @author: Panchami Rudrakshi
 * Program on Adding numbers of different bases
 */

 
import java.util.Scanner;
class Add_List {
 
    static Node head1, head2;
 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    /* Adds contents of two linked lists and return the head node of resultant list */
   

   Node addTwoLists(Node first, Node second, int base) {
        Node res = null; // res is head node of the resultant list
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;
 
        while (first != null || second != null) //while both lists exist
        {
            /* Calculate value of next digit in resultant list.
             The next digit is sum of following things:
              Carry
              Next digit of first list (if there is a next digit)
              Next digit of second list (if there is a next digit)*/
        	
        	
            sum = carry + (first != null ? first.data : 0)
                    + (second != null ? second.data : 0);
 
            carry = (sum >= base) ? 1 : 0;
            sum = sum % base;
 
            temp = new Node(sum);
 
            /* if this is the first node then
               set it as head of the resultant list*/
            if (res == null) {
                res = temp;
            } else // If this is not the first node then connect it to the rest.
            {
                prev.next = temp;
            }
 
            prev = temp;
 
            // Move first and second pointers to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }
 
        if (carry > 0) {
            temp.next = new Node(carry);
        }
        return res;
    }
 
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
		
        System.out.println("");
    }
 
    public static void main(String[] args) {
        Add_List list = new Add_List();
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter two numbers in bit separated form");
        System.out.println("Enter base");
        
		
		// creating first list
        
        list.head1 = new Node(Integer.parseInt(sc.next()));
        list.head1.next = new Node(Integer.parseInt(sc.next()));
        list.head1.next.next = new Node(Integer.parseInt(sc.next()));
        
        System.out.print("First List is ");
        list.printList(head1);
 
        // creating seconnd list
        list.head2 = new Node(Integer.parseInt(sc.next()));
        list.head2.next = new Node(Integer.parseInt(sc.next()));
        list.head2.next.next = new Node(Integer.parseInt(sc.next()));
		
		
        int base=Integer.parseInt(sc.next());
        System.out.print("Second List is ");
        list.printList(head2);
        
        // add the two lists and see the result
        Node rs = list.addTwoLists(head1, head2,base);
		
		
        System.out.print("Resultant List is ");
        list.printList(rs);
    }
}
