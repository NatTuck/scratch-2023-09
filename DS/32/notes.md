
# Schedule

 - Next week is Thanksgiving
 - Makeup lab is next week
   - Solo assignment
 - If you want to request a partner for the last two labs,
   (Nov 28, Dec 5), send me an email before Thanksgiving.


# Deadlock

Locks and synchronized blocks:

 - Every object has an associated lock.
 - When a thread enters a synchronized method or block, the thread
   first aquires the lock associated with the object.
   - "this" for a method
 - When a thread leaves a synchronized block, it gives up the lock.
 - Only one thread can get a lock at a time. If a second thread
   tries to get the lock it will block until the first thread
   gives up the lock.
 
The example:

 - Thread A takes the Alice lock
 - Thread B takes the Bob lock
 - Thread A tries to get the Bob lock, blocks
 - Thread B tries to get the Alice lock, blocks
 - Deadlock!

Conditoin for deadlock:

 - Cycle of being blocked on locks

How to avoid deadlock:

 - Only have one thread
 - Only have one lock (object that we synchronize on)
 - Never have nested synchronize blocks (never take more than
   one lock)


# CPU Cache and Performance

- Main memory: 16GB
- Quad-core processor:
  - Shared L3 cache: 8MB
  - Per core L1+L2 cache: 64 + 256 = 320 kB

Why?

 - Accessing data in cache is faster than accessing data
   not in cache.
 - Smaller cache is faster
 - A BitSet of size 100M takes 12.5MB RAM

Sieve algorthim:

```java
    for (prime : primes) {
       for (ii : 0 .. 100M) {
          mark bitSet[ii] if ii divisible by prime
       }
    }
```

```java
    for (ii : 0 .. 100M) {
       for (prime : primes) {
          mark bitSet[ii] if ii divisible by prime
       }
    }
    
    for block of 1M indexes {
       for (prime : primes) {
          for (ii : indexes in block) {
             mark bitSet[ii] if ii divisible by prime
          }
       }
    }
```
