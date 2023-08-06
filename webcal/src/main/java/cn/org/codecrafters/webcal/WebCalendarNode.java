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
import java.util.ArrayList;
import java.util.List;

/**
 * WebCalendarNode
 *
 * @author Zihlu Wang
 */
public abstract sealed class WebCalendarNode
        permits WebCalendarEvent {

    /**
     * <p>
     * Categories, is used to specify categories or subtypes of the calendar component. The categories are useful in
     * searching for a calendar component of a particular type and category.
     * </p>
     *
     * Template:
     * <pre>CATEGORIES:APPOINTMENT,EDUCATION</pre>
     * <pre>CATEGORIES:MEETING</pre>
     *
     * <p>Referenced from <a href="https://icalendar.org/iCalendar-RFC-5545/3-8-1-2-categories.html"
     * >RFC-5545 - 3.8.1.2. Categories</a></p>
     */
    protected List<String> categories;

    /**
     * <p>
     * Classification, An access classification is only one component of the general security system within a calendar
     * application. It provides a method of capturing the scope of the access the calendar owner intends for information
     * within an individual calendar entry.
     * </p>
     *
     * Template:
     * <pre>CLASS:protected</pre>
     *
     * <p>Referenced from <a href="https://icalendar.org/iCalendar-RFC-5545/3-8-1-3-classification.html"
     * >RFC-5545 - 3.8.1.3. Classification</a></p>
     */
    protected Classification classification;

    /**
     * <p>
     * Comment, is used to specify a comment to the calendar user.
     * </p>
     *
     * Template:
     * <pre>
     * COMMENT:The meeting really needs to include both ourselves
     * and the customer. We can't hold this meeting without them.
     * As a matter of fact\, the venue for the meeting ought to be at
     * their site. - - John
     * </pre>
     *
     * <p>Referenced from <a href="https://icalendar.org/iCalendar-RFC-5545/3-8-1-4-comment.html"
     * >RFC-5545 - 3.8.1.4. Comment</a></p>
     */
    protected String comment;

    /**
     * <p>
     * Description is used in the {@link WebCalendarEvent} and <em>to-do</em> to capture lengthy extual descriptions associated with
     * the activity.
     * </p>
     * <p>
     * Description is used in the <em>Journal</em> calendar component to capture one or more textual journal entries.
     * </p>
     * <p>
     * Description is used in the <em>Alarm</em> calendar component to capture the display text for a DISPLAY category of
     * alarm, and to capture the body text for an EMAIL category of alarm.
     * </p>
     *
     * Template:
     * <pre>
     * DESCRIPTION:Meeting to provide technical review for "Phoenix"
     * design.\nHappy Face Conference Room. Phoenix design team
     * MUST attend this meeting.\nRSVP to team leader.
     * </pre>
     *
     * <p>Referenced from <a href="https://icalendar.org/iCalendar-RFC-5545/3-8-1-5-description.html"
     * >RFC-5545 - 3.8.1.5. Description</a></p>
     */
    protected String description;



    /**
     * <p>
     * Location, Specific venues such as conference or meeting rooms may be explicitly specified using this property.
     * </p>
     *
     * <p>
     * <b>Note</b><br>
     * This location has not implement the URI of the location.
     * </p>
     *
     * Template:
     * <pre>LOCATION:Conference Room - F123\, Bldg. 002</pre>
     * <pre>LOCATION;ALTREP="http://xyzcorp.com/conf-rooms/f123.vcf":
     *      Conference Room - F123\, Bldg. 002</pre>
     *
     * <p>Referenced from <a href="https://icalendar.org/iCalendar-RFC-5545/3-8-1-7-location.html"
     * >RFC-5545 - 3.8.1.7. Location</a></p>
     */
    protected String location;



    /**
     * <p>
     * Percent Complete, is a positive integer between 0 and 100. A value of "0" indicates the to-do has not yet been
     * started. A value of "100" indicates that the to-do has been completed. Integer values in between indicate the
     * percent partially complete.
     * </p>
     *
     * Template:
     * <pre>PERCENT-COMPLETE:39</pre>
     *
     * <p>Referenced from <a href="https://icalendar.org/iCalendar-RFC-5545/3-8-1-8-percent-complete.html"
     * >RFC-5545 - 3.8.1.8. Percent Complete</a></p>
     */
    protected Integer percentComplete;



    /**
     * <p>
     * Priority, is specified as an integer in the range 0 to 9. A value of 0 specifies an undefined priority. A value
     * of 1 is the highest priority. A value of 2 is the second-highest priority. Subsequent numbers specify a
     * decreasing ordinal priority. A value of 9 is the lowest priority.
     * </p>
     *
     * Example:
     * <ul style="list-style-type: none;">
     *     <li>
     *         The following is an example of a property with the highest priority:
     *         <pre>PRIORITY:1</pre>
     *     </li>
     *     <li>
     *         The following is an example of a property with a next highest priority:
     *         <pre>PRIORITY:2</pre>
     *     </li>
     * </ul>
     */
    protected Integer priority;



    /**
     * <p>
     * Summary, is used to capture a short, one-line summary about the activity or journal entry.
     * </p>
     *
     * Example:
     * <pre>SUMMARY:Department Party</pre>
     */
    protected String summary;



    // /**
    //  * Completed defines the date and time that a to-do was actually completed.
    //  *
    //  * <p>
    //  * Example:
    //  * <pre>COMPLETED:19960401T150000Z</pre>
    //  * </p>
    //  */
    // protected DateTime completed;
    //
    // /**
    //  * Set the specific time of the completion of this to-do event.
    //  *
    //  * @param completed The complete time.
    //  */
    // protected void setCompleted(DateTime completed) {
    //     this.completed = completed;
    // }

    /**
     * End defines the date and time by which the event ends.
     *
     * Example:
     * <pre>DTEND:19960401T150000Z</pre>
     * <pre>DTEND;VALUE=DATE:19980704</pre>
     */
    protected LocalDateTime end;



    /**
     * Start defines the start date and time for the event.
     *
     * Example:
     * <pre>DTSTART:19980118T073000Z</pre>
     * <pre>DTSTART;VALUE=DATE:19980118</pre>
     */
    protected LocalDateTime start;



    /**
     * Duration may be used to specify a duration of the event, instead of an explicit end DATE-TIME.
     *
     * Example:
     * <pre>DURATION:PT100000S</pre>
     */
    protected Duration duration;



    /**
     * URL may be used in a calendar component to convey a location where a more dynamic rendition of the calendar
     * information associated with the calendar component can be found.
     *
     * Example:
     * <pre>URL:http://example.com/pub/calendars/jsmith/mytime.ics</pre>
     */
    protected String url;

    protected String uid;

    protected String domainName;

    protected String timezone;



    //
    // Constructors
    //
    protected WebCalendarNode() {
        this.categories = new ArrayList<>();
    }

    public WebCalendarNode setDomainName(String domainName) {
        this.domainName = domainName;
        return this;
    }

    //
    // Protected methods
    //
    protected String resolveCategories() {
        var builder = new StringBuilder();
        if (categories != null && !categories.isEmpty()) {
            categories.forEach(item -> builder.append(item).append(","));
            return builder.substring(0, builder.length() - 1);
        }
        return builder.toString();
    }

    //
    // Abstract methods
    //
    public abstract String resolve();

}

