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

package cn.org.codecrafters.simplejwt.properties;

import cn.org.codecrafters.devkit.guid.GuidCreator;
import cn.org.codecrafters.simplejwt.constants.TokenAlgorithm;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * SimpleJwtProperties
 *
 * @author Zihlu Wang
 */
@Data
@ConfigurationProperties(prefix = "code-crafters.simple-jwt")
public class SimpleJwtProperties {

    private TokenAlgorithm algorithm;

    private String issuer;

    private String secret;

    public final TokenAlgorithm algorithm() {
        return algorithm;
    }

    public final String issuer() {
        return issuer;
    }

    public final String secret() {
        return secret;
    }

}
