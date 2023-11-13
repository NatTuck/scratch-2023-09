package demo;

public class App {

    public static void main(String[] args) {
        List xs = new Empty();
        xs = new Cell(5, xs);
        xs = new Cell(8, xs);

        System.out.println("xs sum = " + sum(xs));
    }

    static int sum(List xs) {
        if (xs.empty()) {
            return 0;
        }
        else {
            return xs.first() + sum(xs.rest());
        }
    }
}

interface List {
    /**
     * Get the first item.
     *
     * @return  The first item.
     */
    int first();

    /**
     * Get the rest of the list, not including first item.
     * 
     * @return  Rest of list
     */
    List rest();

    /**
     * Determine if list is empty.
     * 
     * complexity: O(1)
     *
     * @return  True if list is empty, else false.
     */
    boolean empty();

    // This one is complexity O(n)
    /*
    default boolean empty() {
        return this.length() == 0;
    }
    */


    /**
     * Determine how many items in list.
     * 
     * Given a list of n items, how many
     * operations to find length?
     * 
     * complexity is O(n)
     * 
     * @return  The number of items
     */
    int length();
}

record Cell(int first, List rest) implements List{
    @Override
    public boolean empty() {
        return false;
    }
    
    @Override
    public int length() {
        return rest.length() + 1;
    }
}

record Empty() implements List {
    @Override
    public boolean empty() {
        return true;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public int first() {
        throw new Error("empty list");
    }

    @Override
    public List rest() {
        throw new Error("empty list");
    }
}