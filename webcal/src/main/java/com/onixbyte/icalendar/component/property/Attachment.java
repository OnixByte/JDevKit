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

import com.onixbyte.icalendar.property.parameter.FormatType;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

/**
 * Attachment
 *
 * @author Zihlu WANG
 */
public record Attachment(FormatType formatType,
                         URI uri,
                         String content) implements ComponentProperty {

    private static final String PROPERTY_NAME = "ATTACH";

    @Override
    public String resolve() {
        if (Objects.isNull(uri) && (Objects.isNull(content) || content.isBlank())) {
            return null;
        }

        final var attachmentBuilder = new StringBuilder(PROPERTY_NAME);

        Optional.ofNullable(formatType)
                .ifPresent((fmtType) -> attachmentBuilder.append(";").append(fmtType.resolve()));

        Optional.ofNullable(uri).ifPresentOrElse(
                (_uri) -> attachmentBuilder.append(":").append(_uri),
                () -> attachmentBuilder.append(";ENCODING=BASE64;VALUE=BINARY:").append(content));
        attachmentBuilder.append("\n");

        return attachmentBuilder.toString();
    }
}
