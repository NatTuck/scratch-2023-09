package demo;

public class App {
<<<<<<< HEAD

    public static void main(String[] args) {
        var sounds = new HashMap<String, String>();
        sounds.put("cow", "moo");
        sounds.put("dog", "arf");
        System.out.println("cow says " + sounds.get("cow"));
=======
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
>>>>>>> 736cc00faba2d79840b5a7419bde77125482466e
    }
}
