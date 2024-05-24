package com.onixbyte.icalendar.component.property;

public record SequenceNumber(Integer sequence) implements ComponentProperty {

    private static final String PROPERTY_NAME = "SEQUENCE";

    @Override
    public String resolve() {
        return PROPERTY_NAME + ":" + sequence + "\n";
    }
}
