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

package com.onixbyte.simplejwt.jjwt;

import com.onixbyte.devkit.utils.MapUtil;
import com.onixbyte.guid.GuidCreator;
import com.onixbyte.simplejwt.SecretCreator;
import com.onixbyte.simplejwt.TokenPayload;
import com.onixbyte.simplejwt.TokenResolver;
import com.onixbyte.simplejwt.annotations.ExcludeFromPayload;
import com.onixbyte.simplejwt.annotations.TokenEnum;
import com.onixbyte.simplejwt.constants.PredefinedKeys;
import com.onixbyte.simplejwt.constants.TokenAlgorithm;
import com.onixbyte.simplejwt.exceptions.WeakSecretException;
import com.onixbyte.simplejwt.jjwt.config.JjwtTokenResolverConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * The {@link JjwtTokenResolver} class is an implementation of the {@link
 * TokenResolver} interface. It uses the {@code
 * io.jsonwebtoken:jjwt} library to handle JSON Web Token (JWT) resolution.
 * This resolver provides functionality to create, extract, verify, and renew
 * JWT tokens using various algorithms and custom payload data.
 * <p>
 * <b>Usage:</b>
 * To use the {@code JjwtTokenResolver}, first, create an instance of this
 * class:
 * <pre>{@code
 *   TokenResolver<Jws<Claims>> tokenResolver =
 *       new JjwtTokenResolver(TokenAlgorithm.HS256,
 *                                 "Token Subject",
 *                                 "Token Issuer",
 *                                 "Token Secret");
 *   }</pre>
 * <p>
 * Then, you can utilize the various methods provided by this resolver to
 * handle JWT tokens:
 * <pre>{@code
 *   // Creating a new JWT token
 *   String token =
 *       tokenResolver.createToken(Duration.ofHours(1),
 *                                 "your_subject",
 *                                 "your_audience",
 *                                 customPayloads);
 *
 *   // Extracting payload data from a JWT token
 *   DecodedJWT decodedJWT = tokenResolver.resolve(token);
 *   T payloadData = decodedJWT.extract(token, T.class);
 *
 *   // Renewing an existing JWT token
 *   String renewedToken =
 *       tokenResolver.renew(token, Duration.ofMinutes(30), customPayloads);
 *   }</pre>
 * <p>
 * <b>Note:</b>
 * It is essential to configure the appropriate algorithms, secret, and issuer
 * according to your specific use case when using this resolver.
 * Additionally, ensure that the {@code io.jsonwebtoken:jjwt} library is
 * correctly configured in your project's dependencies.
 *
 * @author Zihlu Wang
 * @version 1.1.0
 * @see Claims
 * @see Jws
 * @see Jwts
 * @see SecureDigestAlgorithm
 * @see Keys
 * @since 1.0.0
 */
@Slf4j
public class JjwtTokenResolver implements TokenResolver<Jws<Claims>> {

