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

package cn.org.codecrafters.devkit.utils;

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
 * AES Util helps you encrypt and decrypt data with specified key and AES
 * algorithm.
 *
 * @author hubin@baomidou
 * @since 1.1.0
 * @version 1.1.0
 */
@Slf4j
public final class AesUtil {

    private AesUtil() {
    }

    private static final String AES = "AES";

    private static final String AES_CBC_CIPHER = "AES/CBC/PKCS5Padding";

    /**
     * Encrypt the given data with given key with AES algorithm.
     *
     * @param data the data to be encrypted
     * @param key  the key to encrypt the data
     * @return the encryption result or {@code null} if encryption failed
     */
    public static byte[] encrypt(byte[] data, byte[] key) {
        try {
            var secretKeySpec = new SecretKeySpec(new SecretKeySpec(key, AES).getEncoded(), AES);
            var cipher = Cipher.getInstance(AES_CBC_CIPHER);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(key));
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
     * Decrypt the given data with given key with AES algorithm.
     *
     * @param data the data to be decrypted
     * @param key  the key to encrypt the data
     * @return the decryption result or {@code null} if decryption failed
     */
    public static byte[] decrypt(byte[] data, byte[] key) {
        try {
            var secretKeySpec = new SecretKeySpec(new SecretKeySpec(key, AES).getEncoded(), AES);
            var cipher = Cipher.getInstance(AES_CBC_CIPHER);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(key));
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
     * Encrypt the given data with given key with AES algorithm.
     *
     * @param data the data to be encrypted
     * @param key  the key to encrypt the data
     * @return the encryption result or {@code null} if encryption failed
     */
    public static String encrypt(String data, String key) {
        return Base64.getEncoder().encodeToString(encrypt(data.getBytes(StandardCharsets.UTF_8), key.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * Decrypt the given data with given key with AES algorithm.
     *
     * @param data the data to be decrypted
     * @param key  the key to encrypt the data
     * @return the decryption result or {@code null} if decryption failed
     */
    public static String decrypt(String data, String key) {
        return new String(Objects.requireNonNull(
                decrypt(Base64.getDecoder().decode(data.getBytes()),
                        key.getBytes(StandardCharsets.UTF_8)))
        );
    }

    /**
     * Generates 16 characters-long random key.
     *
     * @return the generated secure secret
     */
    public static String generateRandomKey() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
    }

}
