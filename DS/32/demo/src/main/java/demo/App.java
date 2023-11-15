package demo;

public class App {
    static Account alice;
    static Account bob;

    public static void main(String[] args) throws Exception {
        alice = new Account("Alice", 10);
        bob = new Account("Bob", 10);

        var ta = new ThreadA();
        ta.start();

        var tb = new ThreadB();
        tb.start();

        ta.join();
        tb.join();

        System.out.println("All done");
    }
}

class Account {
    String name;
    int balance;

    Account(String nn, int bb) {
        this.name = nn;
        this.balance = bb;
    }

    synchronized void transferTo(Account that) throws Exception {
        if (balance <= 0) {
            return;
        }

        System.out.println("Transferring $1 from " + this.name +
                           " to " + that.name);
        // in synchronized method
        
        this.balance -= 1;

        Thread.sleep(1000);


        //that.incrementBalance();
        synchronized (that) {
            that.balance += 1;
        }
    }

    /*
    synchronized void xx() {
        // ...
    }

    void yy() {
        synchronized (this) {
            // ...
        }
    }
    */
}

class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            App.alice.transferTo(App.bob);
        }
        catch (Exception ee) {
            // pass
        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            App.bob.transferTo(App.alice);
        }
        catch (Exception ee) {
            // pass
        }
    }
}
