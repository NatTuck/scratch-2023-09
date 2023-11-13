package demo;

import java.util.ArrayList;
import java.util.List;

public class Primes {
    static long countPrimes(long nn) {
        return 5;
    }

    static long countPrimes1(long nn) {
        int P = Runtime.getRuntime().availableProcessors();
        long npp = nn / P;
        var workers = new Worker[P];
        for (int ii = 0; ii < P; ++ii) {
            long n0 = Math.max(2, ii * npp);
            long n1 = (ii + 1) * npp;
            if (ii == (P - 1)) {
                n1 = nn;
            }
            workers[ii] = new Worker(n0, n1);
            workers[ii].start();
        }

        long count = 0;
        for (int ii = 0; ii < P; ++ii) {
            try {
                workers[ii].join();
            } catch (InterruptedException ee) {
                throw new Error("borked");
            }
            count += workers[ii].count;
        }

        return count;
    }

    static List<Long> findPrimes(long n0, long n1) {
        var ys = new ArrayList<Long>();
        for (long ii = n0; ii < n1; ++ii) {
            if (isPrime(ii)) {
                ys.add(ii);
            }
        }
        return ys;
    }

    static boolean isPrime(long xx) {
        if (xx == 2) {
            return true;
        }
        for (long ii = 2; ii < (1 + ceilSqrt(xx)); ++ii) {
            if (xx % ii == 0) {
                return false;
            }
        }
        return true;
    }

    static long ceilSqrt(long xx) {
        return (long) Math.ceil(Math.sqrt(xx));
    }
}

class Worker extends Thread {
    long n0;
    long n1;
    long count;

    Worker(long n0, long n1) {
        this.n0 = n0;
        this.n1 = n1;
        this.count = 0;
    }

    @Override
    public void run() {
        var ys = Primes.findPrimes(n0, n1);
        this.count = ys.size();
    }
}