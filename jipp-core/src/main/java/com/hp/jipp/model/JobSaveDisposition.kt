// Copyright 2018 HP Development Company, L.P.
// SPDX-License-Identifier: MIT
//
// DO NOT MODIFY. Code is auto-generated by genTypes.py. Content taken from registry at
// https://www.iana.org/assignments/ipp-registrations/ipp-registrations.xml, updated on 2018-04-06
@file:Suppress("MaxLineLength", "WildcardImport")

package com.hp.jipp.model

import com.hp.jipp.encoding.* // ktlint-disable no-wildcard-imports

/**
 * Data object corresponding to a "job-save-disposition" collection as defined in:
 * [PWG5100.11](http://ftp.pwg.org/pub/pwg/candidates/cs-ippjobprinterext10-20101030-5100.11.pdf).
 */
@Suppress("RedundantCompanionReference", "unused")
data class JobSaveDisposition
constructor(
    /** May contain any keyword from [SaveDisposition]. */
    var saveDisposition: String? = null,
    var saveInfo: List<SaveInfo>? = null
) : AttributeCollection {

    /** Construct an empty [JobSaveDisposition]. */
    constructor() : this(null, null)

    /** Produce an attribute list from members. */
    override val attributes: List<Attribute<*>> by lazy {
        listOfNotNull(
            saveDisposition?.let { Types.saveDisposition.of(it) },
            saveInfo?.let { Types.saveInfo.of(it) }
        )
    }

    /** Type for attributes of this collection */
    class Type(override val name: String) : AttributeCollection.Type<JobSaveDisposition>(JobSaveDisposition)

    /** All member names as strings. */
    object Name {
        /** "save-disposition" member name */
        const val saveDisposition = "save-disposition"
        /** "save-info" member name */
        const val saveInfo = "save-info"
    }

    /** Types for each member attribute. */
    object Types {
        val saveDisposition = KeywordType(Name.saveDisposition)
        val saveInfo = SaveInfo.Type(Name.saveInfo)
    }

    /** Defines types for each member of [JobSaveDisposition] */
    companion object : AttributeCollection.Converter<JobSaveDisposition> {
        override fun convert(attributes: List<Attribute<*>>): JobSaveDisposition =
            JobSaveDisposition(
                extractOne(attributes, Types.saveDisposition),
                extractAll(attributes, Types.saveInfo)
            )
    }

    /**
     * Data object corresponding to a "save-info" collection.
     */
    @Suppress("RedundantCompanionReference", "unused")
    data class SaveInfo
    constructor(
        var saveDocumentFormat: String? = null,
        var saveLocation: java.net.URI? = null,
        var saveName: String? = null
    ) : AttributeCollection {

        /** Construct an empty [SaveInfo]. */
        constructor() : this(null, null, null)

        /** Produce an attribute list from members. */
        override val attributes: List<Attribute<*>> by lazy {
            listOfNotNull(
                saveDocumentFormat?.let { Types.saveDocumentFormat.of(it) },
                saveLocation?.let { Types.saveLocation.of(it) },
                saveName?.let { Types.saveName.of(it) }
            )
        }

        /** Type for attributes of this collection */
        class Type(override val name: String) : AttributeCollection.Type<SaveInfo>(SaveInfo)

        /** All member names as strings. */
        object Name {
            /** "save-document-format" member name */
            const val saveDocumentFormat = "save-document-format"
            /** "save-location" member name */
            const val saveLocation = "save-location"
            /** "save-name" member name */
            const val saveName = "save-name"
        }

        /** Types for each member attribute. */
        object Types {
            val saveDocumentFormat = StringType(Tag.mimeMediaType, Name.saveDocumentFormat)
            val saveLocation = UriType(Name.saveLocation)
            val saveName = NameType(Name.saveName)
        }

        /** Defines types for each member of [SaveInfo] */
        companion object : AttributeCollection.Converter<SaveInfo> {
            override fun convert(attributes: List<Attribute<*>>): SaveInfo =
                SaveInfo(
                    extractOne(attributes, Types.saveDocumentFormat),
                    extractOne(attributes, Types.saveLocation),
                    extractOne(attributes, Types.saveName)?.value
                )
        }
    }
}
