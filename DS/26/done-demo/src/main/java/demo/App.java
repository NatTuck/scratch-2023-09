package demo;

public class App {
    public static void main(String[] args) {
        /*
        var sounds = new HashMap<String, String>();
        sounds.put("cow", "moo");
        sounds.put("dog", "arf");
        System.out.println("size " + sounds.size());
        System.out.println("keys " + sounds.keys());
        System.out.println("cow says " + sounds.get("cow"));
        sounds.del("cow");
        System.out.println("size " + sounds.size());
        System.out.println("keys " + sounds.keys());
        */

        var squares = new HashMap<Integer, Integer>();
        for (int ii = 0; ii < 100; ii += 5) {
            squares.put(ii, ii*ii);
        }

        System.out.println("20*20 = " + squares.get(20));
        System.out.println("size " + squares.size());
        System.out.println("capacity " + squares.capacity());
        System.out.println("keys " + squares.keys());
    }
}
