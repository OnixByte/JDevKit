package com.onixbyte.icalendar.property.component;

import com.onixbyte.icalendar.property.Prop;
import com.onixbyte.icalendar.property.parameter.FormatType;

import java.net.URI;

/**
 * Attach
 *
 * @author Zihlu WANG
 */
public final class Attach implements Prop {

    private FormatType formatType;

    private URI uri;

    @Override
    public String resolve() {
        return "";
    }
}
