package com.onixbyte.icalendar.property.calendar;

import com.onixbyte.icalendar.property.Prop;

/**
 * CalendarScale
 *
 * @author Zihlu WANG
 */
public enum CalendarScale implements Prop {

    GREGORIAN,
    ;

    private static final String PROPERTY_NAME = "CALSCALE";

    @Override
    public String resolve() {
        return PROPERTY_NAME + ':' + this.name();
    }

}
