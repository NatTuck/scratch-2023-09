package demo;

import java.util.function.Function;

/**
 * Implements a generic linked list.
 *
 * @param  <T>  Type of list items
 *
 * @author Nat Tuck
 */
public interface ConsList<T> {
    /**
     * Creates a list of the given items.
     *
     * @param  <T>   ConsList item type
     * @param  args  Zero or more items
     * @return       A list of those items
     */
    @SafeVarargs
    public static <T> ConsList<T> list(T... args) {
        ConsList<T> ys = new Empty<T>();
        for (int ii = args.length - 1; ii >= 0; --ii) {
            ys = new Cell<T>(args[ii], ys);
        }
        return ys;
    }

    /**
     * Get the first item in the list.
     *
     * @return  The first item
     */ 
    T first();

    /**
     * Get a list of all items except the first.
     *
     * @return  The rest of the list
     */
    ConsList<T> rest();

    /**
     * Determine if the list is empty.
     *
     * @return  True for empty list, else false.
     */
    boolean empty();

    /**
     * Determine the length of the list.
     *
     * @return  ConsList length
     */
    int length();

    /**
     * Reverse the list.
     *
     * @return  New list with content in reverse order
     */
    ConsList<T> reverse();

    /**
     * Reverse this list and concatenate with other list.
     *
     * @param  ys  End of resulting list.
     * @return     New list
     */
    ConsList<T> reverseConcat(ConsList<T> ys);

    /**
     * Produce a new list by applying op to each item
     * in this list.
     *
     * @param  <U>  Type of items in result list.
     * @param  op   The operation to perform on each item.
     * @return      New list
     */
    <U> ConsList<U> map(Function<T, U> op);
}

/**
 * An empty list.
 *
 * @param  <T>   ConsList item type
 *
 * @author Nat Tuck
 */
record Empty<T>() implements ConsList<T> {
    @Override
    public T first() {
        throw new Error("empty list");
    }

    @Override
    public ConsList<T> rest() {
        throw new Error("empty list");
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
    public String toString() {
        return "Empty";
    }

    @Override
    public ConsList<T> reverse() {
        return new Empty<T>();
    }

    @Override
    public ConsList<T> reverseConcat(ConsList<T> ys) {
        return ys;
    }

    @Override
    public <U> ConsList<U> map(Function<T, U> op) {
        return new Empty<U>();
    }
}

/**
 * A non-empty list.
 *
 * @param  <T>    Type of item in list
 * @param  first  First item in the list
 * @param  rest   The rest of the list
 *
 * @author Nat Tuck
 */
record Cell<T>(T first, ConsList<T> rest) implements ConsList<T> {
    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public int length() {
        return 1 + rest.length();
    }

    @Override
    public String toString() {
        return "(" + first + " " + rest + ")";
    }

    @Override
    public ConsList<T> reverse() {
        var ys = new Empty<T>();
        return reverseConcat(ys);
    }

    @Override
    public ConsList<T> reverseConcat(ConsList<T> ys) {
        return this.rest.reverseConcat(new Cell<T>(this.first, ys));
    }

    @Override
    public <U> ConsList<U> map(Function<T, U> op) {
        return new Cell<U>(op.apply(this.first()), this.rest.map(op));
    }
}
