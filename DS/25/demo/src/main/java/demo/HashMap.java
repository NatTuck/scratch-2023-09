package demo;

public class HashMap<K, V> {
    ConsList<Entry<K, V>>[] data;
    int size;

    Entry<K, V> empty;
    Entry<K, V> tomb;

    @SuppressWarnings("unchecked")
    public HashMap() {
        this.empty = new Empty<K, V>();
        this.tomb = new Tomb<K, V>();

        this.data = (ConsList<Entry<K, V>>[]) new Object[4];
        this.size = 0;
        for (int ii = 0; ii < 4; ++ii) {
            this.data[ii] = empty;
        }
    }

    @SuppressWarnings("unchecked")
    void grow() {
        var prevData = this.data;
        this.data = (ConsList<Entry<K, V>>[]) new Object[2 * prevData.length];
        this.size = 0;

        for (int ii = 0; ii < prevData.length; ++ii) {
            var ent = prevData[ii];
            if (ent.isPair()) {
                put(ent.key(), ent.val());
            }
        }
    }

    public void put(K key, V val) {
        if (loadFactor() > 0.55) {
            grow();
        }

        var ent = new Entry<K, V>(key, val);
        int code = key.hashCode();

        for (int ii = 0; ii < capacity(); ++ii) {
            int jj = modn(code + ii);

            if (this.data[jj].isEmpty()) {
                this.data[ii] = ent;
                this.size += 1;
                return;
            }

            if (this.data[jj].isPair()) {
                if (this.data[jj].key().equals(key)) {
                    this.data[ii] = ent;
                    return;
                }
            }
        }

        throw new RuntimeException("can't happen");
    }

    public boolean hasKey(K key) {
        return getOrNull(key) != null;
    }

    public V get(K key) {
        V yy = getOrNull(key);
        if (yy == null) {
            throw new RuntimeException("key not found");
        }
        return yy;
    }

    public V getOrNull(K key) {
        int code = key.hashCode();
        
        for (int ii = 0; ii < capacity(); ++ii) {
            int jj = modn(code + ii);

            var ent = this.data[jj];

            if (ent.isEmpty()) {
                return null;
            }

            if (ent.isPair()) {
                if (ent.key().equals(key)) {
                    return ent.val();
                }
            }
        }

        return null;
    }

    public void del(K key) {
        int code = key.hashCode();

        for (int ii = 0; ii < capacity(); ++ii) {
            int jj = modn(code + ii);

            var ent = this.data[jj];

            if (ent.isEmpty()) {
                return null;
            }

            if (ent.isPair()) {
                if (ent.key().equals(key)) {
                    this.data[jj] = tomb;
                }
            }
        }
    }

    double loadFactor() {
        return ((double) size) / ((double) capacity);
    }

    int capacity() {
        return this.data.length;
    }

    int size() {
        return size;
    }

    int modn(int xx) {
        return Math.floorMod(xx, this.data.length);
    }
}

interface Entry<K, V> {
    default boolean isEmpty() { return false; }
    default boolean isTomb() { return false; } // Leave off Tomb to start
    default boolean isPair() { return false; }
    default K key() { throw new RuntimeException("not pair"); }
    default V val() { throw new RuntimeException("not pair"); }
}

record Empty<K, V>() implements Entry<K, V> {
    @Override
    public isEmpty() {
        return true;
    }
}

record Tomb<K, V>() implements Entry<K, V> {
    @Override
    public isTomb() {
        return true;
    }
}

record Pair<K, V>(K key, V val) implements Entry<K, V> {
    @Override
    public isPair() {
        return true;
    }
}

