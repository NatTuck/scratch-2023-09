package lab09;

import java.util.function.Consumer;
import java.util.ArrayList;

public class TreeMap<K extends Comparable<K>, V> {
    BinNode<K, V> root;
    int size;
    int maxSize;

    public TreeMap() {
        this.root = new BinLeaf<K, V>();
        this.size = 0;
        this.maxSize = 0;
    }

    int size() {
        return this.size;
    }

    boolean hasKey(K key) {
        return root.hasKey(key);
    }

    V get(K key) {
        return root.get(key);
    }

    void insert(K key, V val) {
        delete(key);

        this.root = this.root.insert(key, val);
        this.size += 1;
        this.maxSize = Math.max(this.size, this.maxSize);
    }

    void delete(K key) {
        if (!this.root.hasKey(key)) {
            return;
        }

        this.root = this.root.delete(key);
        this.size -= 1;
    }

    void eachEntry(Consumer<Entry<K, V>> op) {
        root.eachEntry(op);
    }

    ArrayList<Entry<K, V>> toList() {
        return root.toList();
    }

    int height() {
        return this.root.height();
    }

    @Override
    public String toString() {
        return String.format("{size=%d maxSize=%d %s}",
                             this.size,
                             this.maxSize,
                             this.root.toString());
    }
}

record Entry<K extends Comparable<K>, V>(K key, V val) {
    // empty
}

interface BinNode<K extends Comparable<K>, V> {
    boolean isLeaf();

    boolean hasKey(K key);

    BinNode<K, V> insert(K key, V val);

    V get(K key);

    BinNode<K, V> delete(K key);

    BinNode<K, V> merge(BinNode<K, V> other);

    Entry<K, V> data();

    BinNode<K, V> left();

    BinNode<K, V> right();

    int size();

    int height();

    void eachEntry(Consumer<Entry<K, V>> op);

    default ArrayList<Entry<K, V>> toList() {
        var ys = new ArrayList<Entry<K, V>>();
        this.eachEntry((xx) -> ys.add(xx));
        return ys;
    }
}

record BinLeaf<K extends Comparable<K>, V>() implements BinNode<K, V> {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public boolean hasKey(K _key) {
        return false;
    }

    @Override
    public BinNode<K, V> insert(K key, V val) {
        return new BinBranch<K, V>(new Entry<K, V>(key, val), this, this);
    }

    @Override
    public V get(K key) {
        throw new RuntimeException("leaf");
    }

    @Override
    public BinNode<K, V> delete(K _key) {
        return this;
    }

    @Override
    public BinNode<K, V> merge(BinNode<K, V> that) {
        return that;
    }

    @Override
    public Entry<K, V> data() {
        throw new RuntimeException("leaf");
    }

    @Override
    public BinNode<K, V> left() {
        throw new RuntimeException("leaf");
    }

    @Override
    public BinNode<K, V> right() {
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
    public void eachEntry(Consumer<Entry<K, V>> op) {
        // do nothing
    }
}

record BinBranch<K extends Comparable<K>, V>(
            Entry<K, V> data, BinNode<K, V> left, BinNode<K, V> right)
        implements BinNode<K, V> {
    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean hasKey(K key) {
        int cmp = key.compareTo(this.data.key());
        if (cmp == 0) {
            return true;
        }
        if (cmp < 0) {
            return this.left.hasKey(key);
        }
        else {
            return this.right.hasKey(key);
        }
    }

    @Override
    public BinNode<K, V> insert(K key, V val) {
        int cmp = key.compareTo(this.data.key());
        if (cmp == 0) {
            var ent = new Entry<K, V>(key, val);
            return new BinBranch<K, V>(ent, this.left, this.right);
        }
        if (cmp < 0) {
            return new BinBranch<K, V>(this.data,
                                       this.left.insert(key, val), this.right);
        }
        else {
            return new BinBranch<K, V>(this.data,
                                       this.left, this.right.insert(key, val));
        }
    }

    @Override
    public V get(K key) {
        int cmp = key.compareTo(this.data.key());
        if (cmp == 0) {
            return this.data().val();
        }
        if (cmp < 0) {
            return this.left.get(key);
        }
        else {
            return this.right.get(key);
        }
    }

    @Override
    public BinNode<K, V> delete(K key) {
        int cmp = key.compareTo(this.data.key());
        if (cmp == 0) {
            return this.left.merge(this.right);
        }
        if (cmp < 0) {
            return new BinBranch<K, V>(this.data,
                                    this.left.delete(key), this.right);
        }
        else {
            return new BinBranch<K, V>(this.data,
                                    this.left, this.right.delete(key));
        }
    }

    @Override
    public BinNode<K, V> merge(BinNode<K, V> that) {
        if (that.isLeaf()) {
            return this;
        }

        return this.insert(that.data().key(), that.data().val())
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
        sb.append(" [");
        sb.append(this.data.key());
        sb.append(" => ");
        sb.append(this.data.val());
        sb.append("] ");
        sb.append(this.right.toString());
        sb.append(")");
        return sb.toString();
    }


    @Override
    public void eachEntry(Consumer<Entry<K, V>> op) {
        this.left().eachEntry(op);
        op.accept(this.data());
        this.right().eachEntry(op); 
    }
}

