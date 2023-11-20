package demo;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        var xs = new ArrayList<String>();
        xs.add("one");
        xs.add("two");

        for (var xx : xs) {
            System.out.println(xx);
        }
    }
}
