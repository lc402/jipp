package com.hp.jipp.encoding;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

/**
 * Value and delimiter tags as specified by RFC2910 and RFC3382
 */
@AutoValue
public abstract class Tag extends NameCode {

    // Delimiter tags
    public static final Tag OperationAttributes = of("operation-attributes", 0x01);
    public static final Tag JobAttributes = of("job-attributes", 0x02);
    public static final Tag EndOfAttributes = of("end-of-attributes", 0x03);
    public static final Tag PrinterAttributes = of("printer-attributes", 0x04);
    public static final Tag UnsupportedAttributes = of("unsupported-attributes", 0x05);

    public static final Tag Unsupported = of("unsupported", 0x10);
    public static final Tag Unknown = of("unknown", 0x12);
    public static final Tag NoValue = of("no-value", 0x13);

    // Integer values
    public static final Tag IntegerValue = of("integer", 0x21);
    public static final Tag BooleanValue = of("boolean", 0x22);
    public static final Tag EnumValue = of("enum", 0x23);

    // Octet-string values
    public static final Tag OctetString = of("octetString", 0x30);
    public static final Tag DateTime = of("dateTime", 0x31);
    public static final Tag Resolution = of("resolution", 0x32);
    public static final Tag RangeOfInteger = of("rangeOfInteger", 0x33);
    public static final Tag BeginCollection = of("begCollection", 0x34);
    public static final Tag TextWithLanguage = of("textWithLanguage", 0x35);
    public static final Tag NameWithLanguage = of("nameWithLanguage", 0x36);
    public static final Tag EndCollection = of("endCollection", 0x37);

    // Character-string values
    public static final Tag TextWithoutLanguage = of("textWithoutLanguage", 0x41);
    public static final Tag NameWithoutLanguage = of("nameWithoutLanguage", 0x42);
    public static final Tag Keyword = of("keyword", 0x44);
    public static final Tag Uri = of("uri", 0x45);
    public static final Tag UriScheme = of("uriScheme", 0x46);
    public static final Tag Charset = of("charset", 0x47);
    public static final Tag NaturalLanguage = of("naturalLanguage", 0x48);
    public static final Tag MimeMediaType = of("mimeMediaType", 0x49);
    public static final Tag MemberAttributeName = of("memberAttrName", 0x4A);

    private static final ImmutableSet<Tag> All = ImmutableSet.of(OperationAttributes, JobAttributes, EndOfAttributes,
            PrinterAttributes, UnsupportedAttributes, Unsupported, Unknown, NoValue, IntegerValue, BooleanValue,
            EnumValue, OctetString, DateTime, Resolution, RangeOfInteger, BeginCollection,
            TextWithLanguage, NameWithLanguage, EndCollection, TextWithoutLanguage,
            NameWithoutLanguage, Keyword, Uri, UriScheme, Charset, NaturalLanguage,
            MimeMediaType, MemberAttributeName);

    private static final Map<Integer, Tag> sMap = NameCode.toMap(All);

    public static Tag of(int code) {
        Tag tag = sMap.get(code);
        if (tag == null) return Tag.of(String.format(Locale.US, "tag(x%x)", code), code);
        return tag;
    }

    /** Read and return a tag from the input stream */
    public static Tag read(DataInputStream in) throws IOException {
        return of(in.readByte());
    }

    /**
     * Returns a new instance
     * @param name human-readable name
     * @param value machine-readable identifier
     */
    public static Tag of(String name, int value) {
        return new AutoValue_Tag(name, value);
    }

    /** Write this tag to the output stream */
    public void write(DataOutputStream out) throws IOException {
        out.writeByte((byte) getCode());
    }

    /** Return true if this tag is a delimiter tag */
    public boolean isDelimiter() {
        return getCode() >= 0x01 && getCode() < 0x10;
    }

    @Override
    public final String toString() {
        return getName();
    }
}
