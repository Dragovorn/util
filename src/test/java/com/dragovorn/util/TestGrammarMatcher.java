package com.dragovorn.util;

import com.dragovorn.util.lang.GrammarMatcher;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGrammarMatcher {

    @Test
    public void testGrammarMatcher() {
        GrammarMatcher matcher = new GrammarMatcher("* ?itest TEST");

        assertEquals(true, matcher.matches("LUL TeSt TEST"));
        assertEquals(false, matcher.matches("LUL TeT TEST"));
        assertEquals(false, matcher.matches("LUL TeSt tEST"));

        matcher = new GrammarMatcher("* \\?itest TEST");

        assertEquals(false, matcher.matches("LUL TeSt TEST"));
        assertEquals(false, matcher.matches("LUL TeT TEST"));
        assertEquals(false, matcher.matches("LUL TeSt tEST"));
    }
}