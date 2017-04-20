package com.dragovorn.util.time;

/**
 * A TimeUnit Library to make milliseconds to simple readable format
 * conversion easier.
 *
 * @author Andrew Burr
 * @since 0.0.1
 * @version 1.1
 */
public enum TimeUnit {
    YEAR((long) (3.154 * Math.pow(10, 10))),
    MONTH((long) (2.628 * Math.pow(10, 9))),
    DAY((long) (8.64 * Math.pow(10, 7))),
    HOUR((long) (3.6 * Math.pow(10, 6))),
    MINUTE((long) (6 * Math.pow(10, 4))),
    SECOND((long) (1 * Math.pow(10, 3)));

    private long conversion;

    TimeUnit(long conversion) {
        this.conversion = conversion;
    }

    /**
     * Gets the conversion of a specific TimeUnit.
     *
     * @return Conversion of the TimeUnit
     */
    public long getConversion() {
        return this.conversion;
    }

    /**
     * Calculates the Milliseconds remaining after a conversion
     * e.g. 64000 Millis converted to minutes would be 1.4 minutes
     * but the method for calculating returns an int so it would return 1
     * this method when run on 64000 would return 4000 as that is
     * the remainder of the conversion.
     *
     * @param millis The milliseconds to calculate remainder from
     * @return The remainder milliseconds
     */
    public long remainingMillis(long millis) {
        return millis % this.conversion;
    }

    /**
     * Returns a simple number of the TimeUnit from milliseconds
     * e.g. 60000 Millis converted to minutes would return 1
     *
     * @param millis The milliseconds to convert to simple number.
     * @return The simple number of this TimeUnit in regard to the given millis.
     */
    public int fromMillis(long millis) {
        return (int) Math.floor(millis / this.conversion);
    }

    /**
     * Converts a simple number to the TimeUnit milliseconds
     * e.g. 1 converted to minutes millis would return 60000
     *
     * @param num The number to convert from
     * @return The conversion in millis
     */
    public long toMillis(int num) {
        return (long) num * this.conversion;
    }
}