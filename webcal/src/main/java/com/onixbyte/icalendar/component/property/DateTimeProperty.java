/*
 * Copyright (C) 2024-2024 OnixByte.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.onixbyte.icalendar.component.property;

import com.onixbyte.icalendar.core.DateTimeFormatters;
import com.onixbyte.icalendar.property.parameter.ValueDataType;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public interface DateTimeProperty {

    List<ValueDataType> SUPPORTED_VALUES = List.of(
            ValueDataType.DATE,
            ValueDataType.DATE_TIME
    );

    static String composeResolution(String propertyName,
                                    ValueDataType valueDataType,
                                    LocalDateTime localDateTime) {
        var dateTimeEndBuilder = new StringBuilder(propertyName);

        Optional.ofNullable(valueDataType)
                .filter(SUPPORTED_VALUES::contains)
                .ifPresent((value) -> dateTimeEndBuilder.append(";").append(value.resolve()));

        var dateTimeFormatter = switch (Optional.ofNullable(valueDataType)
                .filter(SUPPORTED_VALUES::contains)
                .orElse(ValueDataType.DATE_TIME)) {
            case DATE -> DateTimeFormatters.dateFormatter();
            case BINARY, UTC_OFFSET, BOOLEAN, CAL_ADDRESS, DURATION, FLOAT, INTEGER, PERIOD,
                 RECURRENCE_RULE, TEXT, URI, DATE_TIME -> DateTimeFormatters.utcDateTimeFormatter();
        };

        dateTimeEndBuilder.append(":")
                .append(localDateTime.atZone(ZoneId.systemDefault())
                        .withZoneSameInstant(ZoneId.of("UTC"))
                        .format(dateTimeFormatter))
                .append("\n");
        return dateTimeEndBuilder.toString();
    }

}
