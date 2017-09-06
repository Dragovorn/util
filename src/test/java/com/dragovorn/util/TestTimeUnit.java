package com.dragovorn.util;

import com.dragovorn.util.time.TimeUnit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTimeUnit {

    @Test
    public void testFromMillis() {
        assertEquals(1, TimeUnit.SECOND.fromMillis(1000));
    }

    @Test
    public void testGetConversion() {
        assertEquals(1000, TimeUnit.SECOND.getConversion());
    }

    @Test
    public void testRemainingMillis() {
        long millis = 1042;

        assertEquals(42L, TimeUnit.SECOND.remainingMillis(millis));
    }

    @Test
    public void testToMillis() {
        assertEquals(1000, TimeUnit.SECOND.toMillis(1));
    }
}