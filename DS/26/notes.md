

# Hash Table with Linear Probing: Delete


 - We saw delete
 
 
# Tomorrow's lab: hash table with chaining


# Other hash table strategies:

 - Linear probing tried ii + 1, ii + 2, etc.
 - Quadratic probing ii + 1, then ii + 4, then ii + 9, etc.
 
Cuckoo Hashing:

 - A family of hash functions
 - Two tables


```java
int hashFamily(int code, int ii) {
    return (code + ii) * 11;
}
```
