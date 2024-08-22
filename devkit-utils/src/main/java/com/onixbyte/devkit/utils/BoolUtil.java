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

package com.onixbyte.devkit.utils;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BooleanSupplier;

/**
 * A util for boolean calculations.
 *
 * @author shaoxinke
 * @version 1.6.2
 */
public final class BoolUtil {

    /**
     * Logical and calculation.
     *
     * @param values the values to be calculated
     * @return {@code true} if all value in values is {@code true}, otherwise {@code false}
     */
    public static boolean and(Boolean... values) {
        return Arrays.stream(values)
                .filter(Objects::nonNull)
                .allMatch(Boolean::booleanValue);
    }

    /**
     * Logical and calculation.
     *
     * @param valueSuppliers the suppliers of value to be calculated
     * @return {@code true} if all value in values is {@code true}, otherwise {@code false}
     */
    public static boolean and(BooleanSupplier... valueSuppliers) {
        return Arrays.stream(valueSuppliers)
                .filter(Objects::nonNull)
                .allMatch(BooleanSupplier::getAsBoolean);
    }

    /**
     * Logical or calculation.
     *
     * @param values the values to be calculated
     * @return {@code true} if any value in values is {@code true}, otherwise {@code false}
     */
    public static boolean or(Boolean... values) {
        return Arrays.stream(values)
                .filter(Objects::nonNull)
                .anyMatch(Boolean::booleanValue);
    }

    /**
     * Logical or calculation.
     *
     * @param valueSuppliers the suppliers of value to be calculated
     * @return {@code true} if any value in values is {@code true}, otherwise {@code false}
     */
    public static boolean or(BooleanSupplier... valueSuppliers) {
        return Arrays.stream(valueSuppliers)
                .filter(Objects::nonNull)
                .anyMatch(BooleanSupplier::getAsBoolean);
    }

}
