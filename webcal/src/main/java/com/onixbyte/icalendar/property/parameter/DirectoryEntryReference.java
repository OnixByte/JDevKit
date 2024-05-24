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

import java.net.URI;

/**
 * DirectoryEntryReference
 *
 * @author Zihlu WANG
 */
public final class DirectoryEntryReference implements PropertyParameter {

    private static final String PROPERTY_NAME = "DIR";

    private final URI value;

    private DirectoryEntryReference(URI value) {
        this.value = value;
    }

    public static class Builder {
        private URI value;

        private Builder() {
        }

        public Builder directoryEntryReference(URI value) {
            this.value = value;
            return this;
        }

        public Builder directoryEntryReference(String value) {
            this.value = URI.create(value);
            return this;
        }

        public DirectoryEntryReference build() {
            return new DirectoryEntryReference(value);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String resolve() {
        return PROPERTY_NAME + "=\"" + value + "\"";
    }
}
