/*
 * Copyright (C) 2024-2025 OnixByte.
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

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * The {@code KeyLoader} class provides utility methods for loading keys pairs from PEM-formatted
 * key text. This class supports loading both private and public keys.
 * <p>
 * The utility methods in this class are useful for scenarios where ECDSA keys need to be loaded
 * from PEM-formatted strings for cryptographic operations.
 *
 * @author zihluwang
 * @version 2.0.0
 * @since 1.6.0
 */
public interface KeyLoader {

    /**
     * Load private key from pem-formatted key text.
     *
     * @param pemKeyText pem-formatted key text
     * @return loaded private key
     */
    PrivateKey loadPrivateKey(String pemKeyText);

    /**
     * Load public key from pem-formatted key text.
     *
     * @param pemKeyText pem-formatted key text
     * @return loaded private key
     */
    PublicKey loadPublicKey(String pemKeyText);

}