    /**
     * Create a resolver with specified algorithm, issuer, secret and guid strategy.
     *
     * @param jtiCreator jwt id creator
     * @param algorithm  specified algorithm
     * @param issuer     specified issuer
     * @param secret     specified secret
     */
    public JjwtTokenResolver(GuidCreator<?> jtiCreator, TokenAlgorithm algorithm, String issuer, String secret) {
        if (Objects.isNull(secret) || secret.isBlank()) {
            throw new IllegalArgumentException("A secret is required to build a JSON Web Token.");
        }

        if (secret.length() < 32) {
            log.error("""
                            The provided secret which owns {} characters is too weak. Please replace it with a stronger one.""",
                    secret.length());
            throw new WeakSecretException("""
                    The provided secret which owns %s characters is too weak. Please replace it with a stronger one."""
                    .formatted(secret.length()));
        }

        this.jtiCreator = jtiCreator;
        this.algorithm = config.getAlgorithm(algorithm);
        this.issuer = issuer;
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Create a resolver with specified algorithm, issuer, secret and default guid strategy.
     *
     * @param algorithm specified algorithm
     * @param issuer    specified issuer
     * @param secret    specified secret
     */
    public JjwtTokenResolver(TokenAlgorithm algorithm, String issuer, String secret) {
        if (secret == null || secret.isBlank()) {
            throw new IllegalArgumentException("A secret is required to build a JSON Web Token.");
        }

        if (secret.length() < 32) {
            log.error(
                    "The provided secret which owns {} characters is too weak. Please replace it with a stronger one.",
                    secret.length());
            throw new WeakSecretException(
                    "The provided secret which owns %s characters is too weak. Please replace it with a stronger one."
                            .formatted(secret.length()));
        }

        this.jtiCreator = UUID::randomUUID;
        this.algorithm = config.getAlgorithm(algorithm);
        this.issuer = issuer;
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Create a resolver with specified issuer, secret, default algorithm and guid strategy.
     *
     * @param issuer specified issuer
     * @param secret specified secret
     * @see #JjwtTokenResolver(TokenAlgorithm, String, String)
     */
    public JjwtTokenResolver(String issuer, String secret) {
        if (secret == null || secret.isBlank()) {
            throw new IllegalArgumentException("A secret is required to build a JSON Web Token.");
        }

        if (secret.length() < 32) {
            log.error(
                    "The provided secret which owns {} characters is too weak. Please replace it with a stronger one.",
                    secret.length());
            throw new WeakSecretException(
                    "The provided secret which owns %s characters is too weak. Please replace it with a stronger one."
                            .formatted(secret.length()));
        }

        this.jtiCreator = UUID::randomUUID;
        this.algorithm = config.getAlgorithm(TokenAlgorithm.HS256);
        this.issuer = issuer;
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Create a resolver with specified issuer, random secret string, default algorithm and guid strategy.
     *
     * @param issuer specified issuer
     * @see #JjwtTokenResolver(String, String)
     */
    public JjwtTokenResolver(String issuer) {
        this.jtiCreator = UUID::randomUUID;
        this.algorithm = config.getAlgorithm(TokenAlgorithm.HS256);
        this.issuer = issuer;
        this.key = Keys.hmacShaKeyFor(SecretCreator.createSecret(32, true, true, true).getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Creates a new token with the specified expiration time, subject, and
     * audience.
     *
     * @param expireAfter the duration after which the token will expire
     * @param audience    the audience for which the token is intended
     * @param subject     the subject of the token
     * @return the generated token as a {@code String}
     */
    @Override
    public String createToken(Duration expireAfter, String audience, String subject) {
        return buildToken(expireAfter, audience, subject, null);
    }

    /**
     * Creates a new token with the specified expiration time, subject,
     * audience, and custom payload data.
     *
     * @param expireAfter the duration after which the token will expire
     * @param audience    the audience for which the token is intended
     * @param subject     the subject of the token
     * @param payload     the custom payload data to be included in the token
     * @return the generated token as a {@code String}
     */
    @Override
    public String createToken(Duration expireAfter, String audience, String subject, Map<String, Object> payload) {
        return buildToken(expireAfter, audience, subject, payload);
    }

    /**
     * Creates a new token with the specified expiration time, subject,
     * audience, and strongly-typed payload data.
     *
     * @param expireAfter the duration after which the token will expire
     * @param audience    the audience for which the token is intended
     * @param subject     the subject of the token
     * @param payload     the strongly-typed payload data to be included in the
     *                    token
     * @return the generated token as a {@code String} or {@code null} if
     * creation fails
     * @see MapUtil#objectToMap(Object, Map)
     */
    @Override
    public <T extends TokenPayload> String createToken(Duration expireAfter, String audience, String subject, T payload) {
        var fields = payload.getClass().getDeclaredFields();
        var payloadMap = new HashMap<String, Object>();

        for (var field : fields) {
            if (field.isAnnotationPresent(ExcludeFromPayload.class))
                continue;

            try {
                var getter = payload.getClass().getDeclaredMethod("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
                // Build Claims
                /*
                 * Note (17 Oct, 2023): The jjwt can only add a map to be added.
                 */
                var fieldValue = getter.invoke(payload);

                // Handle enum fields.
                if (field.isAnnotationPresent(TokenEnum.class)) {
                    var annotation = field.getAnnotation(TokenEnum.class);
                    var enumGetter = field.getType().getDeclaredMethod("get" + annotation.propertyName().substring(0, 1).toUpperCase() + annotation.propertyName().substring(1));
                    fieldValue = enumGetter.invoke(fieldValue);
                }
                payloadMap.put(field.getName(), fieldValue);
            } catch (IllegalAccessException | NoSuchMethodException e) {
                log.error("Cannot access field {}!", field.getName());
            } catch (InvocationTargetException e) {
                log.error("Cannot invoke getter.", e);
            }
        }

        return buildToken(expireAfter, audience, subject, payloadMap);
    }

    /**
     * Resolves the given token into a {@link Jws<Claims>} object.
     *
     * @param token the token to be resolved
     * @return a ResolvedTokenType object
     */
    @Override
    public Jws<Claims> resolve(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);
    }

    /**
     * Extracts the payload information from the given token and maps it to the
     * specified target type.
     *
     * @param token      the token from which to extract the payload
     * @param targetType the target class representing the payload data type
     * @return an instance of the specified target type with the extracted
     * payload data, or {@code null} if extraction fails.
     * @see MapUtil#mapToObject(Map, Object, Map)
     */
    @Override
    public <T extends TokenPayload> T extract(String token, Class<T> targetType) {
        var resolvedToken = resolve(token);

        var claims = resolvedToken.getPayload();
        try {
            var bean = targetType.getConstructor().newInstance();

            for (var entry : claims.entrySet()) {
                // Jump all JWT pre-defined properties and the fields that are annotated to be excluded.
                if (PredefinedKeys.KEYS.contains(entry.getKey()) || targetType.getDeclaredField(entry.getKey()).isAnnotationPresent(ExcludeFromPayload.class))
                    continue;

                var field = targetType.getDeclaredField(entry.getKey());
                var fieldValue = entry.getValue();
                if (field.isAnnotationPresent(TokenEnum.class)) {
                    var annotation = field.getAnnotation(TokenEnum.class);
                    var enumStaticLoader = field.getType().getDeclaredMethod("loadBy" + annotation.propertyName().substring(0, 1).toUpperCase() + annotation.propertyName().substring(1), annotation.dataType().getMappedClass());
                    fieldValue = enumStaticLoader.invoke(null, entry.getValue());
                }

                var setter = targetType.getDeclaredMethod("set" + entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1), fieldValue.getClass());
                if (setter.canAccess(bean)) {
                    setter.invoke(bean, fieldValue);
                } else {
                    log.error("Setter for field {} can't be accessed.", entry.getKey());
                }
            }

            return bean;
        } catch (InvocationTargetException e) {
            log.error("Target is not invokable.", e);
        } catch (NoSuchMethodException e) {
            log.error("Cannot find method according to given data.", e);
        } catch (InstantiationException e) {
            log.error("The required type {} is abstract or an interface.", targetType.getCanonicalName());
        } catch (IllegalAccessException e) {
            log.error("An error occurs while accessing the fields of the object.", e);
        } catch (NoSuchFieldException e) {
            log.error("Cannot load field according to given field name.", e);
        }

        return null;
    }

    /**
     * Re-generate a new token with the payload in the old one.
     *
     * @param oldToken    the old token
     * @param expireAfter how long the new token can be valid for
     * @return re-generated token with the payload in the old one
     */
    @Override
    public String renew(String oldToken, Duration expireAfter) {
        var resolvedToken = resolve(oldToken);
        var tokenPayloads = resolvedToken.getPayload();

        var audience = tokenPayloads.getAudience().toArray(new String[]{})[0];
        var subject = tokenPayloads.getSubject();

        PredefinedKeys.KEYS.forEach(tokenPayloads::remove);

        return createToken(expireAfter, audience, subject, tokenPayloads);
    }

    /**
     * Renews the given expired token with the specified custom payload data.
     *
     * @param oldToken    the expired token to be renewed
     * @param expireAfter specify when does the new token invalid
     * @param payload     the custom payload data to be included in the renewed
     *                    token
     * @return the renewed token as a {@code String}
     */
    @Override
    public String renew(String oldToken, Duration expireAfter, Map<String, Object> payload) {
        var resolvedTokenClaims = resolve(oldToken).getPayload();
        var audience = resolvedTokenClaims.getAudience().toArray(new String[]{})[0];
        var subject = resolvedTokenClaims.getSubject();

        return createToken(expireAfter, audience, subject, payload);
    }

    /**
     * Renews the given expired token with the specified custom payload data.
     *
     * @param oldToken the expired token to be renewed
     * @param payload  the custom payload data to be included in the renewed
     *                 token
     * @return the renewed token as a {@code String}
     */
    @Override
    public String renew(String oldToken, Map<String, Object> payload) {
        return renew(oldToken, Duration.ofMinutes(30), payload);
    }

    /**
     * Renews the given expired token with the specified strongly-typed
     * payload data.
     *
     * @param oldToken    the expired token to be renewed
     * @param expireAfter specify when does the new token invalid
     * @param payload     the strongly-typed payload data to be included in the
     *                    renewed token
     * @return the renewed token as a {@code String}
     */
    @Override
    public <T extends TokenPayload> String renew(String oldToken, Duration expireAfter, T payload) {
        var resolvedTokenClaims = resolve(oldToken).getPayload();
        var audience = resolvedTokenClaims.getAudience().toArray(new String[]{})[0];
        var subject = resolvedTokenClaims.getSubject();

        return createToken(expireAfter, audience, subject, payload);
    }

    /**
     * Renews the given expired token with the specified strongly-typed
     * payload data.
     *
     * @param oldToken the expired token to be renewed
     * @param payload  the strongly-typed payload data to be included in the
     *                 renewed token
     * @return the renewed token as a {@code String}
     */
    @Override
    public <T extends TokenPayload> String renew(String oldToken, T payload) {
        return renew(oldToken, Duration.ofMinutes(30), payload);
    }

    /**
     * Build a new token with specified data.
     *
     * @param expireAfter the validity time of the token
     * @param audience    the audience of the token
     * @param subject     the subject of the token
     * @param claims      the data to be included in the token
     * @return the built token
     */
    private String buildToken(Duration expireAfter, String audience, String subject, Map<String, Object> claims) {
        var now = LocalDateTime.now();
        var builder = Jwts.builder()
                .header().add("typ", "JWT")
                .and()
                .issuedAt(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))
                .notBefore(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))
                .expiration(Date.from(now.plus(expireAfter).atZone(ZoneId.systemDefault()).toInstant()))
                .subject(subject)
                .issuer(this.issuer)
                .audience().add(audience)
                .and()
                .id(jtiCreator.nextId().toString());

        if (claims != null && !claims.isEmpty()) {
            builder.claims(claims);
        }

        return builder.signWith(key, algorithm)
                .compact();
    }

    /**
     * The ID creator for creating unique JWT IDs.
     */
    private final GuidCreator<?> jtiCreator;

    /**
     * The algorithm to sign this token.
     */
    private final SecureDigestAlgorithm<SecretKey, SecretKey> algorithm;

    /**
     * The issuer of this token.
     */
    private final String issuer;

    /**
     * The signature key of this token.
     */
    private final SecretKey key;

    /**
     * The config of this token resolver.
     */
    private final JjwtTokenResolverConfig config = JjwtTokenResolverConfig.getInstance();
}
