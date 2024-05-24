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
 * RecurrenceIdentifierRange
 *
 * @author Zihlu WANG
 */
public enum RecurrenceIdentifierRange implements PropertyParameter {

    THIS_AND_FUTURE("THISANDFUTURE")
    ;

    private static final String PARAMETER_NAME = "RANGE";

    private final String tag;

    RecurrenceIdentifierRange(String tag) {
        this.tag = tag;
    }

    @Override
    public String resolve() {
        return PARAMETER_NAME + "=" + tag;
    }
}
