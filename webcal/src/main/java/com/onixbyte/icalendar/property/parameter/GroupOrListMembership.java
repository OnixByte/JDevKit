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

import com.onixbyte.icalendar.datatype.CalendarUserAddress;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * GroupOrListMembership
 *
 * @author Zihlu WANG
 */
public final class GroupOrListMembership implements PropertyParameter {

    private static final String PARAMETER_NAME = "MEMBER";

    private final List<CalendarUserAddress> value;

    private GroupOrListMembership(List<CalendarUserAddress> value) {
        this.value = value;
    }

    public static class Builder {
        private final List<CalendarUserAddress> value;

        private Builder() {
            this.value = new ArrayList<>();
        }

        public Builder addMembership(CalendarUserAddress membership) {
            value.add(membership);
            return this;
        }

        public Builder addMembership(String membership) {
            value.add(new CalendarUserAddress(membership));
            return this;
        }

        public Builder addMembership(URI membership) {
            value.add(new CalendarUserAddress(membership));
            return this;
        }

        public Builder addMemberships(List<CalendarUserAddress> memberships) {
            value.addAll(memberships);
            return this;
        }

        public Builder addMemberships(Supplier<List<CalendarUserAddress>> memberships) {
            value.addAll(memberships.get());
            return this;
        }

        public GroupOrListMembership build() {
            return new GroupOrListMembership(value);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String resolve() {
        return PARAMETER_NAME + "=" + String.join(",", value.stream()
                .map((_value) -> "\"" + _value + "\"")
                .toList());
    }
}
