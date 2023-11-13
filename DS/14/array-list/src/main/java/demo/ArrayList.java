package demo;

import java.util.function.Function;


/**
 * An array wrapper that adds some methods.
 *
 * @param  <T>  Type of list items
 *
 * @author Nat Tuck
 */
public class ArrayList<T> {
    T[] data;
    int length;

    ArrayList() {
        this.data = (T[]) new Object[1];
        this.length = 0;
    }

    ArrayList(int nn) {
        this.data = (T[]) new Object[nn];
        this.length = 0;
    }

    int capacity() {
        return data.length;
    }
    
    int length() {
        return length;
    }

    T get(int ii) {
        return data[ii];
    }

    void set(int ii, T vv) {
        data[ii] = vv;
    }

    void resize(int nn) {
        T[] data1 = (T[]) new Object[nn];
        for (int ii = 0;
             ii < Math.min(this.data.length, data1.length);
             ++ii) {
            data1[ii] = data[ii];
        }
        this.data = data1;
    }

    ArrayList<T> map(Function<T, T> op) {
        var ys = new ArrayList<T>(this.data.length);
        for (int ii = 0; ii < this.data.length; ++ii) {
            ys.set(ii, op.apply(this.get(ii)));
        }
        return ys;
    }

    void forEach(Function<T, T> op) {
        for (int ii = 0; ii < this.data.length; ++ii) {
            this.set(ii, op.apply(this.get(ii)));
        }
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("[");
        for (int ii = 0; ii < this.data.length; ++ii) {
            sb.append(this.get(ii).toString());
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    void append(T vv) {
        int ii = length();
        resize(ii + ii);
        set(ii, vv);
    }

    // Insert vv after index ii
    void insertAfter(int ii, T vv) {
        if (capacity() <= length()) {
            resize(2*length());
        }
        T next;
        for (int jj = ii + 1; jj < length(); ++jj) {
                next = data[jj + 1];
                data[jj+1] = data[jj];
                
        }
        data[ii] = vv;
        // insertAfter(2, 9)
        // [0, 1, 2, 3, 4]
        // [0, 1, 2,  , 3, 4]
        // [0, 1, 2,  , 3, 3]
        
        // [0, 1, 2, 9, 3, 4]
    }
}
