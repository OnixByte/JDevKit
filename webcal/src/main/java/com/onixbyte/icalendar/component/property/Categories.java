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

import java.util.ArrayList;
import java.util.List;

public final class Categories implements ComponentProperty {

    private static final String PROPERTY_NAME = "CATEGORIES";

    private final List<String> value;

    private Categories(List<String> value) {
        this.value = value;
    }

    public static class Builder {
        private final List<String> categories;

        private Builder() {
            categories = new ArrayList<>();
        }

        public Builder addCategory(String category) {
            if (!categories.contains(category)) {
                categories.add(category);
            }
            return this;
        }

        public Builder addCategories(List<String> categories) {
            categories.forEach(this::addCategory);
            return this;
        }

        public Categories build() {
            return new Categories(categories);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String resolve() {
        return PROPERTY_NAME + ":" + String.join(",", value) + "\n";
    }
}
