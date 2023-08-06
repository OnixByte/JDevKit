/*
 * Copyright (C) 2023 CodeCraftersCN.
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

package cn.org.codecrafters.webcal;

import cn.org.codecrafters.webcal.config.Classification;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * WebCalendarEvent
 *
 * @author Zihlu Wang
 */
public final class WebCalendarEvent extends WebCalendarNode {

    private final static String TAG = "VEVENT";

    /**
     * Add a batch of categories.
     *
     * @param categories A batch of categories.
     * @return The Event instance.
     */
    public WebCalendarEvent addCategories(String... categories) {
        this.categories.addAll(Arrays.asList(categories));
        return this;
    }

    /**
     * Add a batch of categories.
     *
     * @param categories A batch of categories.
     * @return The Event instance.
     */
    public WebCalendarEvent addCategories(Collection<String> categories) {
        this.categories.addAll(categories);
        return this;
    }

    /**
     * Add a category.
     *
     * @param category A category.
     * @return The Event instance.
     */
    public WebCalendarEvent addCategory(String category) {
        this.categories.add(category);
        return this;
    }

    /**
     * Set the classification.
     *
     * @param classification The specified classification value.
     * @return The Event instance.
     */
    public WebCalendarEvent setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }

    /**
     * Set the comment.
     *
     * @param comment The comment.
     * @return The Event instance.
     */
    public WebCalendarEvent setComment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * Set the description.
     *
     * @param description The description.
     * @return The Event instance.
     */
    public WebCalendarEvent setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Set the location.
     *
     * @param location The location.
     * @return The Event instance.
     */
    public WebCalendarEvent setLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Set the percent complete value.
     *
     * @param percentComplete The percent complete value.
     * @return The Event instance.
     */
    public WebCalendarEvent setPercentComplete(Integer percentComplete) {
        if (percentComplete < 0 || percentComplete > 100) {
            throw new IllegalArgumentException("Percent out of range (0 ~ 100)");
        }
        this.percentComplete = percentComplete;
        return this;
    }

    /**
     * Set a priority.
     *
     * @param priority The priority to be set.
     * @return The Event instance.
     */
    public WebCalendarEvent setPriority(Integer priority) {
        if (priority < 0 || priority > 9) {
            throw new IllegalArgumentException("The priority you provide is out of range (0 ~ 9).");
        }
        this.priority = priority;
        return this;
    }

    /**
     * Set the summary.
     *
     * @param summary The summary (you can also call it as a title).
     * @return The Event instance.
     */
    public WebCalendarEvent setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    /**
     * Set the end of this node.
     *
     * @param end The end time of this event.
     * @return The Event instance.
     */
    public WebCalendarEvent setEnd(LocalDateTime end) {
        if (this.duration != null) {
            throw new IllegalStateException("You have set the field DURATION before, please remove it or remove setEnd.");
        }
        this.end = end;
        return this;
    }

    /**
     * Set the start of this event.
     *
     * @param start The date time specify the start time of this event.
     * @return The Event instance.
     */
    public WebCalendarEvent setStart(LocalDateTime start) {
        this.start = start;
        return this;
    }

    /**
     * Set the duration of this event.
     *
     * @param duration The duration of this event.
     * @return The Event instance.
     */
    public WebCalendarEvent setDuration(Duration duration) {
        if (this.end != null) {
            throw new IllegalStateException("You have set the field END before, please remove it or remove setDuration.");
        }
        this.duration = duration;
        return this;
    }

    /**
     * Set the URL.
     *
     * @param url The URL.
     * @return The Event instance.
     */
    public WebCalendarEvent setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Set the uid of this event.
     *
     * @param uid The uid.
     * @return The Event instance.
     */
    public WebCalendarEvent setUid(String uid) {
        this.uid = uid;
        return this;
    }

    /**
     * Set the domain name of this event.
     *
     * @param domainName The domain name.
     * @return The Event instance.
     */
    public WebCalendarEvent setDomainName(String domainName) {
        this.domainName = domainName;
        return this;
    }

    /**
     * Set the timezone of this event.
     *
     * @param timezone The time zone to set.
     * @return The Event instance.
     */
    public WebCalendarEvent setTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    @Override
    public String resolve() {
        return "\nBEGIN:" + TAG + "\n" +
                "UID:" + Optional.ofNullable(uid).orElse(UUID.randomUUID().toString()) + "@" + domainName + "\n" +
                Optional.ofNullable(summary).map((item) -> "SUMMARY:" + item + "\n").orElse("") +
                "DTSTART" + Optional.ofNullable(timezone).map(item -> ";TZID=" + item).orElse("") + ":" + start.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n" +
                Optional.ofNullable(categories)
                        .map((item) -> {
                            if (!item.isEmpty()) {
                                return "CATEGORIES:" + resolveCategories() + "\n";
                            }
                            return null;
                        }).orElse("") +
                Optional.ofNullable(duration)
                        .map((item) -> "DURATION:PT" + item.getSeconds() + "S\n").orElse("") +
                Optional.ofNullable(end)
                        .map((item) -> "DTEND:" + end.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n").orElse("") +
                Optional.ofNullable(classification)
                        .map((item) -> "CLASS:" + item.getClassification() + "\n").orElse("") +
                Optional.ofNullable(comment).map((item) -> "COMMENT:" + item + "\n").orElse("") +
                Optional.ofNullable(description).map((item) -> "DESCRIPTION:" + item + "\n").orElse("") +
                Optional.ofNullable(location).map((item) -> "LOCATION:" + item + "\n").orElse("") +
                Optional.ofNullable(percentComplete).map((item) -> "PERCENT-COMPLETE:" + item + "\n").orElse("") +
                Optional.ofNullable(priority).map((item) -> "PRIORITY:" + item + "\n").orElse("") +
                "END:" + TAG + "\n";
    }

}
