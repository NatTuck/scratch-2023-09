package demo;

import java.util.ArrayList;
import java.lang.reflect.Array;

public class HashMap<K, V> {
    Entry<K, V>[] data;
    int size;

    Entry<K, V> empty;

    public HashMap() {
        this.empty = new Empty<K, V>();
        this.data = newArray(4);
        for (int ii = 0; ii < data.length; ++ii) {
            this.data[ii] = empty;
        }
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    Entry<K, V>[] newArray(int size) {
        return (Entry<K, V>[]) Array.newInstance(Entry.class, size);
    }

    void grow() {
        var prevData = this.data;

        this.data = newArray(2 * prevData.length);
        this.size = 0;
        for (int ii = 0; ii < data.length; ++ii) {
            this.data[ii] = empty;
        }

        for (var ent : prevData) {
            if (ent.isPair()) {
                put(ent.key(), ent.val());
            }
        }
    }

    public void put(K key, V val) {
        if (loadFactor() >= 0.6) {
            grow();
        }

        int code = key.hashCode();
        var ent = new Pair<K, V>(key, val);

        for (int ii = 0; ii < capacity(); ++ii) {
            int jj = modn(code + ii);

            if (this.data[jj].isEmpty()) {
                this.data[jj] = ent;
                this.size =+ 1;
                return;
            }
        }

        throw new RuntimeException("table full");
    }

    boolean hasKey(K key) {
        return getOrNull(key) != null;
    }

    V get(K key) {
        V yy = getOrNull(key);
        if (yy == null) {
            throw new RuntimeException("no such key");
        }
        return yy;
    }

    V getOrNull(K key) {
        int code = key.hashCode();

        for (int ii = 0; ii < capacity(); ++ii) {
            int jj = modn(code + ii);

            if (this.data[jj].isPair()) {
                var ent = this.data[jj];
                if (ent.key().equals(key)) {
                    return ent.val();
                }
            }
        }

        return null;
    }

    int size() {
        return this.size;
    }

    int capacity() {
        return this.data.length;
    }

    double loadFactor() {
        // Good maximum load factor for linear probing: 0.6
        // For lab, with ConsList chaining: good maximum is 2.0
        return ((double) size()) / ((double) capacity());
    }

    int modn(int xx) {
        return Math.floorMod(xx, this.data.length);
    }
}

interface Entry<K, V> {
    default boolean isEmpty() { return false; }
    default boolean isPair() { return false; }
    default K key() { throw new RuntimeException("not pair"); }
    default V val() { throw new RuntimeException("not pair"); }
}

record Empty<K, V>() implements Entry<K, V> {
    @Override
    public boolean isEmpty() { return true; }
}

record Pair<K, V>(K key, V val) implements Entry<K, V> {
    @Override
    public boolean isPair() { return true; }
}
