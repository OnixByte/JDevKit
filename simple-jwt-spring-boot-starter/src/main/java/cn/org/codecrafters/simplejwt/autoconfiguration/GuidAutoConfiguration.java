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

package cn.org.codecrafters.simplejwt.autoconfiguration;

import cn.org.codecrafters.guid.GuidCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

/**
 * GuidAutoConfiguration
 *
 * @author Zihlu Wang
 */
@Slf4j
@AutoConfiguration
@ConditionalOnMissingBean(value = GuidCreator.class, name = "jtiCreator")
public class GuidAutoConfiguration {

    @Bean
    public GuidCreator<?> jtiCreator() {
        return UUID::randomUUID;
    }

}
