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

import com.onixbyte.icalendar.property.CalendarResolvable;

import java.net.URI;

/**
 * Delegator
 *
 * @author Zihlu WANG
 */
public final class Delegator implements PropertyParameter {

    private static final String PROPERTY_NAME = "DELEGATED-FROM";

    private URI calendarUserAddress;

    private Delegator() {
    }

    private Delegator setCalendarUserAddress(String calendarUserAddress) {
        this.calendarUserAddress = URI.create(calendarUserAddress);
        return this;
    }

    private Delegator setCalendarUserAddress(URI calendarUserAddress) {
        this.calendarUserAddress = calendarUserAddress;
        return this;
    }

    private static Delegator initialiseInstance() {
        return new Delegator();
    }
    
    public static Delegator createInstance(String calendarUserAddress) {
        return initialiseInstance().setCalendarUserAddress(calendarUserAddress);
    }

    public static Delegator createInstance(URI calendarUserAddress) {
        return initialiseInstance().setCalendarUserAddress(calendarUserAddress);
    }

    @Override
    public String resolve() {
        return PROPERTY_NAME + "=\"" + calendarUserAddress + "\"";
    }
}
