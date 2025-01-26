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

import com.onixbyte.security.impl.EcKeyLoader;
import org.junit.jupiter.api.Test;

public class KeyPairLoaderTest {

    @Test
    public void test() {
        var keyLoader = new EcKeyLoader();
        var privateKey = keyLoader.loadPrivateKey("""
                -----BEGIN PRIVATE KEY-----
                MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgs79JlARgXEf6EDV7
                +PHQCTHEMtqIoHOy1GZ1+ynQJ6yhRANCAARkA7GRY2i4gg8qx0XViAXUP9cPw9pn
                Jg1wfrQ41FaMyqVBejNYxvaLtamErF/ySimnjafMJ+VZCh34lBj6Ez8R
                -----END PRIVATE KEY-----
                """);
        var publicKey = keyLoader.loadPublicKey("""
                -----BEGIN PUBLIC KEY-----
                MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEZAOxkWNouIIPKsdF1YgF1D/XD8Pa
                ZyYNcH60ONRWjMqlQXozWMb2i7WphKxf8kopp42nzCflWQod+JQY+hM/EQ==
                -----END PUBLIC KEY-----
                """);
    }

}
