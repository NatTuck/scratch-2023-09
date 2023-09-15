package demo;

public class Abstraction {

    public static void main(String[] args) {
        // subtotal $25.93
        //  + 8.5%
        double mealTotal1 = 25.93 * 1.085;

        // subtotal $33.81
        double mealTotal2 = 33.81 * 1.085;


        // rect1 is 3 x 7
        int area1 = 3 * 7;

        // rect2 is 4 x 9
        int area2 = 4 * 9;

        // Abstract over types with shared
        // methods: Interfaces

        var aa = new Pair<String>("this", "that");
        System.out.println("aa.left() = " + aa.left());
    }

    static double addTax(double subtotal) {
        return subtotal * 1.085;
    }
}

record Rect(int width, int height) {
    int area() {
        return width * height;
    }
}

record DoublePair(double left, double right) {}
record StringPair(String left, String right) {}

record Pair<T>(T left, T right) {}


