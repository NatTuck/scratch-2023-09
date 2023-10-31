package demo;

public class App {
    public static void main(String[] args) {
        var sounds = new HashMap<String, String>();
        System.out.println("Put two items");
        sounds.put("cow", "moo");
        sounds.put("dog", "arf");
        sounds.put("bird", "squak");
        sounds.put("cat", "meow");
        sounds.put("frog", "ribbit");

        for (var key : sounds.keys()) {
            System.out.println("key: " + key);
        }

        System.out.println("capacity = " + sounds.capacity());
    }
}
