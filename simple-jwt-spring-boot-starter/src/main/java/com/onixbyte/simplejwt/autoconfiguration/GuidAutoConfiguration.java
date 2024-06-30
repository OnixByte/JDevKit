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

package com.onixbyte.simplejwt.autoconfiguration;

import com.onixbyte.guid.GuidCreator;
import com.onixbyte.simplejwt.autoconfiguration.conditions.GuidCreatorCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import java.util.UUID;

/**
 * Autoconfiguration for injecting a {@link GuidCreator} for generating jwt id.
 *
 * @author Zihlu Wang
 * @version 1.1.0
 * @since 1.0.0
 */
@Slf4j
@AutoConfiguration
public class GuidAutoConfiguration {

    /**
     * Create a default {@code jtiCreator} with UUID.
     *
     * @return UUID creator
     */
    @Bean(name = "jtiCreator")
    @Conditional(GuidCreatorCondition.class)
    public GuidCreator<?> jtiCreator() {
        return UUID::randomUUID;
    }

}
