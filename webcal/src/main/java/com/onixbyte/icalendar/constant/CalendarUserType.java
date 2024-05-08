package com.onixbyte.icalendar.constant;

public enum CalendarUserType {

    INDIVIDUAL,
    GROUP,
    RESOURCE,
    ROOM,
    UNKNOWN,
    ;

    @Override
    public String toString() {
        return name();
    }
}
