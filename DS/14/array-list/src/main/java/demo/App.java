package demo;

class App {
    public static void main(String[] args) {
        // Q1: String[]

        var xs = ConsList.list(33, 81, 72, 5, 53, 28);
        // Q2: What type is var xs?
        //  => ConsList<Integer>

        // Q2 variant: What type is the value in xs?
        //  => ConsCell<Integer>

        // Q3:
        // The maximum of [33 81 72 5 53 28 ] is 81
        // matches = 2

        // Q5:
        // Our maximum method is O(n)

        // Q6:
        // One type that isn't primitive: String
        // Troll answer: Integer
        // Another: int[]

        // Q6 variant:
        // One type that is primitive: int

        // Q7 bytes for primitive types:
        //  boolean     1 byte 
        //  char        1 byte
        //  short       2 bytes
        //  int         4 bytes
        //  long        8 bytes
        //  float       4 bytes
        //  double      8 bytes
        //  how many bits in a byte?  8

        // Q8: Effects of declaring record not class
        //  - Records get constructors automatically.
        //  - Record instance fields are immutable by default.
        //  - Other free stuff with records: toString, equals, hashCode

        // Q9: Complexity of matches: O(n^2)
        //  - Nested for loops

        // Q10: Things wrong with Walrus.java
        //  - Used "[]" where we needed "{}"
        //  - Can't pass int as String argument
        //  - sandwitch method should return Walrus
        //  - System.out.println statement isn't in a method
    }

    // Q4:
    static int maximum(ConsList<Integer> xs) {
        // TODO: Given a ConsList of non-negative integers, 
        // return the maximum value.
        if (xs.empty()) {
            return 0;
        }
        int aa = xs.first();
        int bb = maximum(xs.rest());
        if (aa > bb) {
            return aa;
        }
        else {
            return bb; 
        }
    }
}

// var gg = new Goat(5);
// gg.anger += 3;
// var sh = new Sheep(5);
// sh.anger += 3;

record Goat(int anger) {

}

class Sheep {
    final int anger;

    Sheep(int anger) {
        this.anger = anger;
    }
}