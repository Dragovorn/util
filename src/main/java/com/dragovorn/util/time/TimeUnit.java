package com.dragovorn.util.time;

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

    public long getConversion() {
        return this.conversion;
    }

    public long remainingMillis(long num) {
        return num % this.conversion;
    }

    public int fromMillis(long num) {
        return (int) (num / this.conversion);
    }

    public long toMillis(int num) {
        return (long) num * this.conversion;
    }
}