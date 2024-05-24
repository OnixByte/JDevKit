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

package com.onixbyte.icalendar.component;

import com.onixbyte.icalendar.calendar.property.Scale;
import com.onixbyte.icalendar.calendar.property.Method;
import com.onixbyte.icalendar.calendar.property.ProductIdentifier;
import com.onixbyte.icalendar.calendar.property.Version;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * {@code WebCalendar} class represents a web calendar in iCalendar format.
 * <p>
 * It allows users to create and customise calendar components and events and
 * generate an <b>iCalendar</b> string containing all the calendar information.
 * <p>
 * Usage Example:
 * <pre>
 * WebCalendar calendar = new WebCalendar()
 *         .setName("My Web Calendar")
 *         .setCompanyName("CodeCrafters Inc.")
 *         .setProductName("WebCal")
 *         .setDomainName("codecrafters.org.cn")
 *         .setMethod("PUBLISH")
 *         .addEvent(event1)
 *         .addEvent(event2);
 * String iCalendarString = calendar.resolve();
 * </pre>
 * <p>
 * The {@code WebCalendar} class is designed to generate an iCalendar string
 * conforming to the iCalendar specification, which can be used to share
 * calendar data with other calendar applications or services.
 *
 * @author Zihlu Wang
 * @version 1.1.0
 * @since 1.0.0
 */
public final class Calendar {

    private static final String COMPONENT_NAME = "VCALENDAR";

    /**
     * This property are OPTIONAL, but MUST NOT occur more than once.
     */
    private Scale scale;

    /**
     * This property are OPTIONAL, but MUST NOT occur more than once.
     */
    private Method method;

    /**
     * This property are REQUIRED, but MUST NOT occur more than once.
     */
    private ProductIdentifier productIdentifier;

    /**
     * This property are REQUIRED, but MUST NOT occur more than once.
     */
    private final Version version = Version.VERSION_2_0;

    private String calendarName;

    private final List<CalendarComponent> components = new ArrayList<>();

    /**
     * Generate and resolve the iCalendar string for the web calendar.
     *
     * @return the resolved iCalendar string
     */
    public String resolve() {
        var calendarBuilder = new StringBuilder();
        calendarBuilder.append("BEGIN:").append(COMPONENT_NAME).append('\n');

        calendarBuilder.append(version.resolve()).append('\n');
        calendarBuilder.append(productIdentifier.resolve()).append('\n');
        calendarBuilder.append("X-WR-CALNAME:").append(calendarName).append('\n');

        Optional.ofNullable(scale)
                .ifPresent((_scale) -> calendarBuilder.append(_scale.resolve()).append('\n'));
        Optional.ofNullable(method)
                .ifPresent((_method) -> calendarBuilder.append(_method.resolve()).append('\n'));

        if (!components.isEmpty()) {
            components.forEach(((component) -> calendarBuilder.append(component.resolve()).append('\n')));
        }

        calendarBuilder.append("END:").append(COMPONENT_NAME).append('\n');
        return calendarBuilder.toString();
    }

}

