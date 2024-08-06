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

package com.onixbyte.security.exception;

/**
 * {@code KeyLoadingException} is an exception indicating an error occurred while loading a key.
 *
 * @author zihluwang
 * @version 1.6.0
 * @since 1.6.0
 */
public class KeyLoadingException extends RuntimeException {

    /**
     * Creates a new instance of {@code KeyLoadingException} without a specific message or cause.
     */
    public KeyLoadingException() {
    }

    /**
     * Creates a new instance of {@code KeyLoadingException} with the specified detail message.
     *
     * @param message the detail message
     */
    public KeyLoadingException(String message) {
        super(message);
    }

    /**
     * Creates a new instance of {@code KeyLoadingException} with the specified detail message
     * and cause.
     *
     * @param message the detail message
     * @param cause   the cause of this exception
     */
    public KeyLoadingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new instance of {@code KeyLoadingException} with the specified cause.
     *
     * @param cause the cause of this exception
     */
    public KeyLoadingException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified detail message, cause, suppression enabled
     * or disabled, and writable stack trace enabled or disabled.
     *
     * @param message the detail message
     * @param cause the cause of this exception
     * @param enableSuppression whether suppression is enabled or disabled
     * @param writableStackTrace whether the stack trace should be writable
     */
    public KeyLoadingException(String message,
                               Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
