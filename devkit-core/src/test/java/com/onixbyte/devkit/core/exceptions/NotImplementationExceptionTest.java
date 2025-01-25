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

package com.onixbyte.devkit.core.exceptions;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotImplementationExceptionTest {

    private final static Logger log = LoggerFactory.getLogger(NotImplementationExceptionTest.class);

    @Test
    public void testExceptionWithEmptyConstructor() {
        try {
            throw new NotImplementedException();
        } catch (NotImplementedException e) {
            log.error("NotImplementedException: ", e);
        }
    }

    @Test
    public void testExceptionWithStringConstructor() {
        try {
            throw new NotImplementedException("This function is not implemented yet, please contact developer for further information.");
        } catch (NotImplementedException e) {
            log.error("NotImplementedException: ", e);
        }
    }

}
