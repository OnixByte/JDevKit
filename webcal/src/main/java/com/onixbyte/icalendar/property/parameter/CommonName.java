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

package com.onixbyte.icalendar.property.parameter;

import com.onixbyte.icalendar.property.Prop;

/**
 * Common Name can be specified on properties with a CAL-ADDRESS value type. The parameter
 * specifies the common name to be associated with the calendar user specified by the property.
 * The parameter value is text. The parameter value can be used for display text to be associated
 * with the calendar address specified by the property.
 *
 * @author Zihlu Wang
 */
public final class CommonName implements Prop {

    private String value;

    private CommonName() {
    }

    public CommonName setValue(String value) {
        this.value = value;
        return this;
    }

    public static CommonName createInstance(String commonName) {
        var instance = new CommonName();
        instance.value = commonName;
        return instance;
    }

    @Override
    public String resolve() {
        return "CN=\"" + this.value + "\"";
    }
}
