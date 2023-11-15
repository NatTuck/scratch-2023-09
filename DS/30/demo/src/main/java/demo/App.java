package demo;

public class App {
    static long BB = 1000000000; // A billion
    static long npt; 
    static long sum;

    static Object mutex;

    public static void main(String[] args) throws InterruptedException {
        mutex = new Object();
        npt = BB / 10;

        var threads = new Thread[10];
        var workers = new Worker[10];

        for (int ww = 0; ww < 10; ++ww) {
            workers[ww] = new Worker(ww);
            threads[ww] = new Thread(workers[ww]);
            threads[ww].start();
        }

        for (int ww = 0; ww < 10; ++ww) {
            threads[ww].join();
        }

        long sum = 0;
        for (int ww = 0; ww < 10; ++ww) {
            sum += workers[ww].sum;
        }

        System.out.println("Sum = " + App.sum);
    }

    // 4950495450495045
    // 2847738140843969

    public static void main1(String[] args) {
        long sum = 0;
        for (int ii = 0; ii < BB; ++ii) {
            if (ii % 101 == 0) {
                    sum += ii;

                // init sum = 0
                // t0: sum += 10
                // t1: sum += 20
                
                // t0: reg1(0) = load from sum
                // t0: reg2(10) = load from ii
                // t1: reg1(0) = load from sum
                // t1: reg2(20) = load from ii
                // t1: reg1(20) += reg2
                // t1: store reg1 to sum (20)
                // t0: reg1(10) += reg2
                // t0: store reg1 to sum (10)
            }
        }
        System.out.println("Sum = " + sum);
    }

}

class Worker implements Runnable {
    int wnum;
    public long sum;

    Worker(int wnum) {
        this.wnum = wnum;
        this.sum = 0;
    }

    public void run() {
        long i0 = wnum * App.npt;
        long i1 = i0 + App.npt;

        for (long ii = i0; ii < i1; ++ii) {
            if (ii % 101 == 0) {
                synchronized (App.mutex) {
                    App.sum += ii;
                }
            }
        }
    }
}
