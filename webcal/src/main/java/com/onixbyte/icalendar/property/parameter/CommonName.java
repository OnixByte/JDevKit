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

/**
 * Common Name can be specified on properties with a CAL-ADDRESS value type. The parameter
 * specifies the common name to be associated with the calendar user specified by the property.
 * The parameter value is text. The parameter value can be used for display text to be associated
 * with the calendar address specified by the property.
 *
 * @author Zihlu Wang
 */
public final class CommonName implements PropertyParameter {

    private static final String PARAMETER_NAME = "CN";

    private final String value;

    private CommonName(String value) {
        this.value = value;
    }

    public static class Builder {
        private String value;

        private Builder() {
        }

        public Builder commonName(String commonName) {
            this.value = commonName;
            return this;
        }

        public CommonName build() {
            return new CommonName(value);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String resolve() {
        return PARAMETER_NAME + "=\"" + this.value + "\"";
    }
}
