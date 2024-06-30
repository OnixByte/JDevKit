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

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Adapts an Object to a Map, making conversion between Map and Object much more safe.
 *
 * @param <E> entity type
 * @param <T> field type
 * @author zihluwang
 * @version 1.4.2
 * @since 1.4.2
 */
public class ObjectMapAdapter<E, T> {

    private final Function<E, T> getter;

    private final BiConsumer<E, Object> setter;

    /**
     * Create an adapter.
     *
     * @param getter the getter of the field
     * @param setter the setter of the field
     */
    public ObjectMapAdapter(Function<E, T> getter, BiConsumer<E, Object> setter) {
        this.getter = getter;
        this.setter = setter;
    }

    /**
     * Get data from the entity.
     *
     * @param entity the source of the data
     * @return the data
     */
    public T fetch(E entity) {
        return getter.apply(entity);
    }

    /**
     * Set value to the entity.
     *
     * @param entity the target of the data
     * @param value  the value
     */
    public void setValue(E entity, Object value) {
        setter.accept(entity, value);
    }

}
