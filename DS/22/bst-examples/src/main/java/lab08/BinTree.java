package lab08;

import java.util.Iterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Consumer;

interface BinTree<T extends Comparable<T>> extends Iterable<T> {
    public static <U extends Comparable<U>> BinTree<U> makeEmpty() {
        return new BinLeaf<U>();
    }

    boolean isLeaf();

    boolean contains(T item);

    BinTree<T> insert(T item);

    BinTree<T> remove(T item);

    BinTree<T> merge(BinTree<T> other);

    T data();

    BinTree<T> left();

    BinTree<T> right();

    int length();

    void each(Consumer<T> op);

    default Iterator<T> iterator() {
        return new BinTreeIterator<T>(this);
    }
}

record BinLeaf<T extends Comparable<T>>() implements BinTree<T> {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public boolean contains(T _item) {
        return false;
    }

    @Override
    public BinTree<T> insert(T item) {
        return new BinBranch<T>(item, this, this);
    }

    @Override
    public BinTree<T> remove(T item) {
        return this;
    }

    @Override
    public BinTree<T> merge(BinTree<T> that) {
        return that;
    }

    @Override
    public T data() {
        throw new RuntimeException("leaf");
    }

    @Override
    public BinTree<T> left() {
        throw new RuntimeException("leaf");
    }

    @Override
    public BinTree<T> right() {
        throw new RuntimeException("leaf");
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public void each(Consumer<T> _op) {
       // do nothing 
    }

    @Override
    public String toString() {
        return ".";
    }
}

record BinBranch<T extends Comparable<T>>(T data, BinTree<T> left, BinTree<T> right)
        implements BinTree<T> {
    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean contains(T item) {
        int cmp = item.compareTo(this.data);
        if (cmp == 0) {
            return true;
        }
        if (cmp < 0) {
            return this.left.contains(item);
        }
        else {
            return this.right.contains(item);
        }
    }

    @Override
    public BinTree<T> insert(T item) {
        int cmp = item.compareTo(this.data);
        if (cmp == 0) {
            return this;
        }
        if (cmp < 0) {
            return new BinBranch<T>(this.data, this.left.insert(item), this.right);
        }
        else {
            return new BinBranch<T>(this.data, this.left, this.right.insert(item));
        }
    }

    @Override
    public BinTree<T> remove(T item) {
        int cmp = item.compareTo(this.data);
        if (cmp == 0) {
            return this.left.merge(this.right);
        }
        if (cmp < 0) {
            return new BinBranch<T>(this.data, this.left.remove(item), this.right);
        }
        else {
            return new BinBranch<T>(this.data, this.left, this.right.remove(item));
        }
    }

    @Override
    public BinTree<T> merge(BinTree<T> that) {
        if (that.isLeaf()) {
            return this;
        }

        return this.insert(that.data())
            .merge(that.left())
            .merge(that.right());
    }

    @Override
    public int length() {
        return 1 + this.left.length() + this.right.length();
    }

    @Override
    public void each(Consumer<T> op) {
        this.left().each(op);
        op.accept(this.data());
        this.right().each(op); 
    }

    @Override
    public String toString() {
        if (this.left.isLeaf() && this.right.isLeaf()) {
            return this.data.toString();
        }

        var sb = new StringBuilder();
        sb.append("(");
        sb.append(this.left.toString());
        sb.append(" ");
        sb.append(this.data.toString());
        sb.append(" ");
        sb.append(this.right.toString());
        sb.append(")");
        return sb.toString();
    }
}

class BinTreeIterator<T extends Comparable<T>> implements Iterator<T> {
    Deque<BinTree<T>> path;
    BinTree<T> node;

    BinTreeIterator(BinTree<T> node) {
        this.node = node;
        this.path = new ArrayDeque<BinTree<T>>();
    }

    @Override
    public boolean hasNext() {
        return !(this.node.isLeaf() && this.path.isEmpty());
    }

    @Override
    public T next() {
        // TODO: Complete this.
        return null;
   }
}
