package com.onixbyte.devkit.utils;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BooleanSupplier;

public final class BoolUtil {

    public static boolean and(Boolean... values) {
        return Arrays.stream(values)
                .filter(Objects::nonNull)
                .allMatch(Boolean::booleanValue);
    }

    public static boolean and(BooleanSupplier... valueSuppliers) {
        return Arrays.stream(valueSuppliers)
                .filter(Objects::nonNull)
                .allMatch(BooleanSupplier::getAsBoolean);
    }

    public static boolean or(Boolean... valueSuppliers) {
        return Arrays.stream(valueSuppliers)
                .filter(Objects::nonNull)
                .anyMatch(Boolean::booleanValue);
    }

    public static boolean or(BooleanSupplier... valueSuppliers) {
        return Arrays.stream(valueSuppliers)
                .filter(Objects::nonNull)
                .anyMatch(BooleanSupplier::getAsBoolean);
    }

}
