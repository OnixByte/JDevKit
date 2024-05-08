package com.onixbyte.icalendar.constant;

/**
 * This property defines the access classification for a calendar component.
 * <p>
 * The property can be specified once in a {@link CalendarEvent CalEvent}, {@link
 * com.onixbyte.icalendar.impl.CalTodo CalTodo}, or {@link com.onixbyte.icalendar.impl.CalJournal CalJournal}
 * calendar properties.
 */
public enum Classification {

    /**
     * Public events mean that anyone can view and access their detailed information. These events are typically used
     * in public calendars such as holiday calendars or company-wide event calendars. For public events, anyone with
     * access to the calendar can see all the event details.
     */
    PUBLIC,
    /**
     * Private events mean that only invited or specifically authorized individuals can view and access their detailed
     * information. Private events are visible to the owner of the calendar but not to others. This classification is
     * commonly used for personal appointments, private meetings, etc.
     */
    PRIVATE,
    /**
     * Confidential events have detailed information that is not visible to anyone, including the owner of the calendar.
     * Only individuals who have been granted specific permissions can access the detailed information of confidential
     * events. This classification is typically used for sensitive business meetings, personal privacy matters, etc.
     */
    CONFIDENTIAL,
    ;

    @Override
    public String toString() {
        return name();
    }
}
