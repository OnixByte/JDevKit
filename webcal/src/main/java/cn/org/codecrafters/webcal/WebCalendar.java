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

import java.util.ArrayList;
import java.util.List;

/**
 * WebCalendar
 *
 * @author Zihlu Wang
 */
public final class WebCalendar {

    //
    // Constants
    //

    // Tag
    private final static String TAG = "VCALENDAR";

    //
    // Fields
    //

    private String name;

    /**
     * Company name. This value is to specify the {@code productIdentifier}
     * property.
     */
    private String companyName;

    /**
     * Product name. This value is to specify the {@code productIdentifier}
     * property.
     */
    private String productName;

    private String domainName;

    /**
     * Calendar scale, referenced from <a href="https://icalendar.org/iCalendar-RFC-5545/3-7-1-calendar-scale.html"
     * >RFC 5545 - 3.7.1. Calendar Scale</a>.
     */
    private final String scale = "GREGORIAN";

    /**
     * Method, referenced from <a href="https://icalendar.org/iCalendar-RFC-5545/3-7-2-method.html"
     * >RFC 5545 - 3.7.2. Method</a>.
     */
    private String method;

    private final String version = "2.0";

    private List<WebCalendarNode> nodes;

    //
    // Constructors
    //
    public WebCalendar() {
        this.nodes = new ArrayList<>();
    }

    //
    // Methods
    //

    /**
     * Set the name for this calendar.
     *
     * @param name The name for the calendar.
     * @return The calendar instance.
     */
    public WebCalendar setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Set the company name for this calendar.
     *
     * @param companyName The company name for the calendar.
     * @return The calendar instance.
     */
    public WebCalendar setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public WebCalendar setDomainName(String domainName) {
        this.domainName = domainName;
        return this;
    }

    /**
     * Set the product name for this calendar.
     *
     * @param productName The product name for the calendar.
     * @return The calendar instance.
     */
    public WebCalendar setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    /**
     * Set the method for this calendar.
     *
     * @param method The product name for the calendar.
     * @return The calendar instance.
     */
    public WebCalendar setMethod(String method) {
        this.method = method;
        return this;
    }

    /**
     * Add a calendar node to this calendar.
     *
     * @param node Any calendar node.
     * @return The calendar instance.
     */
    public WebCalendar addEvent(WebCalendarNode node) {
        this.nodes.add(node);
        return this;
    }

    /**
     * Resolve the calendar instance to a text that implements RFC-5545.
     *
     * @return A string includes all events in this calendar.
     */
    public String resolve() {
        var events = new StringBuilder();
        if (nodes != null && !nodes.isEmpty()) {
            nodes.forEach(item ->
                    events.append(item.setDomainName(domainName)
                            .resolve()));
        }

        return "BEGIN:" + TAG + "\n" +
                "PRODID:-//" + companyName + "//" + productName + "//EN\n" +
                "VERSION:" + version + "\n" +
                "X-WR-CALNAME:" + name + "\n" +
                events + "\n" +
                "END:" + TAG;
    }

}

