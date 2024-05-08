package com.onixbyte.icalendar.component;

import com.onixbyte.icalendar.property.component.DateTimeStamp;
import com.onixbyte.icalendar.property.component.UniqueIdentifier;

/**
 * Event
 *
 * @author Zihlu WANG
 */
public class Event extends CalendarComponent {

    private DateTimeStamp dtStamp;

    private UniqueIdentifier uid;



    @Override
    public String resolve() {
        return "";
    }
}
