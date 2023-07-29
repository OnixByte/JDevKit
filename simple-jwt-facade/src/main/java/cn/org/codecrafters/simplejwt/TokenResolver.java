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

import java.time.Duration;
import java.util.Map;

/**
 * TokenResolver - Interface for Creating, Extracting, and Renewing Tokens.
 * <p>
 * The {@code TokenResolver} interface defines methods for creating,
 * extracting, and renewing tokens, particularly JSON Web Tokens (JWTs). It
 * provides a set of methods to generate tokens with various payload
 * configurations, extract payloads from tokens, and renew expired tokens.
 * <p>
 * <b>Token Creation:</b>
 * The interface provides overloaded methods for creating tokens with different
 * payload configurations, including expiration time, audience, subject, and
 * custom payload data. Clients can choose the appropriate method based on
 * their specific token requirements.
 * <p>
 * <b>Token Extraction:</b>
 * The interface includes methods to extract payload information from a given
 * token. Clients can use these methods to obtain the payload data encoded in
 * the token.
 * <p>
 * <b>Token Renewal:</b>
 * The interface also offers methods for token renewal. Clients can renew an
 * expired token by providing a new expiration time, audience, subject, and
 * optional custom payload data.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface TokenResolver {

    /**
     * Creates a new token with the specified expiration time and audience.
     *
     * @param expireAfter the duration after which the token will expire
     * @param audience    the audience for which the token is intended
     * @return the generated token as a {@code String}
     */
    String createToken(Duration expireAfter, String audience);

    /**
     * Creates a new token with the specified expiration time, audience, and
     * custom payload data.
     *
     * @param expireAfter the duration after which the token will expire
     * @param audience    the audience for which the token is intended
     * @param payloads    the custom payload data to be included in the token
     * @return the generated token as a {@code String}
     */
    String createToken(Duration expireAfter, String audience, Map<String, Object> payloads);

    /**
     * Creates a new token with the specified expiration time, audience, and
     * strongly-typed payload data.
     *
     * @param <T>         the type of the payload data, must implement
     *                    {@link TokenPayload}
     * @param expireAfter the duration after which the token will expire
     * @param audience    the audience for which the token is intended
     * @param payloads    the strongly-typed payload data to be included in the
     *                    token
     * @return the generated token as a {@code String}
     */
    <T extends TokenPayload> String createToken(Duration expireAfter, String audience, T payloads);

    /**
     * Creates a new token with the specified expiration time, subject, and audience.
     *
     * @param expireAfter the duration after which the token will expire
     * @param subject     the subject of the token
     * @param audience    the audience for which the token is intended
     * @return the generated token as a {@code String}
     */
    String createToken(Duration expireAfter, String subject, String audience);

    /**
     * Creates a new token with the specified expiration time, subject,
     * audience, and custom payload data.
     *
     * @param expireAfter the duration after which the token will expire
     * @param subject     the subject of the token
     * @param audience    the audience for which the token is intended
     * @param payloads    the custom payload data to be included in the token
     * @return the generated token as a {@code String}
     */
    String createToken(Duration expireAfter, String subject, String audience, Map<String, Object> payloads);

    /**
     * Creates a new token with the specified expiration time, subject,
     * audience, and strongly-typed payload data.
     *
     * @param <T>         the type of the payload data, must implement
     *                    {@link TokenPayload}
     * @param expireAfter the duration after which the token will expire
     * @param subject     the subject of the token
     * @param audience    the audience for which the token is intended
     * @param payloads    the strongly-typed payload data to be included in the
     *                    token
     * @return the generated token as a {@code String}
     */
    <T extends TokenPayload> String createToken(Duration expireAfter, String subject, String audience, T payloads);

    /**
     * Extracts the payload information from the given token.
     *
     * @param token the token from which to extract the payload
     * @return a map containing the extracted payload data
     */
    Map<String, Object> extract(String token);

    /**
     * Extracts the payload information from the given token and maps it to the
     * specified target type.
     *
     * @param <T>        the target type to which the payload data will be
     *                   mapped
     * @param token      the token from which to extract the payload
     * @param targetType the target class representing the payload data type
     * @return an instance of the specified target type with the extracted
     * payload data
     */
    <T extends TokenPayload> T extract(String token, Class<T> targetType);

    /**
     * Renews the given expired token.
     *
     * @param oldToken the expired token to be renewed
     * @return the renewed token as a {@code String}
     */
    String renew(String oldToken);

    /**
     * Renews the given expired token with the specified custom payload data.
     *
     * @param oldToken the expired token to be renewed
     * @param payloads the custom payload data to be included in the renewed
     *                 token
     * @return the renewed token as a {@code String}
     */
    String renew(String oldToken, Map<String, Object> payloads);

    /**
     * Renews the given expired token with the specified strongly-typed
     * payload data.
     *
     * @param <T>      the type of the payload data, must implement
     *                 {@link TokenPayload}
     * @param oldToken the expired token to be renewed
     * @param payloads the strongly-typed payload data to be included in the
     *                 renewed token
     * @return the renewed token as a {@code String}
     */
    <T extends TokenPayload> String renew(String oldToken, T payloads);

    /**
     * Resolves the given token into a {@link ResolvedToken} object.
     *
     * @param <T>   the type of the resolved token
     * @param token the token to be resolved
     * @return a {@link ResolvedToken} object containing the resolved token
     */
    <T> ResolvedToken<T> resolve(String token);

}
