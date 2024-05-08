/*
 * Copyright (C) 2023 CodeCraftersCN.
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

/**
 * The abstract sealed class {@code WebCalendarNode} represents a node in a web calendar, such as an <a href="">event</a>, a to-do
 * item, or an alarm. It provides common properties and methods for all calendar components and events.
 * <p>
 * Subclasses of {@code WebCalendarNode} should implement the {@link #resolve()} method to generate the corresponding iCalendar content for the specific calendar component or event.
 *
 * @author Zihlu Wang
 * @version 1.1.0
 * @since 1.0.0
 */
public abstract class CalendarComponent {

    public abstract String resolve();

}

