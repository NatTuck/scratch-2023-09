package lab09;

import java.util.function.Consumer;
import java.util.ArrayList;

public class TreeMap<T extends Comparable<T>> {
    BinNode<T> root;
    int size;
    int maxSize;

    public TreeMap() {
        this.root = new BinLeaf<T>();
        this.size = 0;
        this.maxSize = 0;
    }

    int size() {
        return this.size;
    }

    boolean contains(T item) {
        return root.contains(item);
    }

    void insert(T item) {
        if (this.root.contains(item)) {
            return;
        }

        this.root = this.root.insert(item);
        this.size += 1;
        this.maxSize = Math.max(this.size, this.maxSize);
    }

    void delete(T item) {
        if (!this.root.contains(item)) {
            return;
        }

        this.root = this.root.delete(item);
        this.size -= 1;
    }

    void each(Consumer<T> op) {
        root.each(op);
    }

    ArrayList<T> toList() {
        return root.toList();
    }
}

interface BinNode<T extends Comparable<T>> {
    boolean isLeaf();

    boolean contains(T item);

    BinNode<T> insert(T item);

    BinNode<T> delete(T item);

    BinNode<T> merge(BinNode<T> other);

    T data();

    BinNode<T> left();

    BinNode<T> right();

    int size();

    int height();

    void each(Consumer<T> op);

    default ArrayList<T> toList() {
        var ys = new ArrayList<T>();
        this.each((xx) -> ys.add(xx));
        return ys;
    }
}

record BinLeaf<T extends Comparable<T>>() implements BinNode<T> {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public boolean contains(T _item) {
        return false;
    }

    @Override
    public BinNode<T> insert(T item) {
        return new BinBranch<T>(item, this, this);
    }

    @Override
    public BinNode<T> delete(T item) {
        return this;
    }

    @Override
    public BinNode<T> merge(BinNode<T> that) {
        return that;
    }

    @Override
    public T data() {
        throw new RuntimeException("leaf");
    }

    @Override
    public BinNode<T> left() {
        throw new RuntimeException("leaf");
    }

    @Override
    public BinNode<T> right() {
        throw new RuntimeException("leaf");
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public String toString() {
        return ".";
    }

    @Override
    public void each(Consumer<T> op) {
        // do nothing
    }
}

record BinBranch<T extends Comparable<T>>(
            T data, BinNode<T> left, BinNode<T> right)
        implements BinNode<T> {
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
    public BinNode<T> insert(T item) {
        int cmp = item.compareTo(this.data);
        if (cmp == 0) {
            return this;
        }
        if (cmp < 0) {
            return new BinBranch<T>(this.data,
                                    this.left.insert(item), this.right);
        }
        else {
            return new BinBranch<T>(this.data,
                                    this.left, this.right.insert(item));
        }
    }

    @Override
    public BinNode<T> delete(T item) {
        int cmp = item.compareTo(this.data);
        if (cmp == 0) {
            return this.left.merge(this.right);
        }
        if (cmp < 0) {
            return new BinBranch<T>(this.data,
                                    this.left.delete(item), this.right);
        }
        else {
            return new BinBranch<T>(this.data,
                                    this.left, this.right.delete(item));
        }
    }

    @Override
    public BinNode<T> merge(BinNode<T> that) {
        if (that.isLeaf()) {
            return this;
        }

        return this.insert(that.data())
            .merge(that.left())
            .merge(that.right());
    }

    @Override
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }

    @Override
    public int height() {
        return 1 + Math.max(this.left.height(), this.right.height());
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

    @Override
    public void each(Consumer<T> op) {
        this.left().each(op);
        op.accept(this.data());
        this.right().each(op); 
    }
}

