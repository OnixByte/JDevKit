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

package com.onixbyte.icalendar.component.property;

import com.onixbyte.icalendar.datatype.CalendarUserAddress;
import com.onixbyte.icalendar.property.parameter.*;

import java.util.Optional;

public final class Attendee implements ComponentProperty {

    public static final String PROPERTY_NAME = "ATTENDEE";

    private final CalendarUserType calendarUserType;

    private final GroupOrListMembership groupOrListMembership;

    private final ParticipationRole role;

    private final ParticipationStatus status;

    private final RsvpExpectation rsvp;

    private final Delegatee delegatee;

    private final Delegator delegator;

    private final SentBy sentBy;

    private final CommonName commonName;

    private final DirectoryEntryReference directory;

    private final Language language;

    private final CalendarUserAddress value;

    private Attendee(CalendarUserType calendarUserType,
                     GroupOrListMembership groupOrListMembership,
                     ParticipationRole role,
                     ParticipationStatus status,
                     RsvpExpectation rsvp,
                     Delegatee delegatee,
                     Delegator delegator,
                     SentBy sentBy,
                     CommonName commonName,
                     DirectoryEntryReference directory,
                     Language language,
                     CalendarUserAddress value) {
        this.calendarUserType = calendarUserType;
        this.groupOrListMembership = groupOrListMembership;
        this.role = role;
        this.status = status;
        this.rsvp = rsvp;
        this.delegatee = delegatee;
        this.delegator = delegator;
        this.sentBy = sentBy;
        this.commonName = commonName;
        this.directory = directory;
        this.language = language;
        this.value = value;
    }

    public static class Builder {
        private CalendarUserType calendarUserType;

        private GroupOrListMembership groupOrListMembership;

        private ParticipationRole role;

        private ParticipationStatus status;

        private RsvpExpectation rsvp;

        private Delegatee delegatee;

        private Delegator delegator;

        private SentBy sentBy;

        private CommonName commonName;

        private DirectoryEntryReference directory;

        private Language language;

        private CalendarUserAddress attendee;

        private Builder() {
        }

        public Builder calendarUserType(CalendarUserType calendarUserType) {
            this.calendarUserType = calendarUserType;
            return this;
        }

        public Builder groupOrListMembership(GroupOrListMembership groupOrListMembership) {
            this.groupOrListMembership = groupOrListMembership;
            return this;
        }

        public Builder role(ParticipationRole role) {
            this.role = role;
            return this;
        }

        public Builder status(ParticipationStatus status) {
            this.status = status;
            return this;
        }

        public Builder rsvp(RsvpExpectation rsvp) {
            this.rsvp = rsvp;
            return this;
        }

        public Builder delegatee(Delegatee delegatee) {
            this.delegatee = delegatee;
            return this;
        }

        public Builder delegator(Delegator delegator) {
            this.delegator = delegator;
            return this;
        }

        public Builder sentBy(SentBy sentBy) {
            this.sentBy = sentBy;
            return this;
        }

        public Builder commonName(CommonName commonName) {
            this.commonName = commonName;
            return this;
        }

        public Builder directory(DirectoryEntryReference directory) {
            this.directory = directory;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder attendee(CalendarUserAddress calendarUserAddress) {
            this.attendee = calendarUserAddress;
            return this;
        }

        public Attendee build() {
            return new Attendee(calendarUserType, groupOrListMembership, role, status, rsvp,
                    delegatee, delegator, sentBy, commonName, directory, language, attendee);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String resolve() {
        var builder = new StringBuilder(PROPERTY_NAME);

        builder.append(Optional.ofNullable(calendarUserType)
                        .map(CalendarUserType::resolve)
                        .orElse(""))
                .append(Optional.ofNullable(groupOrListMembership)
                        .map(GroupOrListMembership::resolve)
                        .orElse(""))
                .append(Optional.ofNullable(role)
                        .map(ParticipationRole::resolve)
                        .orElse(""))
                .append(Optional.ofNullable(status)
                        .map(ParticipationStatus::resolve)
                        .orElse(""))
                .append(Optional.ofNullable(rsvp)
                        .map(RsvpExpectation::resolve)
                        .orElse(""))
                .append(Optional.ofNullable(delegatee)
                        .map(Delegatee::resolve)
                        .orElse(""))
                .append(Optional.ofNullable(delegator)
                        .map(Delegator::resolve)
                        .orElse(""))
                .append(Optional.ofNullable(sentBy)
                        .map(SentBy::resolve)
                        .orElse(""))
                .append(Optional.ofNullable(commonName)
                        .map(CommonName::resolve)
                        .orElse(""));
                // .append()


        return "";
    }
}
