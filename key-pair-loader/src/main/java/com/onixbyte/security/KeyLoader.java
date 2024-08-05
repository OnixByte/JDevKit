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

package com.onixbyte.security;

import com.onixbyte.security.exception.KeyLoadingException;
import lombok.extern.slf4j.Slf4j;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * KeyLoader can load key pairs from PEM formated content.
 *
 * @author zihluwang
 * @version 1.6.0
 * @since 1.6.0
 */
@Slf4j
public class KeyLoader {

    /**
     * Private constructor prevents from being initialised.
     */
    private KeyLoader() {
    }

    /**
     * Load ECDSA private key from pem-formatted key text.
     *
     * @param pemKeyText pem-formatted key text
     * @return loaded private key
     * @throws KeyLoadingException if the generated key is not a {@link ECPrivateKey} instance,
     *                             or EC Key Factory is not loaded, or key spec is invalid
     */
    public static ECPrivateKey loadEcdsaPrivateKey(String pemKeyText) {
        try {
            var decodedKeyString = Base64.getDecoder().decode(pemKeyText);
            var keySpec = new PKCS8EncodedKeySpec(decodedKeyString);
            var keyFactory = KeyFactory.getInstance("EC");
            var _key = keyFactory.generatePrivate(keySpec);
            if (_key instanceof ECPrivateKey privateKey) {
                return privateKey;
            } else {
                throw new KeyLoadingException("Unable to load private key from pem-formatted key text.");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new KeyLoadingException("Cannot get EC Key Factory.", e);
        } catch (InvalidKeySpecException e) {
            throw new KeyLoadingException("Key spec is invalid.", e);
        }
    }

    /**
     * Load ECDSA public key from pem-formatted key text.
     *
     * @param pemKeyText pem-formatted key text
     * @return loaded private key
     * @throws KeyLoadingException if the generated key is not a {@link ECPrivateKey} instance,
     *                             or EC Key Factory is not loaded, or key spec is invalid
     */
    public static ECPublicKey loadEcdsaPublicKey(String pemKeyText) {
        try {
            var keyBytes = Base64.getDecoder().decode(pemKeyText);
            var spec = new X509EncodedKeySpec(keyBytes);
            var keyFactory = KeyFactory.getInstance("EC");
            var key = keyFactory.generatePublic(spec);
            if (key instanceof ECPublicKey publicKey) {
                return publicKey;
            } else {
                throw new KeyLoadingException("Unable to load private key from pem-formatted key text.");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new KeyLoadingException("Cannot get EC Key Factory.", e);
        } catch (InvalidKeySpecException e) {
            throw new KeyLoadingException("Key spec is invalid.", e);
        }
    }

}
