Project 2: 
1. Suppose large numbers are stored in a list of integers.  Write a function for multiplying two large numbers using Karatsuba's algorithm: https://en.wikipedia.org/wiki/Karatsuba_algorithm
2. Implement array-based, bounded-sized queues, that support the following operations: offer, poll, peek, isEmpty (same behavior as in Java's Queue interface). In addition, implement the method resize(), which doubles the queue size if the queue is mostly full (over 90%, say), or halves it if the queue is mostly empty (less then 25% occupied, say).  Let the queue have a minimum size of 16, at all times. 
3. Implement the Shunting Yard algorithm: https://en.wikipedia.org/wiki/Shunting-yard_algorithm for parsing arithmetic expressions using the following precedence rules (highest to the lowest). 
   * Parenthesized expressions (...)
   * Unary operator: factorial (!)
   * Exponentiation (^), right associative.
   * Product (*), division (/).  These operators are left associative.
   * Sum (+), and difference (-).  These operators are left associative. Output the equivalent expression in postfix.

