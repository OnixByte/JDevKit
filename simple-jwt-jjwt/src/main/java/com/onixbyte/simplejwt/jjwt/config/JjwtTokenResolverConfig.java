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

package com.onixbyte.simplejwt.jjwt.config;

import com.onixbyte.simplejwt.TokenResolver;
import com.onixbyte.simplejwt.config.TokenResolverConfig;
import com.onixbyte.simplejwt.constants.TokenAlgorithm;
import com.onixbyte.simplejwt.exceptions.UnsupportedAlgorithmException;
import com.onixbyte.simplejwt.jjwt.JjwtTokenResolver;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SecureDigestAlgorithm;

import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code JjwtTokenResolverConfig} class provides the configuration for
 * the {@link JjwtTokenResolver}.
 * <p>
 * This configuration is used to establish the mapping between the standard
 * {@link TokenAlgorithm} defined in the
 * {@code cn.org.codecrafters:simple-jwt-facade} and the specific algorithms
 * used by the {@code io.jsonwebtoken:jjwt} library, which is the underlying
 * library used by {@link JjwtTokenResolver} to handle JSON Web Tokens
 * (JWTs).
 * <p>
 * <b>Algorithm Mapping:</b>
 * The {@code JjwtTokenResolverConfig} allows specifying the relationships
 * between the standard {@link TokenAlgorithm} instances supported by
 * {@link JjwtTokenResolver} and the corresponding algorithms used by the
 * {@code io.jsonwebtoken:jjwt} library. The mapping is achieved using a Map,
 * where the keys are the standard {@link TokenAlgorithm} instances, and the
 * values represent the algorithm functions used by
 * {@code io.jsonwebtoken:jjwt} library for each corresponding key.
 * <p>
 * <b>Note:</b>
 * The provided algorithm mapping should be consistent with the actual
 * algorithms supported and used by the {@code io.jsonwebtoken:jjwt} library.
 * It is crucial to ensure that the mapping is accurate to enable proper token
 * validation and processing within the {@link JjwtTokenResolver}.
 *
 * @author Zihlu Wang
 * @version 1.1.1
 * @since 1.0.0
 */
public final class JjwtTokenResolverConfig implements TokenResolverConfig<SecureDigestAlgorithm<SecretKey, SecretKey>> {

    public static JjwtTokenResolverConfig getInstance() {
        if (instance == null) {
            instance = new JjwtTokenResolverConfig();
        }

        return instance;
    }

    /**
     * Gets the algorithm function corresponding to the specified
     * {@link TokenAlgorithm}.
     * <p>
     * This method returns the algorithm function associated with the given
     * {@link TokenAlgorithm}. The provided {@link TokenAlgorithm} represents
     * the specific algorithm for which the corresponding algorithm function is
     * required. The returned algorithm function represents the function
     * implementation that can be used by the {@link TokenResolver} to handle
     * the specific algorithm.
     *
     * @param algorithm the {@link TokenAlgorithm} for which the algorithm
     *                  function is required
     * @return the algorithm function associated with the given {@link
     * TokenAlgorithm}
     */
    @Override
    public SecureDigestAlgorithm<SecretKey, SecretKey> getAlgorithm(TokenAlgorithm algorithm) {
        if (!SUPPORTED_ALGORITHMS.containsKey(algorithm)) {
            throw new UnsupportedAlgorithmException("""
                    The request algorithm is not supported by our system yet. Please change to supported ones.""");
        }
        return SUPPORTED_ALGORITHMS.get(algorithm);
    }

    /**
     * Private constructor will protect this class from being instantiated.
     */
    private JjwtTokenResolverConfig() {
    }

    /**
     * A {@code Map} to map a {@link TokenAlgorithm} to {@link SecureDigestAlgorithm}.
     */
    private static final Map<TokenAlgorithm, SecureDigestAlgorithm<SecretKey, SecretKey>> SUPPORTED_ALGORITHMS = new HashMap<>() {{
        put(TokenAlgorithm.HS256, Jwts.SIG.HS256);
        put(TokenAlgorithm.HS384, Jwts.SIG.HS384);
        put(TokenAlgorithm.HS512, Jwts.SIG.HS512);
    }};

    /**
     * The instance of this config class.
     */
    private static JjwtTokenResolverConfig instance;

}
