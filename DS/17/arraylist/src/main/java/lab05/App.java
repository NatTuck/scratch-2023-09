package lab05;

/**
 * Our App.
 */
public class App {
    public static void main(String[] args) {
        var xs = new ArrayList<Mouse>();

        xs.append(new Mouse("Alice"));
        xs.append(new Mouse("Bob"));
        xs.append(new Mouse("Carol"));

        xs.map((mm) -> new Mouse(mm.name() + " McMouse"));

        System.out.println(xs);
    }
}

record Mouse(String name) { }
