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

package com.onixbyte.icalendar.property.parameter;

import com.onixbyte.icalendar.datatype.CalendarUserAddress;

import java.net.URI;

/**
 * SentBy
 *
 * @author Zihlu WANG
 */
public final class SentBy implements PropertyParameter {

    private static final String PARAMETER_NAME = "SENT-BY";

    private final CalendarUserAddress value;

    private SentBy(CalendarUserAddress value) {
        this.value = value;
    }

    public static class Builder {
        private CalendarUserAddress sentBy;

        private Builder() {
        }

        public Builder sentBy(CalendarUserAddress sentBy) {
            this.sentBy = sentBy;
            return this;
        }

        public Builder sentBy(String sentBy) {
            this.sentBy = new CalendarUserAddress(sentBy);
            return this;
        }

        public Builder sentBy(URI sentBy) {
            this.sentBy = new CalendarUserAddress(sentBy);
            return this;
        }

        public SentBy build() {
            return new SentBy(sentBy);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String resolve() {
        return PARAMETER_NAME + "=\"" + value + "\"";
    }
}
