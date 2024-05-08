package com.onixbyte.icalendar.property.parameter;

import com.onixbyte.icalendar.property.Prop;

import java.net.URI;

/**
 * Alternate Text Representation specifies a URI that points to an alternate representation for a
 * textual property value. A property specifying this parameter MUST also include a value that
 * reflects the default representation of the text value. The URI parameter value MUST be specified
 * in a quoted-string.
 * <p>
 * <b>Note</b>: While there is no restriction imposed on the URI schemes allowed for this
 * parameter, Content Identifier (CID) [RFC 2392], HTTP [RFC 2616], and HTTPS [RFC 2818] are the
 * URI schemes most commonly used by current implementations.
 *
 * @author Zihlu Wang
 */
public final class AlternateRepresentation implements Prop {

    private static final String PROPERTY_NAME = "ALTREP";

    private URI uri;

    private AlternateRepresentation() {
    }

    public AlternateRepresentation setUri(String uri) {
        this.uri = URI.create(uri);
        return this;
    }

    public AlternateRepresentation setUri(URI uri) {
        this.uri = uri;
        return this;
    }

    public static AlternateRepresentation createInstance(String uri) {
        var instance = new AlternateRepresentation();
        instance.uri = URI.create(uri);
        return instance;
    }

    @Override
    public String resolve() {
        return PROPERTY_NAME + "=\"" + uri.toString() + "\"";
    }
}
