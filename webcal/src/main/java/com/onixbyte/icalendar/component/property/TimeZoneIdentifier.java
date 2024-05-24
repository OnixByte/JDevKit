package com.onixbyte.icalendar.component.property;

import java.time.ZoneId;

public final class TimeZoneIdentifier implements ComponentProperty {

    private static final String PROPERTY_NAME = "TZID";

    private final ZoneId timeZoneIdentifier;

    public TimeZoneIdentifier(String timeZoneIdentifier) {
        this.timeZoneIdentifier = ZoneId.of(timeZoneIdentifier);
    }

    @Override
    public String resolve() {
        return PROPERTY_NAME + ":" + timeZoneIdentifier + "\n";
    }
}
