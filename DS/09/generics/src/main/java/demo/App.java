package demo;

public class App {

    public static void main(String[] args) {
        List<Pet> xs = new Empty<>();
        xs = new Cell<>(new Pet("dog", "fido", 5.0), xs);
        xs = new Cell<>(new Pet("cat", "long", 2.5), xs);
        xs = new Cell<>(new Pet("dog", "dog", 8.1), xs);
        

        /*
        List<String> xs = new Empty<>();
        xs = new Cell<>("aa", xs);
        xs = new Cell<>("bb", xs);
        xs = new Cell<>("cc", xs);
        printStrList(xs);
        xs = xs.reverse();
        printStrList(xs);
        xs = itReverse(xs);
        printStrList(xs);
        */
    }

    static <T> List<T> itReverse(List<T> xs) {
        List<T> ys = new Empty<T>();
        for (List<T> curr = xs; !curr.empty(); curr = curr.rest()) {
            ys = new Cell<T>(curr.first(), ys);
        }
        return ys;
    }

    static void printStrList(List<String> xs) {
        if (!xs.empty()) {
            System.out.println(xs.first());
            printStrList(xs.rest());
        }
    }
}

record Pet(String species, String name, double weight) {}

interface List<T> {
    T first();
    List<T> rest();

    boolean empty();
    int length();

    default List<T> reverse() {
        var ys = new Empty<T>();
        return this.reverseConcat(ys);
    }

    /**
     * Reverse a list, then stick ys on the end.
     */
    List<T> reverseConcat(List<T> ys);
}

record Empty<T>() implements List<T> {
    @Override
    public T first() {
        throw new Error("empty");
    }
   
    @Override
    public List<T> rest() {
        throw new Error("empty");
    }

    @Override
    public boolean empty() {
        return true;
    }

    @Override
    public int length() {
        return 0;
    }
    
    @Override
    public List<T> reverseConcat(List<T> ys) {
        return ys;
    }
}

record Cell<T>(T first, List<T> rest) implements List<T> {
    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public int length() {
        return rest.length() + 1;
    }

    @Override
    public List<T> reverseConcat(List<T> ys) {
        return this.rest.reverseConcat(new Cell<T>(this.first, ys));
    }

}
