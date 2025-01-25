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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAesUtil {

    private final static Logger log = LoggerFactory.getLogger(TestAesUtil.class);

    @Test
    public void testGenerateRandomSecret() {
        log.info("Secret is {}", AesUtil.generateRandomSecret());
    }

    @Test
    public void testEncrypt() {
        var secret = "43f72073956d4c81";

        Assertions.assertEquals("IbbYZu8GtMruBURfMBVy/w==", AesUtil.encrypt("Hello World", secret));
        Assertions.assertEquals("1eVA7oQpTIhI7jc+6cdkmg==", AesUtil.encrypt("OnixByte", secret));
        Assertions.assertEquals("fk6oNRJK8a+Pz7zVwtlD0UQocq5c3GkRuem0Z6jdAN8=", AesUtil.encrypt("Welcome to use JDevKit!", secret));
        Assertions.assertEquals("dqzGjawNcQdBpXJWk/08UQ==", AesUtil.encrypt("127.0.0.1", secret));
        Assertions.assertEquals("uwQQI60yAGL91q9jCDgoeA==", AesUtil.encrypt("root", secret));
    }

    @Test
    public void testDecrypt() {
        var secret = "43f72073956d4c81";

        Assertions.assertEquals("Hello World", AesUtil.decrypt("IbbYZu8GtMruBURfMBVy/w==", secret));
        Assertions.assertEquals("OnixByte", AesUtil.decrypt("1eVA7oQpTIhI7jc+6cdkmg==", secret));
        Assertions.assertEquals("Welcome to use JDevKit!", AesUtil.decrypt("fk6oNRJK8a+Pz7zVwtlD0UQocq5c3GkRuem0Z6jdAN8=", secret));
        Assertions.assertEquals("127.0.0.1", AesUtil.decrypt("dqzGjawNcQdBpXJWk/08UQ==", secret));
        Assertions.assertEquals("root", AesUtil.decrypt("uwQQI60yAGL91q9jCDgoeA==", secret));
    }

}
