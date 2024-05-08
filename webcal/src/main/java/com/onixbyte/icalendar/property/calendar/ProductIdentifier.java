package com.onixbyte.icalendar.property.calendar;

import com.onixbyte.icalendar.property.Prop;

/**
 * ProductIdentifier
 *
 * @author Zihlu WANG
 */
public final class ProductIdentifier implements Prop {

    private String value;

    @Override
    public String resolve() {
        return PROPERTY_NAME + ":" + value + '\n';
    }

    public static class Builder {
        private final ProductIdentifier productIdentifier;

        private Builder() {
            this.productIdentifier = new ProductIdentifier();
        }

        public Builder productIdentifier(String productIdentifier) {
            this.productIdentifier.value = productIdentifier;
            return this;
        }

        public Builder productIdentifier(String companyName, String productName) {
            this.productIdentifier.value = "-//" + companyName + "//" + productName + "//EN";
            return this;
        }

        public Builder productIdentifier(String companyName, String productName, String languageTag) {
            this.productIdentifier.value = "-//" + companyName + "//" + productName + "//" + languageTag;
            return this;
        }

        public ProductIdentifier build() {
            return productIdentifier;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private static final String PROPERTY_NAME = "PRODID";

    private ProductIdentifier() {
    }
}
