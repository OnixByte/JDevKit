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

package com.onixbyte.icalendar.calendar.property;

/**
 * ProductIdentifier
 *
 * @author Zihlu WANG
 */
public final class ProductIdentifier implements Property {

    private final String value;

    @Override
    public String resolve() {
        return PROPERTY_NAME + ":" + value + '\n';
    }

    public static class Builder {
        private String productIdentifier;

        private Builder() {
        }

        public Builder productIdentifier(String productIdentifier) {
            this.productIdentifier = productIdentifier;
            return this;
        }

        public Builder productIdentifier(String companyName, String productName) {
            this.productIdentifier = "-//" + companyName + "//" + productName + "//EN";
            return this;
        }

        public Builder productIdentifier(String companyName, String productName, String languageTag) {
            this.productIdentifier = "-//" + companyName + "//" + productName + "//" + languageTag;
            return this;
        }

        public ProductIdentifier build() {
            return new ProductIdentifier(productIdentifier);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private static final String PROPERTY_NAME = "PRODID";

    private ProductIdentifier(String value) {
        this.value = value;
    }
}
