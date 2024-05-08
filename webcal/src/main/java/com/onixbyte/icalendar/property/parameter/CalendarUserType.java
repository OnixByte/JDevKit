package com.onixbyte.icalendar.property.parameter;

import com.onixbyte.icalendar.property.Prop;

/**
 * CalendarUserType
 *
 * @author Zihlu WANG
 */
public enum CalendarUserType implements Prop {

    /**
     * An individual.
     */
    INDIVIDUAL,

    /**
     * A group of individuals.
     */
    GROUP,

    /**
     * A physical resource.
     */
    RESOURCE,

    /**
     * A room resource.
     */
    ROOM,

    /**
     * Otherwise not known.
     */
    UNKNOWN,
    ;

    private static final String PROPERTY_NAME = "CUTYPE";

    @Override
    public String resolve() {
        return PROPERTY_NAME + "=" + this.name();
    }
}
