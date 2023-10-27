
# Hash function 

 - Map values of the input type to ints
 - During a run of the program, a given input must
   deterministicly produce the same output
 - Depends on the value of the input; two items that
   are equal produce the same hashCode.
 - We want to avoid collisions, so different inputs
   should produce diffrent outputs.
   - Some hash functions are bad: e.g. return string.length;

How many integers are there? 2^32 ~ 4 billion

The pidgeonhole principle guarantees that there will
be collisions, at least for key types with more possible
values than ~ 4 billion.

```java
int hashString(String text) {
    int yy = 37
    for (char cc : text.toCharArray() {
       // What happens when this exceeds 2^31?
       yy = 257*yy + 5*cc; 
    }
    return yy;
}
```
