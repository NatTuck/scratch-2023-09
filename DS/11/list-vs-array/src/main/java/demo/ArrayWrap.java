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

    ArrayWrap<T>() {
        ArrayWrap(0);
    }

    ArrayWrap<T>(int nn) {
        this.data = new T[nn];
    }

    T get(int ii) {
        return data[ii];
    }

    void put(int ii, T vv) {
        data[ii] = vv;
    }

    void resize(int nn) {
        T[] data1 = new T[nn];
        for (int ii = 0; ii < Math.min(nn, this.data.length); ++ii) {
            data1[ii] = this.data[ii];
        }
        this.data = data1;
    }
}
