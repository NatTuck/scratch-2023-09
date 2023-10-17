package lab08;

//import java.util.Arrays;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        var xs = BinTree.<Integer>makeEmpty();
        xs = xs.insert(5);
        xs = xs.insert(3);
        xs = xs.insert(1);
        xs = xs.insert(4);

        var ys = new ArrayList<Integer>();
        xs.each((xx) -> ys.add(xx));

        System.out.println("" + ys);
    }
}

 
