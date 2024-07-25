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

package com.onixbyte.keypairloader;

import com.onixbyte.keypairloader.exception.KeyLoadingException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Optional;

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

    public ECPrivateKey loadEcdsaPrivateKey(String pemKeyText) {
        return Optional.ofNullable(pemKeyText)
                .map(Base64.getDecoder()::decode)
                .map(PKCS8EncodedKeySpec::new)
                .map((keySpec) -> {
                    try {
                        var kf = KeyFactory.getInstance("EC");
                        return kf.generatePrivate(keySpec);
                    } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
                        throw new KeyLoadingException("Unable to load key from text.", e);
                    }
                }).map((publicKey) -> {
                    if (publicKey instanceof ECPrivateKey privateKey) {
                        return privateKey;
                    }
                    return null;
                })
                .orElse(null);
    }

    // public ECPublicKey loadEcdsaPublicKey(String pemKeyText) {
    //
    // }

}
