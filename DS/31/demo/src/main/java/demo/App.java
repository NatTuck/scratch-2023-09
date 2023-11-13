package demo;

public class App {
    public static void main(String[] args) {
        //System.out.println("threads = " + procs);

        long t0 = System.nanoTime();
        long count = SeqPrimes.countPrimes(10000000);
        long t1 = System.nanoTime();
        long ms = ((t1 - t0) / 1000000);
        System.out.printf(
            "Counted %d primes in %d ms", 
                count, ms);
    }
}
