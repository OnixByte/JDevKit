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

package com.onixbyte.devkit.utils;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Objects;
import java.util.UUID;

/**
 * {@link AesUtil} can help you encrypt and decrypt data with specified secret
 * by AES algorithm.
 *
 * @author hubin@baomidou
 * @version 1.1.0
 * @since 1.1.0
 */
@Slf4j
public final class AesUtil {

    /**
     * Encrypts the data using the AES algorithm with the given secret.
     *
     * @param data   the data to be encrypted
     * @param secret the secret to encrypt the data
     * @return the encryption result or {@code null} if encryption failed
     */
    public static byte[] encrypt(byte[] data, byte[] secret) {
        try {
            var secretKeySpec = new SecretKeySpec(new SecretKeySpec(secret, AES).getEncoded(), AES);
            var cipher = Cipher.getInstance(AES_CBC_CIPHER);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(secret));
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedOperationException |
                 InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException |
                 BadPaddingException exception) {
            log.error(exception.getMessage());
            for (var stackTraceElement : exception.getStackTrace()) {
                log.error("{}", stackTraceElement.toString());
            }
        }
        return null;
    }

    /**
     * Decrypts the data using the AES algorithm with the given secret.
     *
     * @param data the data to be decrypted
     * @param secret  the secret to encrypt the data
     * @return the decryption result or {@code null} if decryption failed
     */
    public static byte[] decrypt(byte[] data, byte[] secret) {
        try {
            var secretKeySpec = new SecretKeySpec(new SecretKeySpec(secret, AES).getEncoded(), AES);
            var cipher = Cipher.getInstance(AES_CBC_CIPHER);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(secret));
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedOperationException |
                 InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException |
                 BadPaddingException exception) {
            log.error(exception.getMessage());
            for (var stackTraceElement : exception.getStackTrace()) {
                log.error("{}", stackTraceElement.toString());
            }
        }
        return null;
    }

    /**
     * Encrypts the data using the AES algorithm with the given secret.
     *
     * @param data the data to be encrypted
     * @param secret  the secret to encrypt the data
     * @return the encryption result or {@code null} if encryption failed
     */
    public static String encrypt(String data, String secret) {
        return Base64.getEncoder().encodeToString(encrypt(data.getBytes(StandardCharsets.UTF_8), secret.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * Decrypts the data using the AES algorithm with the given secret.
     *
     * @param data the data to be decrypted
     * @param secret  the secret to encrypt the data
     * @return the decryption result or {@code null} if decryption failed
     */
    public static String decrypt(String data, String secret) {
        return new String(Objects.requireNonNull(
                decrypt(Base64.getDecoder().decode(data.getBytes()),
                        secret.getBytes(StandardCharsets.UTF_8)))
        );
    }

    /**
     * Generates 16 characters-long random secret.
     *
     * @return the generated secure secret
     */
    public static String generateRandomSecret() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
    }

    /**
     * Private constructor will protect this class from being instantiated.
     */
    private AesUtil() {
    }

    /**
     * The algorithm AES.
     */
    private static final String AES = "AES";

    /**
     * The algorithm AES/CBC/PKCS5Padding.
     */
    private static final String AES_CBC_CIPHER = "AES/CBC/PKCS5Padding";

}
