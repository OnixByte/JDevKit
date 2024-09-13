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

package com.onixbyte.nums.model;

/**
 * QuartileBound.
 *
 * @param upperBound
 * @param lowerBound
 * @author zihluwang
 */
public record QuartileBounds(
        Double upperBound,
        Double lowerBound
) {

    /**
     * Get a builder for {@link QuartileBounds}.
     *
     * @return a builder
     */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Double upperBound;
        private Double lowerBound;

        private Builder() {
        }

        public Builder upperBound(Double upperBound) {
            this.upperBound = upperBound;
            return this;
        }

        public Builder lowerBound(Double lowerBound) {
            this.lowerBound = lowerBound;
            return this;
        }

        public QuartileBounds build() {
            return new QuartileBounds(upperBound, lowerBound);
        }
    }

}
