package demo;

//import java.util.Iterator;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        BinTree<Integer> xs = new BinLeaf<Integer>();
        xs.insert(5);

        System.out.println("" + xs);
    }
}
