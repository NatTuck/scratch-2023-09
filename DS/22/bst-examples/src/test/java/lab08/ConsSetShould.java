package lab08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsSetShould {
    @Test
    void do_basic_list_stuff() {
        var xs = ConsSet.<Integer>set();
        assertTrue(xs.isEmpty());

        var ys = xs.add(5);
        assertEquals(5, ys.first());

        var zs = ys.add(3);
        assertEquals(3, zs.first());
        assertEquals(5, zs.rest().first());

        assertEquals(2, zs.size());
    }

    @Test
    void add_and_remove_items() {
        var xs = ConsSet.set(2, 6, 15);
        var ys = xs.add(5);
        assertEquals(ConsSet.set(2, 5, 6, 15), ys);
        var zs = ys.remove(6);
        assertEquals(ConsSet.set(2, 5, 15), zs);
    }

    @Test
    void do_contains() {
        var xs = ConsSet.set("aa", "cc", "dd");
        assertTrue(xs.contains("aa"));
        assertTrue(!xs.contains("bb"));
        assertTrue(xs.contains("cc"));
        assertTrue(xs.contains("dd"));
        assertTrue(!xs.contains("aaa"));
        assertTrue(!xs.contains(""));
    }

    @Test
    void do_union() {
        var xs = ConsSet.set(3, 6, 9);
        var ys = ConsSet.set(2, 4, 6);
        assertEquals(ConsSet.set(2, 3, 4, 6, 9), xs.union(ys));
        assertEquals(ConsSet.set(2, 3, 4, 6, 9), ys.union(xs));
        assertEquals(xs, xs.union(xs));
        assertEquals(ys, ys.union(ys));
    }

    @Test
    void do_intersection() {
        var xs = ConsSet.set(3, 6, 9);
        var ys = ConsSet.set(2, 4, 6);
        var zs = ConsSet.set(2, 4, 8, 16);
        assertEquals(ConsSet.set(6), xs.intersection(ys));
        assertEquals(ConsSet.set(2, 4), zs.intersection(ys));
        assertEquals(xs, xs.intersection(xs));
    }

    @Test
    void do_subset() {
        var xs = ConsSet.set(3, 6);
        var ys = ConsSet.set(2, 3, 5, 6, 8);
        var zs = ConsSet.set(2, 5, 6, 8);
        assertTrue(xs.isSubset(xs));
        assertTrue(xs.isSubset(ys));
        assertTrue(!xs.isSubset(zs));
    }

    @Test
    void do_superset() {
        var xs = ConsSet.set(3, 6);
        var ys = ConsSet.set(2, 3, 5, 6, 8);
        var zs = ConsSet.set(2, 5, 6, 8);
        assertTrue(ys.isSuperset(ys));
        assertTrue(ys.isSuperset(xs));
        assertTrue(!xs.isSuperset(ys));
        assertTrue(!zs.isSuperset(xs));
    }

    @Test
    void set_of_sets() {
        var xs = ConsSet.set(ConsSet.set("a", "b"), ConsSet.set("a"));
        assertTrue(xs.contains(ConsSet.set("a", "b")));
        assertTrue(!xs.contains(ConsSet.set("a", "c")));
    }
}
