package com.comcastsam.springbootlcs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValueTests {

    @Test
    @DisplayName("Test To String")
    public void testToString() {
        Value v = new Value("comcast");
        String expected = "\"value\": \"comcast\"";
        assertEquals(expected, v.toString());
    }
}
