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

/**
 * This package contains annotation classes that are used to prevent annotated
 * properties from being automatically injected into the JSON Web Token (JWT)
 * payload during token generation. These annotations can be applied to
 * properties of a data class to exclude them from being included as part
 * of the JWT payload.
 *
 * @since 1.0.0
 */
package com.onixbyte.simplejwt.annotations;