package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCase2 {

    @Test
    void additionWorks() {
        assertEquals(4, 2 + 2);
    }

    @Test
    void stringNotEmpty() {
        assertFalse("jenkins".isBlank());
    }
}
