
I hear there's a programming competition tomorrow @ 6pm in 417

Email lmcarten@ for more info.

# Threads

 - Normally a Java program runs the statements in the
   main method in order - doing method calls and loops and
   stuff as nessisary.
 - What if we want to do more than one thing at the 
   same time ("concurrently")?

Why?

 - We want our program to finish running sooner, so we want
   to do work in parallel.
 - Keep the user interface responsive while doing work
   in the background.
 - To handle concurrent network requests:
   - User A makes request that will be slow.
   - User B makes request after.
   - We want to handle both requests concurrently so
     B doesn't need to wait on A.

How?

 - A bunch of ways.
 - Today: Threads

A thread is:

 - what your operating system can schedule to run on a CPU core.
 - A sequence of instructions that will run in order

When we start a program, it has one main thread - that's what
runs our Java main method.

We can start other threads, which will run some other
code concurrently.

In Java, that's

```java
    t = new Thread(...);
    t.start();
```

Complications:

 - Our model of computing mostly assumes one thread.
 - That's programming languages, compilers, CPUs, etc.
 - Modern computers have multiple cores, so it's
   straightforward to have two independent threads
   running on two cores.
 - When two running threads interact - e.g. by both accessing
   the same variable - things get messy.
 
 
