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
 * @author Zihlu Wang
 * @version 1.4.2
 * @see com.onixbyte.devkit.utils.unsafe.ReflectMapUtil
 * @since 1.0.0
 */
@Slf4j
public final class MapUtil {

    /**
     * Converts an object to a map by mapping the field names to their corresponding values.
     *
     * @param <T>      the type of the object
     * @param entity   the object to be converted to a map
     * @param adapters adapts the entity for mapping to a map
     * @return a map representing the fields and their values of the object
     */
    public static <T> Map<String, Object> objectToMap(T entity,
                                                      Map<String, ObjectMapAdapter<T, ?>> adapters) {
        var resultMap = new HashMap<String, Object>();
        adapters.forEach((fieldName, adapter) -> resultMap.put(fieldName, adapter.fetch(entity)));
        return resultMap;
    }

    /**
     * Converts a map to an object of the specified type by setting the field values using the
     * map entries.
     *
     * @param objectMap the map representing the fields and their values
     * @param entity    an empty entity of the target class
     * @param adapters  the adapters to execute the setter for the entity
     * @param <T>       the type of the object to be created
     * @return an object of the specified type with the field values set from the map
     */
    public static <T> T mapToObject(Map<String, Object> objectMap,
                                    T entity,
                                    Map<String, ObjectMapAdapter<T, ?>> adapters) {
        adapters.forEach((fieldName, adapter) -> Optional.ofNullable(objectMap)
                .map((data) -> data.get(fieldName))
                .ifPresent((fieldValue) -> adapter.setValue(entity, fieldValue)));
        return entity;
    }

    /**
     * Retrieves the value of a field from an object using reflection.
     *
     * @param <E>     the type of the entity
     * @param <T>     the type of the field value
     * @param entity  the object from which to retrieve the field value
     * @param adapter the adapter to execute the getter
     * @return the value of the field in the object, or null if the field does not exist or cannot
     * be accessed
     */
    public static <E, T> T getFieldValue(E entity, ObjectMapAdapter<E, T> adapter) {
        return adapter.fetch(entity);
    }

    /**
     * Sets the value of a field in an object using reflection.
     *
     * @param <E>        the type of the entity
     * @param <T>        the type of the field value
     * @param entity     the object in which to set the field value
     * @param adapter    the adapter to execute the setter
     * @param fieldValue the value to be set
     */
    public static <E, T> void setFieldValue(E entity,
                                            ObjectMapAdapter<E, T> adapter,
                                            Object fieldValue) {
        adapter.setValue(entity, fieldValue);
    }

    /**
     * Casts the specified value to the required type with Optional.
     *
     * @param value        the value to be cast
     * @param requiredType the type to which the value should be cast
     * @param <T>          the type to which the value should be cast
     * @return the cast value, or {@code null} if the value is not an instance of the requiredType
     */
    public static <T> T cast(Object value, Class<T> requiredType) {
        return Optional.ofNullable(requiredType)
                .filter((clazz) -> clazz.isInstance(value))
                .map((clazz) -> clazz.cast(value))
                .orElse(null);
    }

    private MapUtil() {
    }
}
