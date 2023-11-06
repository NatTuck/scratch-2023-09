
# Graphs

**Rep 1:**

 - A TreeSet of vertices
 - A TreeSet of edges

Determining if an edge exists is fast O(log n).

Finding all edges to/from a vertex is slow O(n).

**Rep 2**

```java
TreeMap<CourseNumber, TreeSet<CourseNumber>> prereqs;
TreeMap<CourseNumber, TreeSet<CourseNumber>> postreqs;
```

 - Finding all prereqs / postreqs is fast O(log n).
 - Finding if a prereq exists is fast O(log n).

**Why not just do it like a tree?**

Some key differences:

 - There's no single root in a graph.
 - Might want to traverse in both directoins
 
we could represent a DAG like this:

```java
class Dag {
    Node[] roots;
    Node[] leaves;
}

class Node {
    Node[] parents;
    Node[] children;
}
```
