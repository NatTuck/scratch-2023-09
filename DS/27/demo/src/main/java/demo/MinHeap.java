package demo;

import java.util.ArrayList;

public class MinHeap {
    ArrayList<Integer> data;

    MinHeap() {
        this.data = new ArrayList<Integer>();
    }

    void insert(int xx) {
        this.data.add(xx);
        int ii = this.data.size() - 1;
        while (ii != 0) {
            int pidx = (ii - 1) / 2;
            if (this.data.get(ii) < this.data.get(pidx)) {
                swap(ii, pidx);
            }
            else {
                break;
            }
            ii = pidx;
        }
        System.out.println("snapshot " + this.data);
    }

    void swap(int ii, int jj) {
        int temp = this.data.get(ii);
        this.data.set(ii, this.data.get(jj));
        this.data.set(jj, temp);
    }

    int next() {
        return this.data.get(0);
    }

    // the left child of node ii is (2*ii + 1)
    //     right child           is (2*ii + 2)
}
