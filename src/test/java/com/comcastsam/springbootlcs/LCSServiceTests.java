package com.comcastsam.springbootlcs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LCSServiceTests {

    private LCSService lcsService = new LCSService();

    @Test
    @DisplayName("Test Example from Project Description")
    void testFindLCS1() {
        List<Value> testList = new ArrayList<>() {
            {
                add(new Value("comcast"));
                add(new Value("comcastic"));
                add(new Value("broadcast"));
            }
        };

        List<Value> expected = new ArrayList<>() {
            {
                add(new Value("cast"));
            }
        };

        assertEquals(expected.toString(), lcsService.findLCS(testList).toString());
    }

    @Test
    @DisplayName("Test No Matches")
    void testFindLCSNoMatches() {
        List<Value> testList = new ArrayList<>() {
            {
                add(new Value("abcde"));
                add(new Value("fghij"));
                add(new Value("klmno"));
            }
        };

        List<String> expected = new ArrayList<>();
        assertEquals(expected.toString(), lcsService.findLCS(testList).toString());
    }

    @Test
    @DisplayName("Test Multiple Matches")
    void testFindLCSMultipleMatches() {
        List<Value> testList = new ArrayList<>() {
            {
                add(new Value("abc1def1ghi"));
                add(new Value("def2ghi2abc"));
                add(new Value("ghi3abc3def"));
            }
        };

        List<Value> expected = new ArrayList<>() {
            {
                add(new Value("abc"));
                add(new Value("def"));
                add(new Value("ghi"));
            }
        };

        assertEquals(expected.toString(), lcsService.findLCS(testList).toString());
    }

    @Test
    @DisplayName("Test Non Unique Set")
    void testFindLCSNonUniqueSet() {
        List<Value> testList = new ArrayList<>() {
            {
                add(new Value("abcdefghi"));
                add(new Value("jklmopqrs"));
                add(new Value("abcdefghi"));
            }
        };
        Exception exception = assertThrows(RuntimeException.class, () -> {
            lcsService.findLCS(testList);
        });

        assertEquals("setOfStrings must be a set", exception.getMessage());
    }

    @Test
    @DisplayName("Test Empty Set")
    void testFindLCSEmptySet() {
        List<Value> testList = new ArrayList<>();
        Exception exception = assertThrows(RuntimeException.class, () -> {
            lcsService.findLCS(testList);
        });

        assertEquals("setOfStrings cannot be empty", exception.getMessage());
    }

}
