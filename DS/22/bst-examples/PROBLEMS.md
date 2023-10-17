
# Lab 07: Queues and Deques

In this lab, you will complete two set implementations.

Feel free to put whatever you want in App#main for experimentation.

## Problems

**Problem 1. Complete the Iterator for BinTree**

In BinTree.java, complete the BinTreeIterator#next method.

The plan is:

 - If the current node is a leaf:
   - Pop the top item from the path stack.
   - That's the item to return.
   - The next item will be its right child.
 - If the current node is not a leaf:
   - Go left as far as you can, pushing each node you
     don't stop at onto the path stack.
   - That's the item to return.
   - The next item will be its right child.

This is the same sequence as a recursive in-order traversal, just
making the call stack explicit so we can do one step at a time.


**Problem 2. Complete set operations for ConsSet**

In ConsSet.java, complete the following methods:

 - ConsCell#add
 - ConsCell#remove
 - ConsCell#union
 - ConsCell#intersection
 - ConsCell#isSuperset
 - ConsCell#isSubset

For this implementation of a set using the structure of a ConsList,
the items must be stored in ascending order. Otherwise the #equals
method won't work correctly.


**Problem 3. Complete set operations for TreeSet**
 
In TreeSet.java, complete the following methods:

 - ConsCell#add
 - ConsCell#remove
 - ConsCell#union
 - ConsCell#intersection
 - ConsCell#isSuperset
 - ConsCell#isSubset


**Problem 4. Finish Remaining Tests, Javadoc, etc**

Get all the tests to pass.



**Problem 5. Answer questions**

Edit the QUESTIONS.md file, answering the included questions.
