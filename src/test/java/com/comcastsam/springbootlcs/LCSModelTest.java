package com.comcastsam.springbootlcs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LCSModelTest {

    @Test
    @DisplayName("Test To String")
    public void testToString() {
        Value v1 = new Value("comcast");
        Value v2 = new Value("broadcast");

        LCSModel model = new LCSModel(new ArrayList<Value>() {
            {
                add(v1);
                add(v2);
            }
        });

        String expected = "lcs: {\"value\": \"comcast\",\n\"value\": \"broadcast\",\n}";
        assertEquals(expected, model.toString());
    }

}
