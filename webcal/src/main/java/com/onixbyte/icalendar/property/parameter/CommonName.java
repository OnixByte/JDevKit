package com.onixbyte.icalendar.property.parameter;

import com.onixbyte.icalendar.property.Prop;

/**
 * Common Name can be specified on properties with a CAL-ADDRESS value type. The parameter
 * specifies the common name to be associated with the calendar user specified by the property.
 * The parameter value is text. The parameter value can be used for display text to be associated
 * with the calendar address specified by the property.
 *
 * @author Zihlu Wang
 */
public final class CommonName implements Prop {

    private String value;

    private CommonName() {
    }

    public CommonName setValue(String value) {
        this.value = value;
        return this;
    }

    public static CommonName createInstance(String commonName) {
        var instance = new CommonName();
        instance.value = commonName;
        return instance;
    }

    @Override
    public String resolve() {
        return "CN=\"" + this.value + "\"";
    }
}
