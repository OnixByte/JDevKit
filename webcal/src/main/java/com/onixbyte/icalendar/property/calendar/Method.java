package com.onixbyte.icalendar.property.calendar;

import com.onixbyte.icalendar.property.Prop;

public enum Method implements Prop {

    PUBLISH("PUBLISH"),
    REQUEST("REQUEST"),
    REPLY("REPLY"),
    ADD("ADD"),
    CANCEL("CANCEL"),
    REFRESH("REFRESH"),
    COUNTER("COUNTER"),
    DECLINE_COUNTER("DECLINECOUNTER"),
    ;

    private final String label;

    private static final String PROPERTY_NAME = "METHOD";

    Method(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public String resolve() {
        return PROPERTY_NAME + ":" + label;
    }

}
