package demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static demo.App.passingScore;

public class AppShould {

    @Test
    void determine_if_student_passes() {
        // Examples:
        //    87.0 => true
        assertEquals(passingScore(87.0f), true);

        //    25.0 => false
        assertEquals(passingScore(25.0f), false);
        assertEquals(passingScore(25.3f), false);

        assertEquals(passingScore(60.0f), true);
    }
}
