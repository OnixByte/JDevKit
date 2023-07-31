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

package cn.org.codecrafters.simplejwt;

import cn.org.codecrafters.devkit.guid.GuidCreator;
import cn.org.codecrafters.simplejwt.authzero.AuthzeroTokenResolver;
import cn.org.codecrafters.simplejwt.properties.SimpleJwtProperties;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * SimpleJwtAutoConfiguration
 *
 * @author Zihlu Wang
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(value = {SimpleJwtProperties.class})
public class SimpleJwtAutoConfiguration {

    private GuidCreator<?> jtiCreator;

    @Autowired
    public void setJtiCreator(GuidCreator<?> jtiCreator) {
        this.jtiCreator = jtiCreator;
    }

    private final SimpleJwtProperties simpleJwtProperties;

    @Autowired
    public SimpleJwtAutoConfiguration(SimpleJwtProperties simpleJwtProperties) {
        this.simpleJwtProperties = simpleJwtProperties;
    }

    @Bean
    @ConditionalOnMissingBean(value = GuidCreator.class, name = "jtiCreator")
    public GuidCreator<?> jtiCreator() {
        return (GuidCreator<UUID>) UUID::randomUUID;
    }

    @Bean
    @ConditionalOnClass({DecodedJWT.class, AuthzeroTokenResolver.class})
    @ConditionalOnMissingBean({TokenResolver.class})
    @ConditionalOnBean(value = {GuidCreator.class}, name = "jtiCreator")
    public TokenResolver<DecodedJWT> tokenResolver() {
        return new AuthzeroTokenResolver(this.jtiCreator,
                simpleJwtProperties.algorithm(),
                simpleJwtProperties.issuer(),
                simpleJwtProperties.secret());
    }

}
