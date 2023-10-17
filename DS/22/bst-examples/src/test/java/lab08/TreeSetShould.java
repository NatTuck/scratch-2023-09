package lab08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreeSetShould {
    @Test
    void add_and_remove_items() {
        var xs = TreeSet.set(2, 6, 15);
        var ys = xs.add(5);
        assertEquals(TreeSet.set(2, 5, 6, 15), ys);
        var zs = ys.remove(6);
        assertEquals(TreeSet.set(2, 5, 15), zs);
    }

    @Test
    void do_contains() {
        var xs = TreeSet.set("aa", "cc", "dd");
        assertTrue(xs.contains("aa"));
        assertTrue(!xs.contains("bb"));
        assertTrue(xs.contains("cc"));
        assertTrue(xs.contains("dd"));
        assertTrue(!xs.contains("aaa"));
        assertTrue(!xs.contains(""));
    }

    @Test
    void do_union() {
        var xs = TreeSet.set(3, 6, 9);
        var ys = TreeSet.set(2, 4, 6);
        assertEquals(TreeSet.set(2, 3, 4, 6, 9), xs.union(ys));
        assertEquals(TreeSet.set(2, 3, 4, 6, 9), ys.union(xs));
        assertEquals(xs, xs.union(xs));
        assertEquals(ys, ys.union(ys));
    }

    @Test
    void do_intersection() {
        var xs = TreeSet.set(3, 6, 9);
        var ys = TreeSet.set(2, 4, 6);
        var zs = TreeSet.set(2, 4, 8, 16);
        assertEquals(TreeSet.set(6), xs.intersection(ys));
        assertEquals(TreeSet.set(2, 4), zs.intersection(ys));
        assertEquals(xs, xs.intersection(xs));
    }

    @Test
    void do_subset() {
        var xs = TreeSet.set(3, 6);
        var ys = TreeSet.set(2, 3, 5, 6, 8);
        var zs = TreeSet.set(2, 5, 6, 8);
        assertTrue(xs.isSubset(xs));
        assertTrue(xs.isSubset(ys));
        assertTrue(!xs.isSubset(zs));
    }

    @Test
    void do_superset() {
        var xs = TreeSet.set(3, 6);
        var ys = TreeSet.set(2, 3, 5, 6, 8);
        var zs = TreeSet.set(2, 5, 6, 8);
        assertTrue(ys.isSuperset(ys));
        assertTrue(ys.isSuperset(xs));
        assertTrue(!xs.isSuperset(ys));
        assertTrue(!zs.isSuperset(xs));
    }

    @Test
    void set_of_sets() {
        var xs = TreeSet.set(TreeSet.set("a", "b"), TreeSet.set("a"));
        assertTrue(xs.contains(TreeSet.set("a", "b")));
        assertTrue(!xs.contains(TreeSet.set("a", "c")));
    }
}
