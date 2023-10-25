package demo;

public class App {

    public static void main(String[] args) {
        var sounds = HashMap<String, String>();
        sounds.put("cow", "moo");
        sounds.put("dog", "arf");
        System.out.println("cow says " + sounds.get("cow"));
    }
}
