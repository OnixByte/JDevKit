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
import cn.org.codecrafters.webcal.config.Formatter;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * The {@code WebCalendarEvent} class represents an event in the web calendar.
 * It extends the abstract class WebCalendarNode and provides additional
 * methods to set properties specific to events.
 * <p>
 * Users can use the methods in this class to add categories, set the
 * classification, add comments, descriptions, locations, set percent
 * complete, set priority, set summary, set start time, set end time, set
 * duration, set URL, set UID, and set timezone for the event. After setting
 * the properties, users can call the {@link #resolve()} method to generate the
 * corresponding iCalendar content for the event.
 *
 * @author Zihlu Wang
 * @version 1.1.0
 * @since 1.0.0
 */
public final class WebCalendarEvent extends WebCalendarNode {

    private final static String TAG = "VEVENT";

    /**
     * Add categories to the event.
     *
     * @param categories the categories to add
     * @return the WebCalendarEvent object
     */
    public WebCalendarEvent addCategories(String... categories) {
        this.categories.addAll(Arrays.asList(categories));
        return this;
    }

    /**
     * Add a collection of categories to the event.
     *
     * @param categories the collection of categories to add
     * @return the WebCalendarEvent object
     */
    public WebCalendarEvent addCategories(Collection<String> categories) {
        this.categories.addAll(categories);
        return this;
    }

    /**
     * Add a single category to the event.
     *
     * @param category the category to add
     * @return the WebCalendarEvent object
     */
    public WebCalendarEvent addCategory(String category) {
        this.categories.add(category);
        return this;
    }

    /**
     * Set the classification of the event.
     *
     * @param classification the classification to set
     * @return the WebCalendarEvent object
     */
    public WebCalendarEvent setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }

    /**
     * Set the comment for the event.
     *
     * @param comment the comment to set
     * @return the WebCalendarEvent object
     */
    public WebCalendarEvent setComment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * Set the description for the event.
     *
     * @param description the description to set
     * @return the WebCalendarEvent object
     */
    public WebCalendarEvent setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Set the location for the event.
     *
     * @param location the location to set
     * @return the WebCalendarEvent object
     */
    public WebCalendarEvent setLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Set the percent complete for the event.
     *
     * @param percentComplete the percent complete to set
     * @return the WebCalendarEvent object
     * @throws IllegalArgumentException if the percent complete is out of range (0 ~ 100)
     */
    public WebCalendarEvent setPercentComplete(Integer percentComplete) {
        if (percentComplete < 0 || percentComplete > 100) {
            throw new IllegalArgumentException("Percent out of range (0 ~ 100)");
        }
        this.percentComplete = percentComplete;
        return this;
    }

    /**
     * Set the priority for the event.
     *
     * @param priority the priority to set
     * @return the WebCalendarEvent object
     * @throws IllegalArgumentException if the priority is out of range (0 ~ 9)
     */
    public WebCalendarEvent setPriority(Integer priority) {
        if (priority < 0 || priority > 9) {
            throw new IllegalArgumentException("The priority you provide is out of range (0 ~ 9).");
        }
        this.priority = priority;
        return this;
    }

    /**
     * Set the summary for the event.
     *
     * @param summary the summary to set
     * @return the WebCalendarEvent object
     */
    public WebCalendarEvent setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    /**
     * Set the end time for the event.
     *
     * @param end the end time to set
     * @return the WebCalendarEvent object
     * @throws IllegalStateException if the field DURATION has been set before
     */
    public WebCalendarEvent setEnd(LocalDateTime end) {
        if (this.duration != null) {
            throw new IllegalStateException("You have set the field DURATION before, please remove it or remove setEnd.");
        }
        this.end = end;
        return this;
    }

    /**
     * Set the start time for the event.
     *
     * @param start the start time to set
     * @return the WebCalendarEvent object
     */
    public WebCalendarEvent setStart(LocalDateTime start) {
        this.start = start;
        return this;
    }

    /**
     * Set the duration for the event.
     *
     * @param duration the duration to set
     * @return the WebCalendarEvent object
     * @throws IllegalStateException if the field END has been set before
     */
    public WebCalendarEvent setDuration(Duration duration) {
        if (this.end != null) {
            throw new IllegalStateException("You have set the field END before, please remove it or remove setDuration.");
        }
        this.duration = duration;
        return this;
    }

    /**
     * Set the URL for the event.
     *
     * @param url the URL to set
     * @return the WebCalendarEvent object
     */
    public WebCalendarEvent setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Set the UID for the event.
     *
     * @param uid the UID to set
     * @return the WebCalendarEvent object
     */
    public WebCalendarEvent setUid(String uid) {
        this.uid = uid;
        return this;
    }

    /**
     * Set the domain name for the event.
     *
     * @param domainName the domain name to set
     * @return the WebCalendarEvent object
     */
    public WebCalendarEvent setDomainName(String domainName) {
        this.domainName = domainName;
        return this;
    }

    /**
     * Set the timezone for the event.
     *
     * @param timezone the timezone to set
     * @return the WebCalendarEvent object
     */
    public WebCalendarEvent setTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    /**
     * Generate and resolve the iCalendar content for the event.
     *
     * @return the resolved iCalendar content for the event
     */
    @Override
    public String resolve() {
        var now = LocalDateTime.now().atZone(ZoneId.systemDefault());
        return MessageFormat.format("""
                        BEGIN:{0}
                        UID:{1}
                        DTSTAMP:{2}
                        DTSTART:{3}
                        DURATION:PT{6}S
                        {4}{5}{7}{8}{9}{10}{11}{12}
                        END:{0}""",
                TAG, // 0 - tag
                Optional.ofNullable(uid).orElse(UUID.randomUUID().toString()) + "@" + domainName, // 1 - uid
                now.format(Formatter.getUtcDatetimeFormatter()), // 2 - dtstamp
                start.atZone(ZoneId.systemDefault()).format(Formatter.getUtcDatetimeFormatter()), // 3 - start time
                Optional.ofNullable(summary).map((item) -> "\nSUMMARY:" + item).orElse(""), // 4 - summary
                Optional.ofNullable(categories)
                        .map((item) -> !item.isEmpty() ? "\nCATEGORIES:" + resolveCategories() : null).orElse(""), // 5 - categories
                Optional.ofNullable(duration)
                        .map((_duration) -> String.valueOf(_duration.getSeconds()))
                        .orElse(Optional.ofNullable(end)
                                .map((_end) -> String.valueOf(Duration.between(_end, start).getSeconds()))
                                .orElse("0")), // 6 - duration
                Optional.ofNullable(classification).map((_classification) -> "\nCLASS:" + _classification + "\n").orElse(""), /* 7 - classification */
                Optional.ofNullable(comment).map((_comment) -> "\nCOMMENT:" + _comment + "\n").orElse(""), /* 8 - comment */
                Optional.ofNullable(location).map((_location) -> "\nLOCATION:" + _location).orElse("") /* 9 - location */,
                Optional.ofNullable(percentComplete).map((_percentComplete) -> "\nPERCENT-COMPLETE:" + _percentComplete).orElse("") /* 10 = percentComplete */,
                Optional.ofNullable(description).map((_description) -> "\nDESCRIPTION:" + _description).orElse("") /* 11 - description */,
                Optional.ofNullable(priority).map((_priority) -> "\nPRIORITY:" + _priority).orElse("") /* 12 - priority */
        );
    }

}
