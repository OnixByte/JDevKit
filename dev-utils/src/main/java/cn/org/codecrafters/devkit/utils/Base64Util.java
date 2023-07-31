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

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Utility class for Base64 encoding and decoding of strings.
 * <p>
 * The {@code Base64Util} class provides static methods to encode and decode
 * strings using Base64 encoding. It utilizes the {@link Base64} class from the
 * Java standard library for performing the encoding and decoding operations.
 * This utility class offers convenient methods to encode and decode strings
 * with different character sets.
 * </p>
 * <p>
 * This class is designed as a final class with a private constructor to
 * prevent instantiation. All methods in this class are static, allowing easy
 * access to the Base64 encoding and decoding functionality.
 * </p>
 * <p>
 * Example usage:
 * <pre>
 * String original = "Hello, World!";
 *
 * // Encode the string using UTF-8 charset
 * String encoded = Base64Util.encode(original);
 * System.out.println("Encoded string: " + encoded);
 *
 * // Decode the encoded string using UTF-8 charset
 * String decoded = Base64Util.decode(encoded);
 * System.out.println("Decoded string: " + decoded);
 * </pre>
 * </p>
 * <p>
 * <b>Note:</b> This utility class uses the default charset (UTF-8) if no
 * specific charset is provided. It is recommended to specify the charset
 * explicitly to ensure consistent encoding and decoding.
 * </p>
 *
 * @author Zihlu Wang
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Base64Util {

    /**
     * Private constructor to prevent instantiation of the class.
     */
    private Base64Util() {
    }

    /**
     * Encodes the given string using the specified charset.
     *
     * @param value   the string to be encoded
     * @param charset the charset to be used for encoding
     * @return the Base64 encoded string
     */
    public static String encode(String value, Charset charset) {
        var encoder = Base64.getEncoder();
        var encoded = encoder.encode(value.getBytes(charset));

        return new String(encoded);
    }

    /**
     * Encodes the given string using the default UTF-8 charset.
     *
     * @param value the string to be encoded
     * @return the Base64 encoded string
     */
    public static String encode(String value) {
        return encode(value, StandardCharsets.UTF_8);
    }

    /**
     * Decodes the given Base64 encoded string using the specified charset.
     *
     * @param value   the Base64 encoded string to be decoded
     * @param charset the charset to be used for decoding
     * @return the decoded string
     */
    public static String decode(String value, Charset charset) {
        var decoder = Base64.getDecoder();
        var decoded = decoder.decode(value.getBytes(charset));

        return new String(decoded);
    }

    /**
     * Decodes the given Base64 encoded string using the default UTF-8 charset.
     *
     * @param value the Base64 encoded string to be decoded
     * @return the decoded string
     */
    public static String decode(String value) {
        return decode(value, StandardCharsets.UTF_8);
    }

}