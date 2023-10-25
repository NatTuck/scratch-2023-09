package lab09;

public class App {

    public static void main(String[] args) {
        var ys = new TreeMap<Integer>();
        for (int ii = 0; ii < 20; ++ii) {
            int zz = (229*ii+30) % 61;
            ys.insert(zz);
        }

        System.out.println(ys);
        System.out.println(ys.toList());
    }
}
