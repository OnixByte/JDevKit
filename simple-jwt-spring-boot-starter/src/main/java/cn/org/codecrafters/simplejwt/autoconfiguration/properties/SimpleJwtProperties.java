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

package cn.org.codecrafters.simplejwt.autoconfiguration.properties;

import cn.org.codecrafters.simplejwt.constants.TokenAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * {@code SimpleJwtProperties} is a configuration properties class used to
 * store the properties related to Simple JWT library configuration. These
 * properties can be configured in the application's properties file (e.g.,
 * application.properties) with the prefix "code-crafters.simple-jwt".
 * 
 *
 * <p>
 * SimpleJwtProperties provides configuration options for the JWT algorithm,
 * issuer, and secret. The properties are used by the {@link
 * cn.org.codecrafters.simplejwt.autoconfiguration.SimpleJwtAutoConfiguration}
 * class to set up the necessary configurations for JWT generation and
 * validation.
 * 
 *
 * <p>
 * Developers can customize the JWT algorithm, issuer, and secret by setting
 * the corresponding properties in the application's properties file. The
 * SimpleJwtAutoConfiguration class reads these properties and uses them to
 * create the TokenResolver bean with the desired configuration.
 * 
 *
 * @since 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "code-crafters.simple-jwt")
public class SimpleJwtProperties {

    /**
     * The algorithm used for JWT generation and validation.
     */
    private TokenAlgorithm algorithm;

    /**
     * The issuer value to be included in the generated JWT.
     */
    private String issuer;

    /**
     * The secret key used for JWT generation and validation.
     */
    private String secret;

    /**
     * Returns the JWT algorithm configured in the properties.
     *
     * @return the JWT algorithm
     */
    public final TokenAlgorithm algorithm() {
        return algorithm;
    }

    /**
     * Returns the issuer value configured in the properties.
     *
     * @return the issuer value
     */
    public final String issuer() {
        return issuer;
    }

    /**
     * Returns the secret key configured in the properties.
     *
     * @return the secret key
     */
    public final String secret() {
        return secret;
    }

}

