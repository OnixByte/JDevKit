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

import com.onixbyte.icalendar.property.parameter.AlternateRepresentation;
import com.onixbyte.icalendar.property.parameter.Language;

import java.util.ArrayList;
import java.util.List;

public final class Resources implements TextProperty, ComponentProperty {

    private static final String PROPERTY_NAME = "RESOURCES";

    private final AlternateRepresentation altRep;

    private final Language language;

    private final List<String> value;

    private Resources(AlternateRepresentation altRep, Language language, List<String> value) {
        this.altRep = altRep;
        this.language = language;
        this.value = value;
    }

    public static class Builder {
        private List<String> value;

        private AlternateRepresentation altRep;

        private Language language;

        private Builder() {
            this.value = new ArrayList<>();
        }

        public Builder altRep(AlternateRepresentation altRep) {
            this.altRep = altRep;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder addResource(String resource) {
            value.add(resource);
            return this;
        }

        public Builder addResources(List<String> resources) {
            value.addAll(resources);
            return this;
        }

        public Resources build() {
            return new Resources(altRep, language, value);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String resolve() {
        return composeResolution(PROPERTY_NAME, altRep, language, () -> String.join(",", value));
    }
}
