package demo;

public class App {
    public static void main(String[] args) {
        var sounds = new HashMap<String, String>();
        sounds.put("cow", "moo");
        sounds.put("dog", "arf");
        System.out.println("size " + sounds.size());
        //System.out.println("keys " + sounds.keys());
        System.out.println("cow says " + sounds.get("cow"));

    }
}
