
## Sets

 - A collection of items
 - Order doesn't matter
 - Repetitions don't matter

{ "apple", "banana", "grape" }

 - Set, to be well defined, should contain values
 - Values are immutable

Mathematical set operations:

 - s1.contains?(item)

{A, B, C} contains A
{A, B, C} does not contain G

 - s1.union(s2)

The union of two sets is a set containing every item
in either input set.

{1, 2, 8} union {3, 2, 8} = {1, 2, 3, 8}

 - s1.intersection(s2)
 
The intersecton of two sets is a set containing every
item that appears in both input sets.

{1, 2, 8} intersection {3, 2, 8} = {2, 8}

 - s1.subset?(s2)

The set s1 is a subset of the set s2 if every item in s1
appears in s2.

Is {1, 2, 8} a subset of {1, 2, 8}? Yes. (But not a proper subset.)
Is {1, 2} a subset of {1, 2, 8}? Yes.
Is {1, 5} a subset of {1, 2, 8}? No.

 - s1.superset?(s2)

The set s1 is a superset of the set s2 if every item in s2
appears in s1.

Is {1, 2, 8} a superset of {1, 2, 8}? Yes.
A proper superset? No.
Is {3} a superset of {}? Yes.

To build this as a programmatic data structure, we also want:

 - add
 - remove
 - size
 
```java
interface Set<T> {
    Set<T> add(T item);
    Set<T> remove(T item);
    
    Set<T> union(Set<T> other); 
    Set<T> intersection(Set<T> other); 
    
    boolean contains(T item);
    boolean subset(Set<T> other);
    boolean superset(Set<T> other);
    
    int size();
}
```

```java
interface MutableSet<T> {
    void add(T item);
    void remove(T item);
    
    Set<T> union(Set<T> other); 
    Set<T> intersection(Set<T> other); 
    
    boolean contains(T item);
    boolean subset(Set<T> other);
    boolean superset(Set<T> other);
    
    int size();
}
```

## Sets with ConsList

The list contains the items in the set.

 - Set<T> add(T item);

l1 = [1, 2, 3]
l2 = l1.add(7) => [7, 1, 2, 3]
l3 = l2.add(2) => [2, 7, 1, 2, 3]  (maybe bad, but O(1))
l3 = l2.add(2) => [7, 1, 2, 3]  (better, but O(n))
 
 - Set<T> remove(T item);
 
l3.remove(2) => [7, 1, 3]  O(n)
    
 - Set<T> union(Set<T> other); 

l4 = [2, 4, 8, 16]     l5 = [4, 5, 6, 7, 8]

l4 union l5 => [16, 8, 4, 2, 4, 5, 6, 7, 8]  O(n), with duplicates

var l6 = l4;
for (item in l5) {
    l6 = l6.add(item);
}

l6 = [7, 6, 5, 2, 4, 8, 16] O(n), no duplicates
 
 - Set<T> intersection(Set<T> other); 

l4 = [2, 4, 8, 16]     l5 = [4, 5, 6, 7, 8]
    
l4 intersection l5 = [4, 8]   O(n^2)

l7 = empty list
for (i4 in l4) {
    for (i5 in l5) {
       if (i4 == i5) {
          l7 = l7.add(i4); 
       }
    }
}

l7 = empty list
for (i4 in l4) {
   if (l5.contains(i4)) {
       l7 = l7.add(i4); 
   }
}
    
 - boolean contains(T item);

l4 = [2, 4, 8, 16]    O(n), potentially need to look at every item

l4.contains?(5) => false
l4.contains?(8) => true

 
 - boolean subset(Set<T> other);

l4 = [2, 4, 8, 16]     l5 = [4, 5, 6, 7, 8]     l6 = [4, 8]

l4.subset?(l5) => false

for (item in l4) { // this loop is O(n^2)
    if (!l5.contains?(item)) { // contains is O(n)
        return false;
    }
}
return true;
 
 
 - boolean superset(Set<T> other);
 
l4 = [2, 4, 8, 16]     l5 = [4, 5, 6, 7, 8]     l6 = [4, 8]

l4.superset?(l6) => true

for (item in l6) { // this loop is O(n^2)
    if (!l4.contains?(item)) { // contains is O(n)
        return false;
    }
}
return true;
 
 - int size();
 
l4 = [2, 4, 8, 16] 

l4.size() => 4

call l4.length()    O(n)
