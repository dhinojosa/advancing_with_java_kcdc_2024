package com.xyzcorp.records;

record Range(int min, int max) {
    public Range {
        if (min > max)
            throw new IllegalArgumentException("Max must be >= min");
    }

    public Range(int max) {
        this(0, max);
    }
}
