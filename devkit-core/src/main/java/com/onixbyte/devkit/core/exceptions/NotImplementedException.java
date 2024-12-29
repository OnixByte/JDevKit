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

package com.onixbyte.devkit.core.exceptions;

/**
 * The {@code NotImplementedException} class is a custom runtime exception that represents a situation where a
 * particular method or functionality is not implemented or is currently unavailable in the codebase.
 * <p>
 * This exception is typically thrown when developers need to indicate that a specific part of the code is incomplete
 * or requires further implementation. It serves as a placeholder to highlight unfinished sections of the application
 * during development and testing phases.
 * <p>
 * Usage Example:
 * <pre>
 * public void someMethod() {
 *     // Some code...
 *     throw new NotImplementedException("""
 *     This feature will be implemented in a future release.""");
 * }
 * </pre>
 * <b>Contact</b>
 * <ul>
 *     <li>
 *         <a href="https://github.com/CodeCraftersCN/jdevkit/issues/new"
 *         >GitHub Issues</a>
 *     </li>
 *     <li>
 *         <a href="https://discord.gg/">Discord Community</a>
 *     </li>
 * </ul>
 *
 * @author Zihlu Wang
 * @version 1.1.0
 * @see RuntimeException
 * @since 1.0.0
 */
public class NotImplementedException extends RuntimeException {

    /**
     * Creates a new {@code NotImplementedException} with no specific error message.
     */
    public NotImplementedException() {
    }

    /**
     * Creates a new {@code NotImplementedException} with the provided error message.
     *
     * @param message the error message associated with this exception
     */
    public NotImplementedException(String message) {
        super(message);
    }

    /**
     * Creates a new {@code NotImplementedException} with the specified error message and a cause for this exception.
     *
     * @param message the error message associated with this exception
     * @param cause   the cause of this exception
     */
    public NotImplementedException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new {@code NotImplementedException} with the specified cause.
     *
     * @param cause the cause of this exception
     */
    public NotImplementedException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new {@code NotImplementedException} with the specified error message, cause, suppression flag, and
     * stack trace writable flag.
     *
     * @param message            the error message associated with this
     *                           exception
     * @param cause              the cause of this exception
     * @param enableSuppression  whether suppression is enabled or disabled
     * @param writableStackTrace whether the stack trace should be writable
     */
    public NotImplementedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
