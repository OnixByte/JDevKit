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

package cn.org.codecrafters.webcal.test;

import cn.org.codecrafters.webcal.WebCalendar;
import cn.org.codecrafters.webcal.impl.WebCalendarEvent;
import cn.org.codecrafters.webcal.config.Classification;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * TestWebCalendar
 *
 * @author Zihlu Wang
 */
@Slf4j
public class TestWebCalendar {

    @Test
    void testWebCalendar() {
        var calendar = new WebCalendar();
        calendar.setCompanyName("Code Crafters")
                .setDomainName("codecrafters.org.cn")
                .setName("Code Crafters SPECIAL EVENT")
                .setProductName("Code Crafters SPECIAL EVENT");

        calendar.addEvent(new WebCalendarEvent()
                .setClassification(Classification.PUBLIC)
                .setStart(LocalDateTime.of(2023, 8, 6, 0, 0, 0))
                .setEnd(LocalDateTime.of(2023, 8, 6, 8, 0, 0))
                .setLocation("Hong Kong University, Pokfulam, Central West, Hong Kong S.A.R")
                .setUid(UUID.randomUUID().toString())
                .setTimezone("Asia/Hong_Kong"));

        System.out.println(calendar.resolve());
    }

}
