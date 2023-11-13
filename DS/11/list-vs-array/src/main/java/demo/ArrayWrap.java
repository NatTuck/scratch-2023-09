package demo;

import java.util.function.Function;


/**
 * An array wrapper that adds some methods.
 *
 * @param  <T>  Type of list items
 *
 * @author Nat Tuck
 */
public class ArrayWrap<T> {
    T[] data;

    ArrayWrap() {
        this.data = (T[]) new Object[0];
    }

    ArrayWrap(int nn) {
        this.data = (T[]) new Object[nn];
    }

    int length() {
        return data.length;
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

    ArrayWrap<T> map(Function<T, T> op) {
        var ys = new ArrayWrap<T>(this.data.length);
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
}
