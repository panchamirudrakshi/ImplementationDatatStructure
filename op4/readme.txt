Project 4: 
1. Quicksort:
   Implement generic versions of Quick sort using standard partition (as in Cormen et al's book on algorithms) and compare its performance with 
   Quick sort that uses dual pivot partition.
   Try input sizes that are powers of 2, from 8M to 512M.
   What happens when the input array elements are not distinct?


2. Selection (kth largest element):
   Implement generics version of the selection problem (k largest elements of an unsorted array).  
   Compare the performance of the O(n) algorithm with the priority-queue-based algorithm discussed in class for the external version of the problem.

3. Modifying remove in BST class:
   The BST class implements remove() by moving the minimum element in the right subtree to replace the removed node (2-child case).  
   It could have been written to replace the removed node by the maximum element in the left subtree.  
   Rewrite remove() so that it alternates between these two possibilities.

4. Implement add() in AVL trees:
   Create AVLTree class.  You can make it an inherited class of BST, or take the BST code and modify it as needed.  Implement add(x).


5. Implement add() in Red-Black trees:
   Create RedBlackTree class.  You can make it an inherited class of BST, or take the BST code and modify it as needed.  Implement add(x).
