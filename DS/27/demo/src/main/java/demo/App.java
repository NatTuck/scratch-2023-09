package demo;

public class App {
    public static void main(String[] args) {
        var xs = new MinHeap();
        xs.insert(23);
        xs.insert(5);
        xs.insert(2);
        xs.insert(24);
        xs.insert(7);
        xs.insert(13);
        xs.insert(1);
        xs.insert(44);
        xs.insert(6);
        System.out.println(xs.next());
    }
}
