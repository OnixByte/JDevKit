package com.onixbyte.icalendar.property.parameter;

import com.onixbyte.icalendar.property.Prop;

/**
 * FormatType
 *
 * @author Zihlu WANG
 */
public enum FormatType implements Prop {

    JSON("application/json"),

    ;

    private final String ianaRegistry;

    FormatType(String ianaRegistry) {
        this.ianaRegistry = ianaRegistry;
    }

    @Override
    public String resolve() {
        return "FMTTYPE:" + this.ianaRegistry;
    }
}
