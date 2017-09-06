package com.dragovorn.util;

import com.dragovorn.util.time.DateHelper;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestDateHelper {

    @Test
    public void testReadableDate() {
        Date date = new Date(1504701052219L);

        assertEquals("Wed, Sep 6th, 2017 at 12:30 PM", DateHelper.readableDate(date));
    }
}