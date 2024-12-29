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

import java.util.Map;

/**
 * Adapts an Object to a Map, making conversion between Map and Object much more safe.
 *
 * @param <T> field type
 * @author zihluwang
 * @version 1.7.0
 * @since 1.4.2
 */
public interface ObjectMapAdapter<T> {

    /**
     * Convert an object to a map.
     *
     * @param element the element that will be converted to Map
     * @return a Map that is converted from the element
     */
    Map<String, Object> toMap(T element);

    /**
     * Convert a Map to an object.
     *
     * @param map the map that will be converted to Object
     * @return the object that is converted from the Map
     */
    T toObject(Map<String, Object> map);

}
