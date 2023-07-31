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

package cn.org.codecrafters.simplejwt.constants;

import java.util.List;

/**
 * <p>
 * This class contains predefined keys that are commonly used in JSON Web
 * Tokens (JWT).
 * </p>
 *
 * <p>
 * JWTs consist of a set of claims represented as key-value pairs. These claims
 * store various pieces of information, such as the subject, issuer, expiration
 * time, and more. To ensure consistency and avoid spelling mistakes, this
 * class provides constants for the standard keys used in JWT claims.
 * </p>
 *
 * <p>
 * Developers using this JWT library can use these predefined keys to set and
 * retrieve claims in a safer and more readable way. By using constants instead
 * of plain strings, it helps prevent typos and makes the code more
 * maintainable.
 * </p>
 *
 * @since 1.0.0
 */
public final class PredefinedKeys {

    // Constants for standard JWT claims
    public static final String ISSUER = "iss";

    public static final String SUBJECT = "sub";

    public static final String AUDIENCE = "aud";

    public static final String EXPIRATION_TIME = "exp";

    public static final String NOT_BEFORE = "nbf";

    public static final String ISSUED_AT = "iat";

    public static final String JWT_ID = "jti";

    private PredefinedKeys() {
        // Private constructor to prevent instantiation
    }

    public static final List<String> KEYS = List.of(ISSUER, SUBJECT, AUDIENCE, EXPIRATION_TIME, NOT_BEFORE, ISSUED_AT, JWT_ID);
}
