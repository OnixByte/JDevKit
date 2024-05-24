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
 * UserType
 *
 * @author Zihlu WANG
 */
public enum UserType implements PropertyParameter {

    /**
     * An individual.
     */
    INDIVIDUAL,

    /**
     * A group of individuals.
     */
    GROUP,

    /**
     * A physical resource.
     */
    RESOURCE,

    /**
     * A room resource.
     */
    ROOM,

    /**
     * Otherwise not known.
     */
    UNKNOWN,
    ;

    private static final String PARAMETER_NAME = "CUTYPE";

    @Override
    public String resolve() {
        return PARAMETER_NAME + "=" + this.name();
    }
}
