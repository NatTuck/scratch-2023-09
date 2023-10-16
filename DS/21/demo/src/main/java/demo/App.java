package demo;

//import java.util.Iterator;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        //int[] xs = {4, 2, 7, 3};
        Dog[] xs = {new Dog("Bb"), new Dog("Aa"), new Dog("Cc")};

        Arrays.sort(xs);

        for (var xx : xs) {
            System.out.println("xx = " + xx);
        }

        /*
        ArrayWrap<Integer> ys = new ArrayWrap<Integer>();
        ys.push(10);
        ys.push(20);
        ys.push(30);

        //for (int ii = 0; ii < ys.length; ++ii) {
        //    int xx = ys.get(ii);
        */

        /*
        var zs = ConsList.list(2, 4, 6, 8);

        //for (; !zs.isEmpty(); zs = zs.rest()) {
        //    var xx = zs.first();
        for (int xx : zs) {
            System.out.println("xx = " + xx);
        }
        */
    }
}

record Dog(String name) implements Comparable<Dog> {
    public int compareTo(Dog that) {
        if (this.equals(that)) {
            return 0;
        }
        if (this.name.compareTo(that.name) < 0) {
            return -1;
        }
        else {
            return 1;
        }
    }
}

    /*
class ArrayWrap<T> implements Iterable<T> {
    T[] data;
    int length;

    ArrayWrap() {
        this.data = (T[]) new Object[10];
        this.length = 0;
    }

    void push(T xx) {
        this.data[this.length++] = xx;
    }

    T get(int ii) {
        return this.data[ii];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayWrapIterator(this);
    }
}

class ArrayWrapIterator<T> implements Iterator<T> {
    ArrayWrap<T> xs;
    int ii;

    ArrayWrapIterator(ArrayWrap<T> xs) {
        this.xs = xs;
        this.ii = 0;
    }

    @Override
    public boolean hasNext() {
        return this.ii < this.xs.length;
    }

    @Override
    public T next() {
        return this.xs.get(this.ii++);
    }
}
    */
