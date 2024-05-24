package com.onixbyte.icalendar.component.property;

public enum TimeTransparency implements ComponentProperty {

    OPAQUE,
    TRANSPARENT,
    ;

    private static final String PROPERTY_NAME = "TRANSP";

    @Override
    public String resolve() {
        return PROPERTY_NAME + ":" + name() + "\n";
    }
}
