package lab08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinTreeShould {
    @Test
    void do_basic_tree_stuff() {
        var xs = BinTree.<Integer>makeEmpty();
        assertTrue(xs.isLeaf());

        xs = xs.insert(5);
        assertEquals(5, xs.data());
        xs = xs.insert(3);
        assertEquals(3, xs.left().data());
        xs = xs.insert(7);
        assertEquals(7, xs.right().data());
        assertEquals(5, xs.data());
        assertEquals(3, xs.length());
    }

}
