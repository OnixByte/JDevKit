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

package cn.org.codecrafters.simplejwt.constants;

import ch.qos.logback.core.subst.Token;
import lombok.Getter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * The {@code TokenAlgorithm} enum class defines the algorithms that can be
 * used for signing and verifying JSON Web Tokens (JWT). JWT allows various
 * cryptographic algorithms to be used for secure token generation and
 * validation. This enum provides a list of supported algorithms to ensure
 * consistent usage and avoid potential security issues.
 *
 * <p><b>Supported Algorithms:</b>
 * This enum includes the following supported algorithms:
 * <ul>
 *     <li>{@link TokenAlgorithm#HS256}: HMAC SHA-256</li>
 *     <li>{@link TokenAlgorithm#HS384}: HMAC SHA-384</li>
 *     <li>{@link TokenAlgorithm#HS512}: HMAC SHA-512</li>
 *     <li>{@link TokenAlgorithm#RS256}: RSA PKCS#1 v1.5 with SHA-256</li>
 *     <li>{@link TokenAlgorithm#RS384}: RSA PKCS#1 v1.5 with SHA-384</li>
 *     <li>{@link TokenAlgorithm#RS512}: RSA PKCS#1 v1.5 with SHA-512</li>
 *     <li>{@link TokenAlgorithm#ES256}: ECDSA with SHA-256</li>
 *     <li>{@link TokenAlgorithm#ES384}: ECDSA with SHA-384</li>
 *     <li>{@link TokenAlgorithm#ES512}: ECDSA with SHA-512</li>
 * </ul>
 *
 * @since 1.0.0
 * @version 1.0.0
 */
@Getter
public enum TokenAlgorithm {
    HS256,
    HS384,
    HS512,
    RS256,
    RS384,
    RS512,
    ES256,
    ES384,
    ES512,
    ;

}
