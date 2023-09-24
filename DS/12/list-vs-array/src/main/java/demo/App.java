package demo;


public class App {
    public static void main(String[] args) {
        ArrayWrap<Integer> xs = new ArrayWrap<Integer>(2);
        xs.set(0, 1);
        xs.set(1, 2);

        xs.resize(3);

        xs.set(2, 4);

        xs.resize(2);

        System.out.println("xs = " + xs);
 
        var ys = xs.map((xx) -> xx * 10);
        
        System.out.println("ys = " + ys);

        ys.forEach((yy) -> yy - 3);

        System.out.println("ys = " + ys);
    }

    public static void main1(String[] args) {
        int[] xs = {1, 2, 4};

        int sum = 0;
        for (int ii = 0; ii < xs.length; ++ii) {
            sum += xs[ii];
        }

        System.out.println("sum = " + sum);

    }


}
