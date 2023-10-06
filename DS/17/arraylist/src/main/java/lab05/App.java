package lab05;

/**
 * Our App.
 */
public class App {
    public static void main(String[] args) {
        Chess.chess();
    }

    public static void main1(String[] args) {
        var xs = new ArrayList<Mouse>();

        xs.append(new Mouse("Alice"));
        xs.append(new Mouse("Bob"));
        xs.append(new Mouse("Carol"));

        var xs1 = xs.map((mm) -> new Mouse(mm.name() + " McMouse"));

        System.out.println(xs1);

        var ys = new ArrayList<Integer>();
        ys.append(1);
        ys.append(2);
        ys.append(3);
        //ys.append(4);

        var ys1 = ys.map((yy) -> 2*yy);
        System.out.println(ys1);
    }
}

record Mouse(String name) { }
