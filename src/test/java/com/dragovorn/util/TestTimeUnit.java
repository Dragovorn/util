package com.dragovorn.util;

import com.dragovorn.util.time.TimeUnit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTimeUnit {

    @Test
    public void testFromMillis() {
        assertEquals(1, TimeUnit.SECOND.fromMillis(1000));
    }
}