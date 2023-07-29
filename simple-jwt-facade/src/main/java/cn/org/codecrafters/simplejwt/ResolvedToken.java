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

package cn.org.codecrafters.simplejwt;

/**
 * ResolvedToken - Generic Record for Holding Resolved Tokens.
 * <p>
 * This class represents a generic record that holds a resolved token of type {@code T}. It is used as a simple
 * container to store the resolved token value for further processing.
 * <p>
 * <b>Usage:</b>
 * To create a new instance of {@code ResolvedToken}, use the static factory method {@code init}.
 *
 * @param <T> the type of the resolved token
 * @author Zihlu Wang
 * @since 1.0.0
 */
public record ResolvedToken<T>(T resolvedToken) {

    /**
     * Creates a new {@code ResolvedToken} instance with the provided {@code resolvedToken} value.
     *
     * @param resolvedToken the resolved token value to be stored in the {@code ResolvedToken}
     */
    public ResolvedToken(T resolvedToken) {
        this.resolvedToken = resolvedToken;
    }

    /**
     * Factory method to create a new {@code ResolvedToken} instance with the provided {@code resolvedToken} value.
     *
     * @param <T> the type of the resolved token
     * @param resolvedToken the resolved token value to be stored in the {@code ResolvedToken}
     * @return a new {@code ResolvedToken} instance containing the provided {@code resolvedToken}
     */
    public static <T> ResolvedToken<T> init(T resolvedToken) {
        return new ResolvedToken<>(resolvedToken);
    }

}
