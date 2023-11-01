package demo;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> 736cc00faba2d79840b5a7419bde77125482466e
import java.lang.reflect.Array;

public class HashMap<K, V> {
    Entry<K, V>[] data;
    int size;

    Entry<K, V> empty;
    Entry<K, V> tomb;

    public HashMap() {
        this.empty = new Empty<K, V>();
<<<<<<< HEAD
        this.tomb = new Tomb<K, V>();

        this.data = newArray(4);
        this.size = 0;
        for (int ii = 0; ii < 4; ++ii) {
            this.data[ii] = empty;
        }
    }

    void grow() {
        var prevData = this.data;
        this.data = newArray(2*prevData.length);
        this.size = 0;

        for (int ii = 0; ii < prevData.length; ++ii) {
            var ent = prevData[ii];
            if (ent.isPair()) {
                put(ent.key(), ent.val());
            }
        }
=======
        this.tomb = new Empty<K, V>();

        this.data = newArray(4);
        for (int ii = 0; ii < data.length; ++ii) {
            this.data[ii] = empty;
        }
        this.size = 0;
>>>>>>> 736cc00faba2d79840b5a7419bde77125482466e
    }

    @SuppressWarnings("unchecked")
    Entry<K, V>[] newArray(int size) {
        return (Entry<K, V>[]) Array.newInstance(Entry.class, size);
    }

<<<<<<< HEAD
    public void put(K key, V val) {
        if (loadFactor() > 0.55) {
            grow();
        }

        Entry<K, V> ent = new Pair<K, V>(key, val);
=======
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

    public void del(K key) {
>>>>>>> 736cc00faba2d79840b5a7419bde77125482466e
        int code = key.hashCode();

        for (int ii = 0; ii < capacity(); ++ii) {
            int jj = modn(code + ii);

            if (this.data[jj].isEmpty()) {
<<<<<<< HEAD
                System.out.println("inserted " + key + " at index " + jj);
                this.data[jj] = ent;
                this.size += 1;
=======
>>>>>>> 736cc00faba2d79840b5a7419bde77125482466e
                return;
            }

            if (this.data[jj].isPair()) {
                if (this.data[jj].key().equals(key)) {
<<<<<<< HEAD
                    this.data[jj] = ent;
=======
                    this.data[jj] = tomb;
                    this.size -= 1;
>>>>>>> 736cc00faba2d79840b5a7419bde77125482466e
                    return;
                }
            }
        }

<<<<<<< HEAD
        throw new RuntimeException("can't happen");
    }

    public boolean hasKey(K key) {
        return getOrNull(key) != null;
    }

    public V get(K key) {
        V yy = getOrNull(key);
        if (yy == null) {
            throw new RuntimeException("key not found");
=======
        // if no key, that's fine
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
                this.size += 1;
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
>>>>>>> 736cc00faba2d79840b5a7419bde77125482466e
        }
        return yy;
    }

<<<<<<< HEAD
    public V getOrNull(K key) {
        int code = key.hashCode();
        
        for (int ii = 0; ii < capacity(); ++ii) {
            int jj = modn(code + ii);

            var ent = this.data[jj];

            if (ent.isEmpty()) {
                return null;
            }

            if (ent.isPair()) {
=======
    V getOrNull(K key) {
        int code = key.hashCode();

        for (int ii = 0; ii < capacity(); ++ii) {
            int jj = modn(code + ii);

            if (this.data[jj].isPair()) {
                var ent = this.data[jj];
>>>>>>> 736cc00faba2d79840b5a7419bde77125482466e
                if (ent.key().equals(key)) {
                    return ent.val();
                }
            }
        }

        return null;
    }

<<<<<<< HEAD
    public void del(K key) {
        int code = key.hashCode();

        for (int ii = 0; ii < capacity(); ++ii) {
            int jj = modn(code + ii);

            var ent = this.data[jj];

            if (ent.isEmpty()) {
                return;
            }

            if (ent.isPair()) {
                if (ent.key().equals(key)) {
                    this.data[jj] = tomb;
                }
            }
        }
    }

    double loadFactor() {
        return ((double) size()) / ((double) capacity());
=======
    ArrayList<K> keys() {
        var ys = new ArrayList<K>();
        for (var row : data) {
            if (row.isPair()) {
                ys.add(row.key());
            }
        }
        return ys;
    }
    
    int size() {
        return this.size;
>>>>>>> 736cc00faba2d79840b5a7419bde77125482466e
    }

    int capacity() {
        return this.data.length;
    }

<<<<<<< HEAD
    int size() {
        return size;
=======
    double loadFactor() {
        // Good maximum load factor for linear probing: 0.6
        // For lab, with ConsList chaining: good maximum is 2.0
        return ((double) size()) / ((double) capacity());
>>>>>>> 736cc00faba2d79840b5a7419bde77125482466e
    }

    int modn(int xx) {
        return Math.floorMod(xx, this.data.length);
    }
}

interface Entry<K, V> {
    default boolean isEmpty() { return false; }
<<<<<<< HEAD
    default boolean isTomb() { return false; } // Leave off Tomb to start
    default boolean isPair() { return false; }
=======
    default boolean isPair() { return false; }
    default boolean isTomb() { return false; }
>>>>>>> 736cc00faba2d79840b5a7419bde77125482466e
    default K key() { throw new RuntimeException("not pair"); }
    default V val() { throw new RuntimeException("not pair"); }
}

record Empty<K, V>() implements Entry<K, V> {
    @Override
<<<<<<< HEAD
    public boolean isEmpty() {
        return true;
    }
=======
    public boolean isEmpty() { return true; }
>>>>>>> 736cc00faba2d79840b5a7419bde77125482466e
}

record Tomb<K, V>() implements Entry<K, V> {
    @Override
<<<<<<< HEAD
    public boolean isTomb() {
        return true;
    }
=======
    public boolean isTomb() { return true; }
>>>>>>> 736cc00faba2d79840b5a7419bde77125482466e
}

record Pair<K, V>(K key, V val) implements Entry<K, V> {
    @Override
<<<<<<< HEAD
    public boolean isPair() {
        return true;
    }
}

=======
    public boolean isPair() { return true; }
}
>>>>>>> 736cc00faba2d79840b5a7419bde77125482466e
