package lab08;

import java.util.Iterator;

/**
 * Implements a generic set with a cons list structure.
 *
 * @param  <T>  Type of list items
 *
 * @author Nat Tuck
 */
public interface ConsSet<T extends Comparable<T>>
    extends Iterable<T>, Comparable<ConsSet<T>> {

    /**
     * Creates a list of the given items.
     *
     * @param  <T>   ConsList item type
     * @param  args  Zero or more items
     * @return       A list of those items
     */
    @SafeVarargs
    public static <T extends Comparable<T>> ConsSet<T> set(T... args) {
        ConsSet<T> ys = new ConsEmpty<T>();
        for (int ii = args.length - 1; ii >= 0; --ii) {
            ys = ys.add(args[ii]);
        }
        return ys;
    }

    boolean isEmpty();

    /**
     * Get the first item in the set.
     *
     * @return  The first item
     */ 
    T first();

    /**
     * Get the set of all items except the first.
     *
     * @return  The rest of the list
     */
    ConsSet<T> rest();

    /**
     * Add an item to the set.
     */
    ConsSet<T> add(T item);

    ConsSet<T> remove(T item);

    boolean contains(T item);
    
    ConsSet<T> union(ConsSet<T> other);
    ConsSet<T> intersection(ConsSet<T> other);
    
    boolean isSubset(ConsSet<T> other);
    boolean isSuperset(ConsSet<T> other);
    
    /**
     * Determine the size of the set.
     *
     * @return  Size of set.
     */
    int size();

    default Iterator<T> iterator() {
        return new ConsSetIterator<T>(this);
    }
}

/**
 * An empty set.
 *
 * @param  <T>   Type of item in set.
 *
 * @author Nat Tuck
 */
record ConsEmpty<T extends Comparable<T>>() implements ConsSet<T> {
    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public T first() {
        throw new RuntimeException("empty set");
    }

    @Override
    public ConsSet<T> rest() {
        throw new RuntimeException("empty set");
    }

    @Override
    public ConsSet<T> add(T item) {
        return new ConsCell<T>(item, this);
    }

    @Override
    public ConsSet<T> remove(T item) {
        return this;
    }

    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public ConsSet<T> union(ConsSet<T> other) {
        return other;
    }

    @Override
    public ConsSet<T> intersection(ConsSet<T> other) {
        return this;
    }
    
    @Override
    public boolean isSubset(ConsSet<T> other) {
        return true;
    }

    @Override
    public boolean isSuperset(ConsSet<T> other) {
        return other.isSubset(this);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return "{ }";
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof ConsEmpty<?>;
    }

    @Override
    public int compareTo(ConsSet<T> that) {
        if (that.isEmpty()) {
            return 0;
        }
        return -1;
    }
}

/**
 * A non-empty set.
 *
 * @param  <T>   Type of item in set
 * @param  first  First item in the set
 * @param  rest   The rest of the set
 *
 * @author Nat Tuck
 */
record ConsCell<T extends Comparable<T>>(T first, ConsSet<T> rest) implements ConsSet<T> {
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    public int size() {
        return 1 + rest.size();
    }

    @Override
    public ConsSet<T> add(T item) {
        int cmp = this.first.compareTo(item);
        // TODO: Add item to list, keeping items in sorted order.
        return null;
    }

    @Override
    public ConsSet<T> remove(T item) {
        // TODO: Remove item from set.
        return null;
    }

    @Override
    public boolean contains(T item) {
        if (this.first.equals(item)) {
            return true;
        }
        else {
            return this.rest.contains(item);
        }
    }

    @Override
    public ConsSet<T> union(ConsSet<T> other) {
        // TODO: Calculate Union
        return null;
    }

    @Override
    public ConsSet<T> intersection(ConsSet<T> other) {
        // TODO: Calculate Intersection
        return null;
    }
    
    @Override
    public boolean isSubset(ConsSet<T> other) {
        // TODO: Calculate isSubset
        // (Is this a subset of other?)
        return false;
    }

    @Override
    public boolean isSuperset(ConsSet<T> other) {
        // TODO: Calculate isSuperset
        // (Is this a superset of other?)
        return false;
    }

    @Override
    public String toString() {
        var tmp = rest.toString();
        return "{ " + first + " " + tmp.substring(2, tmp.length() - 1) + "}";
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ConsSet<?>)) {
            return false;
        }

        ConsSet<?> that = (ConsSet<?>) other;
        return this.first().equals(that.first()) && this.rest().equals(that.rest());
    }

    @Override
    public int compareTo(ConsSet<T> that) {
        if (that.isEmpty()) {
            return 1;
        }

        int dx = this.first().compareTo(that.first());
        if (dx != 0) {
            return dx;
        }
        else {
            return this.rest().compareTo(that.rest());
        }
    }
}

class ConsSetIterator<T extends Comparable<T>> implements Iterator<T> {
    ConsSet<T> curr;

    ConsSetIterator(ConsSet<T> xs) {
        this.curr = xs;
    }

    @Override
    public boolean hasNext() {
        return !this.curr.isEmpty();
    }

    @Override
    public T next() {
        T item = this.curr.first();
        this.curr = this.curr.rest();
        return item;
    }
}
