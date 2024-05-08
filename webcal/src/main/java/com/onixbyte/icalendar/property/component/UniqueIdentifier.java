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

package com.onixbyte.icalendar.property.component;

import com.onixbyte.icalendar.property.Prop;

/**
 * UniqueIdentifier
 *
 * @author Zihlu WANG
 */
public final class UniqueIdentifier implements Prop {

    private String value;

    private UniqueIdentifier() {
    }

    private void setValue(String value) {
        this.value = value;
    }

    public static class Builder {
        private final UniqueIdentifier uniqueIdentifier;

        private Builder() {
            this.uniqueIdentifier = new UniqueIdentifier();
        }

        public Builder uniqueIdentifier(String uniqueIdentifier) {
            this.uniqueIdentifier.value = uniqueIdentifier;
            return this;
        }

        public Builder uniqueIdentifier(String uniqueIdentifier, String domainName) {
            this.uniqueIdentifier.value = uniqueIdentifier + "@" + domainName;
            return this;
        }

        public UniqueIdentifier build() {
            return uniqueIdentifier;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String resolve() {
        return "uid:" + this.value + '\n';
    }
}
