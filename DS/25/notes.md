
# Propagating Traversal State

Insert on Scapegoat tree:

 - Maximum depth is 2*log(tree.size)
   - known in TreeWrapper#insert
   - used in Leaf#inserAt
 - need to calculate depth during traversal
 - Scapegoat is the deepest node where ratio of one child
   size to node size is > 0.7
   
```java
// Returning multiple values
record InsertResult<K extends Comparable<K>, V>(
    BinNode<K, V> node, boolean needsRebalance, int size) {
}
```

```return new InsertResult<>(...)```

```java
class InsertInfo {
    int maxDepth;
    int depth;
    boolean needsRebalance;
    int size;
}
```

# New Topic: Hash Tables

 - Traversing trees and lists is complicated.
 - And seems slow.

What we want is:

 - An array of pairs.
 - Given a key, we want to immediately know which
   slot to look in - array lookups by index are O(1).
 



