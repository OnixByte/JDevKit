package com.onixbyte.icalendar.property.calendar;

import com.onixbyte.icalendar.property.Prop;

/**
 * Version
 *
 * @author Zihlu WANG
 */
public enum Version implements Prop {

    VERSION_2_0,
    ;

    @Override
    public String resolve() {
        return "VERSION:" + switch (this) {
            case VERSION_2_0 -> "2.0";
        };
    }
}
