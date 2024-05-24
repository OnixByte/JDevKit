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

package com.onixbyte.icalendar.datatype;

import com.onixbyte.icalendar.component.property.DateTimeProperty;
import com.onixbyte.icalendar.property.Resolvable;

import java.time.LocalDateTime;

public final class PeriodExplicit implements Period {

    private final LocalDateTime startTime;

    private final LocalDateTime endTime;

    public PeriodExplicit(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Period start must not after than period end.");
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String resolve() {
        return startTime.format(DateTimeProperty.utcDateTimeFormatter()) + "/" +
                endTime.format(DateTimeProperty.utcDateTimeFormatter());
    }
}
