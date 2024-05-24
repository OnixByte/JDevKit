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

package com.onixbyte.icalendar.test;

import com.onixbyte.icalendar.datatype.CalendarUserAddress;
import com.onixbyte.icalendar.property.parameter.Delegatee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class DelegateeTest {

    @Test
    void testAddStringDelegatee() {
        var delegatee = Delegatee.builder()
                .addDelegatee("mailto:user01@example.onixbyte.com")
                .build()
                .resolve();
        log.info("#testAddStringDelegatee {}", delegatee);
    }

    @Test
    void testAddUriDelegatee() {
        var delegatee = Delegatee.builder()
                .addDelegatee(URI.create("mailto:user01@example.onixbyte.com"))
                .build()
                .resolve();
        log.info("#testAddUriDelegatee {}", delegatee);
    }

    @Test
    void testAddCauDelegateeWithStringConstructor() {
        var delegatee = Delegatee.builder()
                .addDelegatee(new CalendarUserAddress("mailto:user01@example.onixbyte.com"))
                .build()
                .resolve();
        log.info("#testAddCauDelegateeWithStringConstructor {}", delegatee);
    }

    @Test
    void testAddCauDelegateeWithUriConstructor() {
        var delegatee = Delegatee.builder()
                .addDelegatee(new CalendarUserAddress(URI.create("mailto:user01@example.onixbyte.com")))
                .build()
                .resolve();
        log.info("#testAddCauDelegateeWithUriConstructor {}", delegatee);
    }

    @Test
    void testAddDelegateeSeparately() {
        var delegatee = Delegatee.builder()
                .addDelegatee(new CalendarUserAddress(URI.create("mailto:user01@example.onixbyte.com")))
                .addDelegatee(URI.create("mailto:user02@example.onixbyte.com"))
                .addDelegatee("mailto:user03@example.onixbyte.com")
                .build()
                .resolve();
        log.info("#testAddDelegateeSeparately {}", delegatee);
    }

    @Test
    void testAddDelegateeSeparatelyWithIncorrectUri() {
        try {
            var delegatee = Delegatee.builder()
                    .addDelegatee(new CalendarUserAddress(URI.create("mailto:user01@example.onixbyte.com")))
                    .addDelegatee(URI.create("mailto:user02@example.onixbyte.com"))
                    .addDelegatee("https://example.onixbyte.com")
                    .build()
                    .resolve();
            log.info("#testAddDelegateeSeparatelyWithIncorrectUri {}", delegatee);
        } catch (IllegalArgumentException iae) {
            log.error("#testAddDelegateeSeparatelyWithIncorrectUri {}", iae.getMessage());
        }
    }

    @Test
    void testAddDelegateesWithCau() {
        try {
            var delegatee = Delegatee.builder()
                    .addDelegatees(List.of(
                            new CalendarUserAddress("mailto:user01@example.onixbyte.com"),
                            new CalendarUserAddress("mailto:user02@example.onixbyte.com")
                    ))
                    .build()
                    .resolve();
            log.info("#testAddDelegateesWithCau {}", delegatee);
        } catch (IllegalArgumentException iae) {
            log.error("#testAddDelegateesWithCau {}", iae.getMessage());
        }
    }

    @Test
    void testAddDelegateesWithSupplier() {
        try {
            var delegatee = Delegatee.builder()
                    .addDelegatees(() -> Stream.of("mailto:user01@example.onixbyte.com", "mailto:user02@example.onixbyte.com")
                            .map(CalendarUserAddress::new)
                            .toList())
                    .build()
                    .resolve();
            log.info("#testAddDelegateesWithSupplier {}", delegatee);
        } catch (IllegalArgumentException iae) {
            log.error("#testAddDelegateesWithSupplier {}", iae.getMessage());
        }
    }

}
