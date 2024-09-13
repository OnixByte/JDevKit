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
package com.onixbyte.nums;

import com.onixbyte.nums.model.QuartileBounds;

import java.util.List;

/**
 * Percentile calculator.
 *
 * @author zihluwang
 * @version 1.7.0
 * @since 1.7.0
 */
public final class PercentileCalculator {

    public static Double calculatePercentile(List<Double> values, Double percentile) {
        var sorted = values.stream().sorted().toList();
        if (sorted.isEmpty()) {
            throw new IllegalArgumentException("Unable to sort an empty list.");
        }

        var rank = percentile / 100. * (sorted.size() - 1);
        var lowerIndex = ((int) Math.floor(rank));
        var upperIndex = ((int) Math.ceil(rank));
        var weight = rank - lowerIndex;

        return sorted.get(lowerIndex) * (1 - weight) + sorted.get(upperIndex) * weight;
    }

    public static QuartileBounds calculatePercentileBounds(List<Double> data) {
        var sorted = data.stream().sorted().toList();
        var Q1 = calculatePercentile(sorted, 25.);
        var Q3 = calculatePercentile(sorted, 75.);

        var IQR = Q3 - Q1;

        var lowerBound = Q1 - 1.5 * IQR;
        var upperBound = Q3 + 1.5 * IQR;

        return QuartileBounds.builder()
                .upperBound(upperBound)
                .lowerBound(lowerBound)
                .build();
    }

}
