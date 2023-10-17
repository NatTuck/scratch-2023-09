package lab08;

import java.util.Iterator;
import java.util.ArrayList;

public record TreeSet<T extends Comparable<T>>(BinTree<T> data)
    implements Iterable<T>, Comparable<TreeSet<T>> {
    /**
     * Creates a list of the given items.
     *
     * @param  <T>   ConsList item type
     * @param  args  Zero or more items
     * @return       A list of those items
     */
    @SafeVarargs
    public static <U extends Comparable<U>> TreeSet<U> set(U... args) {
        BinTree<U> xs = BinTree.<U>makeEmpty();
        for (int ii = args.length - 1; ii >= 0; --ii) {
            xs = xs.insert(args[ii]);
        }
        return new TreeSet<U>(xs);
    }

    TreeSet<T> add(T item) {
        // TODO
        return null;
    }

    TreeSet<T> remove(T item) {
        // TODO
        return null;
    }

    boolean contains(T item) {
        return this.data.contains(item);
    }
    
    TreeSet<T> union(TreeSet<T> that) {
        // TODO
        return null;
    }

    TreeSet<T> intersection(TreeSet<T> that) {
        // TODO
        return null;
    }
        
    
    boolean isSubset(TreeSet<T> that) {
        // TODO
        return false;
    }

    boolean isSuperset(TreeSet<T> that) {
        // TODO
        return false;
    }
    
    int size() {
        return this.data.length();
    }

    @Override
    public Iterator<T> iterator() {
        return this.data.iterator();
    }

    @Override
    public int compareTo(TreeSet<T> that) {
        var xi = this.iterator();
        var yi = that.iterator();

        while (xi.hasNext() && yi.hasNext()) {
            var xx = xi.next();
            var yy = xi.next();
            var cc = xx.compareTo(yy);
            if (cc != 0) {
                return cc;
            }
        }

        if (xi.hasNext()) {
            return 1;
        }

        if (yi.hasNext()) {
            return -1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof TreeSet<?>)) {
            return false;
        }

        TreeSet<?> that = (TreeSet<?>) other;
        var xi = this.iterator();
        var yi = that.iterator();

        var xs = new ArrayList<Object>();
        xi.forEachRemaining(xs::add);

        var ys = new ArrayList<Object>();
        yi.forEachRemaining(ys::add);

        return xs.equals(ys);
    }
}
