Project 3:

1. Compare the performance of an O(n^2) sorting algorithm (say, Insertion sort) with Merge sort. Implement the generics version of both algorithms. You can create a sorted array (say,arr[i] = new Integer(i);") and then shuffle it randomly with "Shuffle.shuffle(arr);" 
   Download link:  http://www.utdallas.edu/~rbk/teach/2016f/java/code/Shuffle.java
   Compare algorithms on array sizes that are powers of 2, starting at 2^10. For each algorithm, find array size at which the running time exceeds 15 sec.

2. Compare the running times of for mergesort (using generics): 
(1) Merge sort as in Cormen et al's text book, creating new arrays L and R in merge.
(2) Use insertion sort for the base case when the size comes below a threshold. Experiment with different value of threshold.  
(3) Pass array B for merge and avoid creating them each time merge is run.  

3. Compare the performance of Quicksort implementations: standard version of the Partition algorithm, versus Dual-Pivot partition.
   Try large inputs that contain many duplicate elements. 
   
4. Compare the running times of the following algorithms for computing Fibonacci numbers: 
(1) recursive
(2) O(n) dynamic program
(3) O(log n) DAC algorithm
For each algorithm, find the largest value of n for which f(n) can be computed in less than 1 min.

