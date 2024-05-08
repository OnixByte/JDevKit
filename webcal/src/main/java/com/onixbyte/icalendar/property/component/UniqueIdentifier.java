package com.onixbyte.icalendar.property.component;

import com.onixbyte.icalendar.property.Prop;

/**
 * UniqueIdentifier
 *
 * @author Zihlu WANG
 */
public final class UniqueIdentifier implements Prop {

    private String value;

    private UniqueIdentifier() {
    }

    private void setValue(String value) {
        this.value = value;
    }

    public static class Builder {
        private final UniqueIdentifier uniqueIdentifier;

        private Builder() {
            this.uniqueIdentifier = new UniqueIdentifier();
        }

        public Builder uniqueIdentifier(String uniqueIdentifier) {
            this.uniqueIdentifier.value = uniqueIdentifier;
            return this;
        }

        public Builder uniqueIdentifier(String uniqueIdentifier, String domainName) {
            this.uniqueIdentifier.value = uniqueIdentifier + "@" + domainName;
            return this;
        }

        public UniqueIdentifier build() {
            return uniqueIdentifier;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String resolve() {
        return "uid:" + this.value + '\n';
    }
}
