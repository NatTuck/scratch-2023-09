package demo;

public class App {

    public static void main(String[] args) {
        var c1 = new Circle(10);
        var s1 = new Square(12);
        printBigger(c1, s1);
    }

    static void printBigger(Shape xx, Shape yy) {
        if (xx.area() > yy.area()) {
            System.out.println("bigger: " + xx);
        }
        else {
            System.out.println("bigger: " + yy);
        }
    }
}

interface Shape {
    double area();
}

record Circle(double radius) implements Shape {
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}

record Square(double width) implements Shape {
    public double area() {
        return Math.pow(this.width, 2);
    }
}