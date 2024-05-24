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

import java.util.List;

public enum Status implements ComponentProperty {

    TENTATIVE("TENTATIVE"),
    CONFIRMED("CONFIRMED"),
    CANCELLED("CANCELLED"),
    NEEDS_ACTION("NEEDS-ACTION"),
    COMPLETED("COMPLETED"),
    IN_PROGRESS("IN-PROGRESS"),
    DRAFT("DRAFT"),
    FINAL("FINAL"),
    ;

    private static final String PROPERTY_NAME = "STATUS";

    private final String tag;

    Status(String tag) {
        this.tag = tag;
    }

    @Override
    public String resolve() {
        return PROPERTY_NAME + ":" + tag + "\n";
    }

    public static List<Status> eventStatus() {
        return List.of(TENTATIVE, CONFIRMED, CANCELLED);
    }

    public static List<Status> todoStatus() {
        return List.of(NEEDS_ACTION, COMPLETED, IN_PROGRESS, CANCELLED);
    }

    public static List<Status> journalStatus() {
        return List.of(DRAFT, FINAL, CANCELLED);
    }
}
