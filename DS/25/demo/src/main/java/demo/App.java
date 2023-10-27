package demo;

public class App {

    public static void main(String[] args) {
        var sounds = new HashMap<String, String>();
        sounds.put("cow", "moo");
        sounds.put("dog", "arf");
        System.out.println("cow says " + sounds.get("cow"));

        var ns = new HashMap<Integer, String>();
        for (int ii = 0; ii < 101; ++ii) {
            int xx = ((ii + 1) * 4951) % 101;
            ns.put(xx, "z"+xx);
            System.out.println(ns.loadFactor());
        }
    }
}
