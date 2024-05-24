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

import java.util.List;

/**
 * ParticipationStatus
 *
 * @author Zihlu WANG
 */
public enum ParticipationStatus implements PropertyParameter {

    ACCEPTED("ACCEPTED"),
    DECLINED("DECLINED"),
    TENTATIVE("TENTATIVE"),
    DELEGATED("DELEGATED"),
    COMPLETED("COMPLETED"),
    IN_PROGRESS("IN-PROGRESS"),
    NEEDS_ACTION("NEEDS-ACTION")
    ;

    public static List<ParticipationStatus> eventStatues() {
        return List.of(NEEDS_ACTION, ACCEPTED, DECLINED, TENTATIVE, DELEGATED);
    }

    public static List<ParticipationStatus> todoStatues() {
        return List.of(NEEDS_ACTION, ACCEPTED, DECLINED, TENTATIVE, DELEGATED, COMPLETED, IN_PROGRESS);
    }

    public static List<ParticipationStatus> journalStatues() {
        return List.of(NEEDS_ACTION, ACCEPTED, DECLINED);
    }

    private static final String PROPERTY_NAME = "PARTSTAT";

    private final String tag;

    ParticipationStatus(String tag) {
        this.tag = tag;
    }

    @Override
    public String resolve() {
        return PROPERTY_NAME + "=" + tag;
    }
}
