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

package com.onixbyte.devkit.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class TestBase64Util {

    @Test
    public void testEncode() {
        Assertions.assertEquals("SGVsbG8gV29ybGQ=", Base64Util.encode("Hello World"));
        Assertions.assertEquals("MTI3LjAuMC4x", Base64Util.encode("127.0.0.1"));
        Assertions.assertEquals("cm9vdA==", Base64Util.encode("root"));
    }

    @Test
    public void testDecode() {
        Assertions.assertEquals("Hello World", Base64Util.decode("SGVsbG8gV29ybGQ="));
        Assertions.assertEquals("127.0.0.1", Base64Util.decode("MTI3LjAuMC4x"));
        Assertions.assertEquals("root", Base64Util.decode("cm9vdA=="));
    }

    @Test
    public void testEncodeUriComponent() {
        Assertions.assertEquals("aHR0cHM6Ly9nb29nbGUuY29t", Base64Util.encodeUrlComponents("https://google.com"));
        Assertions.assertEquals("aHR0cDovLzEyNy4wLjAuMTo4MDgwL2FwaS91c2VyLzEyMzQ1", Base64Util.encodeUrlComponents("http://127.0.0.1:8080/api/user/12345"));
    }

    @Test
    public void testDecodeUriComponent() {
        Assertions.assertEquals("https://google.com", Base64Util.decodeUrlComponents("aHR0cHM6Ly9nb29nbGUuY29t"));
        Assertions.assertEquals("http://127.0.0.1:8080/api/user/12345", Base64Util.decodeUrlComponents("aHR0cDovLzEyNy4wLjAuMTo4MDgwL2FwaS91c2VyLzEyMzQ1"));
    }

}
