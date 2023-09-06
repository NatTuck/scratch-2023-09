package demo;

import image.*;
import world.*;

public class App {
    public static void main(String[] args) {
        var d4 = new NestingDoll("pink", null);
        var d3 = new NestingDoll("blue", d4);
        var d2 = new NestingDoll("yellow", d3);
        var d1 = new NestingDoll("green", d2);
        var d0 = new NestingDoll("orange", d1);
        var world0 = new DollWorld(d0);
        world0.bigBang();
    }

    public static void main2(String[] args) {
        var h0 = new Hat("blue");
        var d0 = new Doll("darkgreen", h0);
        //var world0 = new DollWorld(d0);
        //world0.bigBang();
    }

    public static void main1(String[] args) {
        System.out.println("Hello World");

        var car1 = new Car(5.0, 10.0);
        var car2 = new Car(5.0, 10.0);


        System.out.println("== " + (car1 == car2));
        System.out.println("equals? " + car1.equals(car2));

    }
}

/**
 * 
 * @param  inner  A doll or null if this is the innermost
 */
record NestingDoll(String color, NestingDoll inner) {
    int depth() {
        if (this.inner == null) {
            return 1;
        }
        else {
            return 1 + this.inner.depth();
        } 
    }

    /**
     * Draw a doll and the dolls it contains.
     * 
     * @return  image of the doll
     */
    Image draw() {
        var img = new Circle(20 * this.depth(), 
            "solid", this.color);
        if (inner == null) {
            return img;
        }
        else {
            return img.overlay(inner.draw());
        }
    }

    // Template
    /*
        Image draw() {
        ... this.color ...
        ... this.innner ...
        ... this.inner.color ...
        ... this.inner.inner ...
    }
    */

}

record Hat(String color) {
    Image draw() {
        return new Triangle(80, "solid", this.color); 
    }

    // Template
    /*
    Image draw() {
        ... this.color ...
    }
    */
}

record Doll(String color, Hat hat) {
    Image draw() {
        return new Circle(80, "solid", this.color)
            .overlayxy(-40, 75, this.hat.draw());
    }

    // Template
    /*
    Image draw() {
        ... this.color ... this.hat ...
    }
    */
}

class DollWorld extends World {
    final NestingDoll doll;

    DollWorld(NestingDoll d0) {
        this.doll = d0;
    }

    @Override
    public Scene onDraw() {
        var bg = new EmptyScene(800, 600);
        var fg = doll.draw();
        return bg.placeImage(fg, 400, 300);
    }
}



    // record Car(double tankSize, double mileage) {}

    class Car {
        final double tankSize;
        final double mileage;
        // final double maxRange;

        Car(double tankSize, double mileage) {
            this.tankSize = 5.0;
            this.mileage = 10.0;
        }

        double tankSize() {
            return this.tankSize;
        }

        double mileage() {
            return this.mileage;
        }

        double maxRange() {
            return this.tankSize * this.mileage;
        }

        @Override
        public boolean equals(Object yy) {
            if (yy instanceof Car) {
                Car that = (Car) yy;
                return this.tankSize == that.tankSize
                    && this.mileage == that.mileage;
            }
            else {
                return false;
            }
        }

        // @Override
        // String toString

        // @Override
        // int hashCode
    }

    // Problem: Those values are mutable

