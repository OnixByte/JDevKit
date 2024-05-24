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

public record GeoPosition(double latitude,
                          double longitude) implements ComponentProperty {

    public GeoPosition {
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException(
                    "Latitude (%f) should greater than -90 and less than 90.".formatted(latitude));
        }

        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException(
                    "Longitude (%f) should greater than -180 and less than 180."
                            .formatted(longitude));
        }
    }

    private static final String PROPERTY_NAME = "GEO";

    @Override
    public String resolve() {
        return PROPERTY_NAME + ":" + latitude + ";" + longitude + "\n";
    }
}
