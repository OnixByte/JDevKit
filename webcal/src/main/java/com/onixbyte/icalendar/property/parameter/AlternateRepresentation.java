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

import com.onixbyte.icalendar.property.CalendarResolvable;

import java.net.URI;

/**
 * Alternate Text Representation specifies a URI that points to an alternate representation for a
 * textual property value. A property specifying this parameter MUST also include a value that
 * reflects the default representation of the text value. The URI parameter value MUST be specified
 * in a quoted-string.
 * <p>
 * <b>Note</b>: While there is no restriction imposed on the URI schemes allowed for this
 * parameter, Content Identifier (CID) [RFC 2392], HTTP [RFC 2616], and HTTPS [RFC 2818] are the
 * URI schemes most commonly used by current implementations.
 *
 * @author Zihlu Wang
 */
public final class AlternateRepresentation implements PropertyParameter {

    private static final String PROPERTY_NAME = "ALTREP";

    private URI value;

    private AlternateRepresentation(URI uri) {
        this.value = uri;
    }

    @Override
    public String resolve() {
        return PROPERTY_NAME + "=\"" + value.toString() + "\"";
    }

    public static class Builder {
        private URI uri;

        private Builder() {
        }

        public Builder uri(String uri) {
            this.uri = URI.create(uri);
            return this;
        }

        public Builder uri(URI uri) {
            this.uri = uri;
            return this;
        }

        public AlternateRepresentation build() {
            return new AlternateRepresentation(uri);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
