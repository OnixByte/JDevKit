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

public record Priority(int value) implements ComponentProperty {

    private static final String PROPERTY_NAME = "PRIORITY";

    public Priority {
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("Priority %d is exceeded the range of 0-9.".formatted(value));
        }
    }

    @Override
    public String resolve() {
        return PROPERTY_NAME + ":" + value + "\n";
    }
}
