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
 * ValueDataType
 *
 * @author Zihlu WANG
 */
public enum ValueDataType implements PropertyParameter {

    BINARY("BINARY"),
    BOOLEAN("BOOLEAN"),
    CAL_ADDRESS("CAL-ADDRESS"),
    DATE("DATE"),
    DATE_TIME("DATE-TIME"),
    DURATION("DURATION"),
    FLOAT("FLOAT"),
    INTEGER("INTEGER"),
    PERIOD("PERIOD"),
    RECURRENCE_RULE("RECUR"),
    TEXT("TEXT"),
    URI("URI"),
    UTC_OFFSET("UTC-OFFSET"),
    ;

    private static final String PARAMETER_NAME = "VALUE";

    private final String tag;

    ValueDataType(String tag) {
        this.tag = tag;
    }

    @Override
    public String resolve() {
        return PARAMETER_NAME + "=" + tag;
    }
}
