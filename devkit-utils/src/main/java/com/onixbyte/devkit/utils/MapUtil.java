/*
 * Copyright (C) 2024 OnixByte.
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

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * {@code MapUtil} is a utility class that provides methods for converting objects to maps and maps
 * to objects.
 * <p>
 * Note: Since version 1.4.2, this util class removed reflection API and transferred to a safer API.
 * Please see documentation for more information.
 *
 * @author zihluwang
 * @version 1.7.0
 * @since 1.0.0
 */
@Slf4j
public final class MapUtil {

    /**
     * Converts an object to a map by mapping the field names to their corresponding values.
     *
     * @param <T>     the type of the object
     * @param entity  the object to be converted to a map
     * @param adapter adapts the entity for mapping to a map
     * @return a map representing the fields and their values of the object
     */
    public static <T> Map<String, Object> objectToMap(T entity, ObjectMapAdapter<T> adapter) {
        return adapter.toMap(entity);
    }

    /**
     * Converts a map to an object of the specified type by setting the field values using the
     * map entries.
     *
     * @param objectMap the map representing the fields and their values
     * @param adapter   the adapter to execute the setter for the entity
     * @param <T>       the type of the object to be created
     * @return an object of the specified type with the field values set from the map
     */
    public static <T> T mapToObject(Map<String, Object> objectMap, ObjectMapAdapter<T> adapter) {
        return adapter.toObject(objectMap);
    }

    /**
     * Private constructor prevent class being instantiated.
     */
    private MapUtil() {
    }
}
