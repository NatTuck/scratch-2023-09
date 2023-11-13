package demo;

import java.util.ArrayList;

public class SeqPrimes {
    static ArrayList<Long> primes;

    static long countPrimes(long nn) {
        primes = new ArrayList<Long>();
        primes.add(2L);
        primes.add(3L);
        primes.add(5L);

        for (long ii = 7; ii < nn; ii += 2) {
            if (isPrime(ii)) {
                primes.add(ii);
            }
        }

        return primes.size();    
    }

    static boolean isPrime(long xx) {
        long top = 1 + ceilSqrt(xx);
        for (long yy : primes) {
            if (yy > top) {
                break;
            }
            if (xx % yy == 0) {
                return false;
            }
        }
        return true;
    }

    static long ceilSqrt(long xx) {
        return (long) Math.ceil(Math.sqrt(xx));
    }
}