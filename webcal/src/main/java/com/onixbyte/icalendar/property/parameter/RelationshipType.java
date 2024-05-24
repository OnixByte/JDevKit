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
 * RelationshipType
 *
 * @author Zihlu WANG
 */
public enum RelationshipType implements PropertyParameter {

    PARENT("PARENT"),
    CHILD("CHILD"),
    SIBLING("SIBLING"),
    SNOOZE("SNOOZE"),
    CONCEPT("CONCEPT"),
    DEPENDS_ON("DEPENDS-ON"),
    FINISH_TO_FINISH("FINISHTOFINISH"),
    FINISH_TO_START("FINISHTOSTART"),
    FIRST("FIRST"),
    NEXT("NEXT"),
    REF_ID("REFID"),
    START_TO_FINISH("STARTTOFINISH"),
    START_TO_START("STARTTOSTART")
    ;

    private static final String PROPERTY_NAME = "RELTYPE";

    private final String tag;

    RelationshipType(String tag) {
        this.tag = tag;
    }

    @Override
    public String resolve() {
        return PROPERTY_NAME + "=" + tag;
    }
}
