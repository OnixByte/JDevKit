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

import com.onixbyte.icalendar.datatype.Period;
import com.onixbyte.icalendar.property.parameter.FreeBusyTimeType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class FreeBusyTime implements ComponentProperty {

    private static final String PROPERTY_NAME = "FREEBUSY";

    private final FreeBusyTimeType freeBusyType;

    private final List<Period> freeBusyValue;

    public static class Builder {
        public Builder freeBusyType(FreeBusyTimeType freeBusyType) {
            this.freeBusyType = freeBusyType;
            return this;
        }

        public Builder addFreeBusyValue(Period period) {
            this.freeBusyValue.add(period);
            return this;
        }

        public FreeBusyTime build() {
            return new FreeBusyTime(freeBusyType, freeBusyValue);
        }

        private FreeBusyTimeType freeBusyType;

        private final List<Period> freeBusyValue;

        private Builder() {
            this.freeBusyValue = new ArrayList<>();
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String resolve() {
        var freeBusyBuilder = new StringBuilder(PROPERTY_NAME);

        Optional.ofNullable(freeBusyType)
                .ifPresent((type) -> freeBusyBuilder.append(";").append(type.resolve()));

        freeBusyBuilder.append(":").append(String.join(",", freeBusyValue
                .stream()
                .map(Period::resolve)
                .toList()))
                .append("\n");

        return freeBusyBuilder.toString();
    }

    private FreeBusyTime(FreeBusyTimeType freeBusyType, List<Period> freeBusyValue) {
        this.freeBusyType = freeBusyType;
        this.freeBusyValue = freeBusyValue;
    }
}
