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
import com.onixbyte.simplejwt.TokenResolver;
import com.onixbyte.simplejwt.autoconfiguration.properties.SimpleJwtProperties;
import com.onixbyte.simplejwt.jjwt.JjwtTokenResolver;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * {@code JjwtTokenResolverAutoConfiguration} is responsible for automatically
 * configuring the Simple JWT library with {@code io.jsonwebtoken:jjwt-api}
 * when used in a Spring Boot application. It provides default settings and
 * configurations to ensure that the library works smoothly without requiring
 * manual configuration.
 * <p>
 * This autoconfiguration class sets up the necessary beans and components
 * required for JWT generation and validation. It automatically creates and
 * configures the {@link JjwtTokenResolver} bean based on the available options
 * and properties.
 * <p>
 * Developers using the Simple JWT library with Spring Boot do not need to
 * explicitly configure the library, as the autoconfiguration takes care of
 * setting up the necessary components and configurations automatically.
 * However, developers still have the flexibility to customize the behavior of
 * the library by providing their own configurations and properties.
 *
 * @author Zihlu Wang
 * @version 1.1.0
 * @since 1.0.0
 */
@Slf4j
@AutoConfiguration
@EnableConfigurationProperties(value = {SimpleJwtProperties.class})
@ConditionalOnClass({Jws.class, Claims.class, JjwtTokenResolver.class})
@ConditionalOnMissingBean({TokenResolver.class})
@ConditionalOnBean(value = {GuidCreator.class}, name = "jtiCreator")
@AutoConfigureAfter(value = GuidAutoConfiguration.class)
public class JjwtTokenResolverAutoConfiguration {

    /**
     * Constructs a new {@code SimpleJwtAutoConfiguration} instance with the provided
     * {@link SimpleJwtProperties}.
     *
     * @param jtiCreator          a creator to create JSON Web Token ids
     * @param simpleJwtProperties the SimpleJwtProperties instance
     */
    @Autowired
    public JjwtTokenResolverAutoConfiguration(SimpleJwtProperties simpleJwtProperties, @Qualifier("jtiCreator") GuidCreator<?> jtiCreator) {
        this.jtiCreator = jtiCreator;
        this.simpleJwtProperties = simpleJwtProperties;
    }

    /**
     * Creates a new {@link TokenResolver} bean using {@link JjwtTokenResolver} if no existing
     * {@link TokenResolver} bean is found. The {@link JjwtTokenResolver} is configured with the
     * provided {@link GuidCreator}, {@code algorithm}, {@code issuer}, and {@code secret}
     * properties from {@link SimpleJwtProperties}.
     *
     * @return the {@link TokenResolver} instance
     */
    @Bean
    public TokenResolver<Jws<Claims>> tokenResolver() {
        return new JjwtTokenResolver(
                jtiCreator,
                simpleJwtProperties.algorithm(),
                simpleJwtProperties.issuer(),
                simpleJwtProperties.secret()
        );
    }

    /**
     * The GuidCreator instance to be used for generating JWT IDs (JTI).
     */
    private final GuidCreator<?> jtiCreator;

    /**
     * The {@code SimpleJwtProperties} instance containing the configuration properties
     * for Simple JWT.
     */
    private final SimpleJwtProperties simpleJwtProperties;

}
