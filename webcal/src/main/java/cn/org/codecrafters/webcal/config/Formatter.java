/*
 * Copyright (C) 2023 CodeCraftersCN.
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

package cn.org.codecrafters.webcal.config;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * DatetimeFormatters
 *
 * @author Zihlu Wang
 * @since 21 Sept, 2023
 */
public final class Formatter {

    public static DateTimeFormatter getUtcDatetimeFormatter() {
        if (Objects.isNull(utcDateTimeFormatter)) {
            utcDateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'").withZone(ZoneOffset.UTC);
        }

        return utcDateTimeFormatter;
    }

    // public static DateTimeFormatter getLocalDatetimeFormatter() {
    //     if (Objects.isNull(localDatetimeFormatter)) {
    //         localDatetimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss");
    //     }
    //
    //     return localDatetimeFormatter;
    // }

    private static DateTimeFormatter utcDateTimeFormatter;

    // private static DateTimeFormatter localDatetimeFormatter;

}
