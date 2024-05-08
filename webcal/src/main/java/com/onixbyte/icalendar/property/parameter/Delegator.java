package com.onixbyte.icalendar.property.parameter;

import com.onixbyte.icalendar.property.Prop;

import java.net.URI;

/**
 * Delegator
 *
 * @author Zihlu WANG
 */
public final class Delegator implements Prop {

    private static final String PROPERTY_NAME = "DELEGATED-FROM";

    private URI calendarUserAddress;

    private Delegator() {
    }

    private Delegator setCalendarUserAddress(String calendarUserAddress) {
        this.calendarUserAddress = URI.create(calendarUserAddress);
        return this;
    }

    private Delegator setCalendarUserAddress(URI calendarUserAddress) {
        this.calendarUserAddress = calendarUserAddress;
        return this;
    }

    private static Delegator initialiseInstance() {
        return new Delegator();
    }
    
    public static Delegator createInstance(String calendarUserAddress) {
        return initialiseInstance().setCalendarUserAddress(calendarUserAddress);
    }

    public static Delegator createInstance(URI calendarUserAddress) {
        return initialiseInstance().setCalendarUserAddress(calendarUserAddress);
    }

    @Override
    public String resolve() {
        return PROPERTY_NAME + "=\"" + calendarUserAddress + "\"";
    }
}
