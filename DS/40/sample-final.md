---
title: "cs2381: Practice Final"
date: "2023-12-01"
---

## Practice Final Exam: cs2381 Fall 2023

2023-12-02: This sample exam is provided to help provide some
direction in studying for the upcoming final.

Keep in mind that anything we've covered in class, in lab, or in a lab
assignment may be on the exam.

These questions reference the code provided at the end of the exam.
Skim that first to see what the questions are talking about.

The answer to an "asymptotic complexity" question on this exam will be
one of: O(1), O(log n), O(n), O(n log n), O(n^2), O(n^2 log n),
O(n^3), O(2^n)

**1. In the SeaApp#main method, what is the type of the ``args`` parameter?**

An array of strings.

**2. In the SeaApp#main method, what is the type of the ```nums``` variable?**

```ArrayList<Integer>```

**3. If we run the SeaApp program, what will it print?**

squid => 18, crab => 3

**4. What is the asymptotic complexity of the SeaApp#squid method? Why?**

O(n^2)

 - It traverses the list recursively, requring O(n) calls.
 - Each call involves a ArrayList#remove, which takes O(n) time.
 - O(n) * O(n) = O(n^2)

**5. What is the asymptotic complexity of the SeaApp#crab method? Why?**

O(n)

 - There's one loop over the List.
 - Everything else is O(1)

**6. What is the asymptotic complexity of the SeaApp#tuna method? Why?**

O(n^2)

 - squid is n^2
 - Everything else in the method is less complex than squid

**7. How many bytes does it take to store the declared fields of a Pair record? Why?**

8

Two ints, at 4 bytes each.

**8. Why is the complexity of ArrayList#add "amortized" O(1) rather than just O(1)?**

Sometims the array list needs to grow, so those calls are O(n). On
average across many calls it's O(1).

**9. What are the names and descriptions for the standard operations for a Stack?**

 - push - Put thing at top of stack
 - pop - Take thing from top of stack and return it
 - isEmpty - Checks if it's empty

(would also accept length instead of isEmpty)

**10. How is a Stack different from a Queue?**

 - Stack is first in last out
   - More conventional would be "last in first out"
 - Queue is first in first out
 - Queue has a take next or shift operation instead of pop

**11. If a multithreaded program that makes good use of many cores
takes 12 seconds on 12 processor cores, how long would you expect it
to take on 6 cores? Why?**

24 seconds. Half as many cores should mean double the time.

**12. Write the body of SeaApp#keepUnique. This should return a new
List, not modify the input, and run in O(n) time in the size of the input.**

(see below)

## Reference Code

```java
package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class SeaApp {
    public static void main(String[] args) {
        var nums = new ArrayList<>(List.of(1,2,3,4,5));
        var retv = tuna(nums);
        System.out.printf("squid => %d, crab => %d\n", retv.xx(), retv.yy());
    }

    static Pair tuna(ArrayList<Integer> xs) { // n is length(xs)
        var sq = squid(xs); // O(n^2)
        var cr = crab(xs);  // O(1)
        return new Pair(sq, cr); // O(1)
    }

    // Sum the list and add 3.
    static int squid(ArrayList<Integer> xs) {   // n is length(xs)
        if (xs.isEmpty()) {
            return 3;
        }
        var aa = xs.get(0);
        xs.remove(0);   // This is O(n), because we need to shift over
                        // every other item.
        return aa + squid(xs);
    }

    // Sum the list and add 3.
    static int crab(ArrayList<Integer> xs) {  // What n? n is length(xs)
        var yy = 3;
        for (var xx : xs) {
            yy += xx;
        }
        return yy;
    }
    
    static List<Integer> keepUnique(List<Integer> xs) { // O(n)
       var ys = new ArrayList<Integer>(); 
       var seen = new HashSet<Integer>();
       for (var xx : xs) {          // loop iterates n times
          if (!seen.contains(xx)) {  // O(1)
             seen.add(xx);
             ys.add(xx);  // amortized O(1)
          }
       }
       return ys;
       // Build and return a new ArrayList containing
       // each item from xs only once.
       
       // Examples: 
       //  - keepUnique([1,1,1,1,1,2,1,1,2]) -> [1,2]
       //  - keepUnique([1,2,1,5,3,2,3,4,5]) -> [1,2,5,3,4]
    }
}

record Pair(int xx, int yy) {
    // pass
}
```

