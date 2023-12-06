
# Networking

 - Internet Protocol, IP
   - Computers connected to the internet have IP addresses
   - Can send an IP packet to an IP address
     - IP packets are limited to 64kB
       - In practice, the ethernet limit of 1.2kB frequently applies
     - IP packets are unreliable
   - Transmission Control Protocol (TCP) builds on IP to provide
     - A connection-oriented protocol
     - Bi-directoinal streams of unlimited length
     - Reliable, in-order delivery
     - That requires detecting drops and resending
     - Simple version: send a packet, wait for confirmation or timeout
       - If timeout, resend
       - If confirmation, send next packet
     - More complex: Window
       - Send N packets (e.g. at least 60 for a 1Gb/s link to California)
       - Recipient sends back a confirmation packet for all the packets
         they recieved
       - Sender waits for confirmatoin or timeout
         - If timeout, resend fewer packets
         - If some packets confirmed, resend any non-confirmed packets
           - And also send new packets to have a full window worth of packets
             in flight.

Example: Window size 5:

 - Send: 0, 1, 2, 3, 4
 - Response: Got 0, 1, 4
 - Send: 2, 3, 5, 6
 - Repsponse: Got 2, 3, 4, 5, 6
 - Send: 7, 8, 9, 10, 11

  - HTTP on top of TCP, effecively to send files.
    - Browser sends: GET /index.html HTTP/1.0
    - Server responds: 200 OK\n\n<html..
    - Browser sends: GET /logo.jpg HTTP/1.0
    - Server responds: 200 OK\n\n[image data...
    

# Semester Review

What did we cover this semester?

 - Intermediate Programming in Java
   - Generics - Having to rewrite ArrayList for every data type would be lame.
   - Threads
     - concurrency
     - parallel speedup
     - Data races, locks, deadlock
   - Way too much about Strings
   - Java primitive types
   - Classes, Records, Interfaces
   - Anonomous Function Objects
 - Data Structures
   - Lists: Array Lists, Linked Lists (LinkedList and ConsList)
     - Linked Lists - Adding objects (typically to the front) is always O(1)
       - ConsLists are a persistent data structure - easy to work with
         such that creating a new version doesn't mess up the old one
     - Array Lists - More efficient to access specific index O(1)
   - Stacks, Queues, Deques
   - Tree 
     - Balanced Binary Search Trees: Efficient lookup of certain keys
     - TreeMap, TreeSet; operations are O(log n)
   - Hash Tables
     - HashMap, HashSet; operatoins are amortized, expected O(1)
   - Graphs
