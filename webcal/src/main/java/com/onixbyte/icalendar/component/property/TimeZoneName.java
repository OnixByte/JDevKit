package com.onixbyte.icalendar.component.property;

import com.onixbyte.icalendar.property.parameter.Language;

import java.util.Optional;

public record TimeZoneName(Language language, String value) implements ComponentProperty {

    private static final String PROPERTY_NAME = "TZNAME";

    @Override
    public String resolve() {
        var builder = new StringBuilder(PROPERTY_NAME);

        Optional.ofNullable(language)
                .ifPresent((lang) -> builder.append(";").append(lang.resolve()));

        builder.append(":")
                .append(value)
                .append("\n");

        return builder.toString();
    }
}
