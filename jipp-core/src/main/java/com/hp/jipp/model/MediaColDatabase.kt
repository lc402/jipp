// Copyright 2018 HP Development Company, L.P.
// SPDX-License-Identifier: MIT
//
// DO NOT MODIFY. Code is auto-generated by genTypes.py. Content taken from registry at
// https://www.iana.org/assignments/ipp-registrations/ipp-registrations.xml, updated on 2018-04-06
@file:Suppress("MaxLineLength", "WildcardImport")

package com.hp.jipp.model

import com.hp.jipp.encoding.* // ktlint-disable no-wildcard-imports

/**
 * Data object corresponding to a "media-col-database" collection as defined in:
 * [PWG5100.11](http://ftp.pwg.org/pub/pwg/candidates/cs-ippjobprinterext10-20101030-5100.11.pdf),
 * [PWG5100.13](http://ftp.pwg.org/pub/pwg/candidates/cs-ippjobprinterext3v10-20120727-5100.13.pdf).
 */
@Suppress("RedundantCompanionReference", "unused")
data class MediaColDatabase
constructor(
    var mediaSourceProperties: MediaSourceProperties? = null
) : AttributeCollection {

    /** Construct an empty [MediaColDatabase]. */
    constructor() : this(null)

    /** Produce an attribute list from members. */
    override val attributes: List<Attribute<*>> by lazy {
        listOfNotNull(
            mediaSourceProperties?.let { Types.mediaSourceProperties.of(it) }
        )
    }

    /** Type for attributes of this collection */
    class Type(override val name: String) : AttributeCollection.Type<MediaColDatabase>(MediaColDatabase)

    /** All member names as strings. */
    object Name {
        /** "media-source-properties" member name */
        const val mediaSourceProperties = "media-source-properties"
    }

    /** Types for each member attribute. */
    object Types {
        val mediaSourceProperties = MediaSourceProperties.Type(Name.mediaSourceProperties)
    }

    /** Defines types for each member of [MediaColDatabase] */
    companion object : AttributeCollection.Converter<MediaColDatabase> {
        override fun convert(attributes: List<Attribute<*>>): MediaColDatabase =
            MediaColDatabase(
                extractOne(attributes, Types.mediaSourceProperties)
            )
    }

    /**
     * Data object corresponding to a "media-source-properties" collection.
     */
    @Suppress("RedundantCompanionReference", "unused")
    data class MediaSourceProperties
    constructor(
        /** May contain any keyword from [FeedOrientation]. */
        var mediaSourceFeedDirection: String? = null,
        var mediaSourceFeedOrientation: Orientation? = null
    ) : AttributeCollection {

        /** Construct an empty [MediaSourceProperties]. */
        constructor() : this(null, null)

        /** Produce an attribute list from members. */
        override val attributes: List<Attribute<*>> by lazy {
            listOfNotNull(
                mediaSourceFeedDirection?.let { Types.mediaSourceFeedDirection.of(it) },
                mediaSourceFeedOrientation?.let { Types.mediaSourceFeedOrientation.of(it) }
            )
        }

        /** Type for attributes of this collection */
        class Type(override val name: String) : AttributeCollection.Type<MediaSourceProperties>(MediaSourceProperties)

        /** All member names as strings. */
        object Name {
            /** "media-source-feed-direction" member name */
            const val mediaSourceFeedDirection = "media-source-feed-direction"
            /** "media-source-feed-orientation" member name */
            const val mediaSourceFeedOrientation = "media-source-feed-orientation"
        }

        /** Types for each member attribute. */
        object Types {
            val mediaSourceFeedDirection = KeywordType(Name.mediaSourceFeedDirection)
            /**
             * "media-source-feed-orientation" member type.
             */
            val mediaSourceFeedOrientation = Orientation.Type(Name.mediaSourceFeedOrientation)
        }

        /** Defines types for each member of [MediaSourceProperties] */
        companion object : AttributeCollection.Converter<MediaSourceProperties> {
            override fun convert(attributes: List<Attribute<*>>): MediaSourceProperties =
                MediaSourceProperties(
                    extractOne(attributes, Types.mediaSourceFeedDirection),
                    extractOne(attributes, Types.mediaSourceFeedOrientation)
                )
        }
    }
}
